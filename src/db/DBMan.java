package db;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

public class DBMan {

    public static String path = "/数据库链接信息.properties";
    private String drivers;
    private String url;
    private String user;
    private String passwd;

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static DBMan instance;

    private boolean isLoadClass;

    /**
     * 修改数据库链接信息properties路径
     *
     * @param path
     */
    public static void setPath(String path) {
        DBMan.path = path;
    }

    private DBMan() throws IOException {
        reload();
    }

    /**
     * 重新载入数据库链接信息
     *
     * @throws IOException
     */
    public void reload() throws IOException {
        InputStream in = DBMan.class.getResourceAsStream(path);
        Properties pro = new Properties();
        pro.load(in);
        isLoadClass = false;
        drivers = pro.getProperty("drivers");
        url = pro.getProperty("url");
        user = pro.getProperty("user");
        passwd = pro.getProperty("passwd");
    }

    /**
     * 获得DBMan对象实例
     *
     * @return DBMan对象实例
     * @throws IOException
     */
    public static DBMan getInstance() throws IOException {
        if (instance == null) {
            instance = new DBMan();
        }
        return instance;
    }

    /**
     * 执行数据库查询操作（只返回一个，请根据主键来查询）
     *
     * @param clazz 必须为JavaBean
     * @param sql
     * @param obj 可选参数，每个参数对应sql里的，每一个“？”
     * @return 传入Class对应的一个实例
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public synchronized <T> T queryById(Class<T> clazz, String sql,
            Object... obj) throws ClassNotFoundException, SQLException,
            InstantiationException, InvocationTargetException,
            IllegalAccessException {
        try {
            open();
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                stmt.setObject(i + 1, obj[i]);
            }
            rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            List<T> all = new ArrayList();
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                    BeanUtils.copyProperty(t, metaData.getColumnName(i), rs.getObject(i));
                }
                return t;
            }
            return null;
        } finally {
            close();
        }
    }

    /**
     * 执行数据库查询操作
     *
     * @param clazz 必须为JavaBean
     * @param sql
     * @param obj 可选参数，每个参数对应sql里的，每一个“？”
     * @return 传入Class对应的List列表
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public synchronized <T> List<T> query(Class<T> clazz, String sql,
            Object... obj) throws ClassNotFoundException, SQLException,
            InstantiationException, InvocationTargetException,
            IllegalAccessException {
        try {
            open();
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                stmt.setObject(i + 1, obj[i]);
            }
            rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            List<T> all = new ArrayList();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                    BeanUtils.copyProperty(t, metaData.getColumnName(i), rs.getObject(i));
                }
                all.add(t);
            }
            return all;
        } finally {
            close();
        }
    }

    /**
     * 执行操作库查询操作
     *
     * @param sql
     * @param obj
     * @return返回DBMap，DBMap为HashMap，键为列名，值为列值
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public synchronized DBMap query(String sql, Object... obj)
            throws ClassNotFoundException, SQLException {
        try {
            DBMap map = new DBMap();
            open();
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                stmt.setObject(i + 1, obj[i]);
            }
            rs = stmt.executeQuery();
            LinkedList<String> list = new LinkedList();// 存储表头名称
            int col = rs.getMetaData().getColumnCount();// 获取列数
            // 根据表头名称建立键值对
            for (int i = 0; i < col; i++) {
                LinkedList<Object> tList = new LinkedList();
                list.add(rs.getMetaData().getColumnName(i + 1));
                map.put(list.getLast(), tList);
            }
            while (rs.next()) {
                for (int i = 0; i < col; i++) {
                    LinkedList<Object> tList = map.get(list.get(i));
                    tList.add(rs.getObject(i + 1));
                }
            }
            return map;
        } finally {
            close();
        }
    }

    /**
     * 执行数据库更新操作
     *
     * @param sql
     * @param obj
     * @return 返回更新行数
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public synchronized int update(String sql, Object... obj)
            throws ClassNotFoundException, SQLException {
        try {
            open();
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                stmt.setObject(i + 1, obj[i]);
            }
            int num = stmt.executeUpdate();
            return num;
        } finally {
            close();
        }
    }

    private synchronized void open() throws ClassNotFoundException,
            SQLException {
        if (isLoadClass == false) {
            Class.forName(drivers);
            isLoadClass = true;
        }
        conn = DriverManager.getConnection(url, user, passwd);
        if (conn == null) {
            throw new ClassNotFoundException("数据库连接失败!请检查数据库连接信息!---错误代码: open()");
        }
        conn.setAutoCommit(true);
    }

    private synchronized void close() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
