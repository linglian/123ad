/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author lol
 */
public class DBMap extends HashMap<String, LinkedList<Object>> {

    public DBMap() {
        super();
    }

    public static int getLength(DBMap m) {
        return m.values().iterator().next().size();
    }

    public static LinkedList<LinkedList<Object>> toHigh(DBMap m) {
        LinkedList<LinkedList<Object>> list = new LinkedList();
        Set<String> set = m.keySet();
        for (String str : set) {
            list.add(m.get(str));
        }
        return list;
    }

    public static LinkedList<LinkedList<Object>> toRow(DBMap m) {
        LinkedList<LinkedList<Object>> list = new LinkedList();
        LinkedList<LinkedList<Object>> hList = toHigh(m);
        LinkedList<Object>[] gList = hList.toArray(new LinkedList[0]);
        Object[][] g = new Object[gList.length][];
        for (int i = 0; i < gList.length; i++) {
            g[i] = gList[i].toArray();
        }
        int size = DBMap.getLength(m);
        for (int i = 0; i < size; i++) {
            LinkedList<Object> tList = new LinkedList();
            int length = m.size();
            for (int j = 0; j < length; j++) {
                tList.add(g[j][i]);
            }
            list.add(tList);
        }
        return list;
    }

    /**
     * 将传入的DBMap输出到out中
     *
     * @param map
     * @param out
     * @param str
     */
    public void display(PrintStream out, String... str) {
        DBMap map = this;
        if (map == null) {
            return;
        }
        LinkedList[] q = new LinkedList[map.size()];
        int col = str.length;
        String temp = new String();
        // 打印表头，并决定要输出的数据是那些。
        if (col == 0) {
            Set<String> set = map.keySet();
            for (String s : set) {
                q[col++] = map.get(s);
                temp += s + "\t";
            }
        } else {
            for (int i = 0; i < col; i++) {
                q[i] = map.get(str[i]);
                temp += str[i] + "\t";
            }
        }
        int row = q[0].size();
        out.println(temp);
        for (int i = 0; i < row; i++) {
            temp = new String();
            for (int j = 0; j < col; j++) {
                temp += q[j].get(i) + "\t";
            }
            out.println(temp);
        }
    }

}
