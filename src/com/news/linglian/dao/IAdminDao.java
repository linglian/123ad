package com.news.linglian.dao;

import com.news.linglian.entity.Admin;

public interface IAdminDao {
	/**
	 * 更新数据库中的对应的Admin对象
	 * 
	 * @param admin
	 *            （传入password为空时，不改变password）
	 * @return 返回1则删除成功，返回0则失败
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public int updateAdmin(Admin admin);

	/**
	 * 删除Admin实例，根据传入的adminid
	 * 
	 * @param admin
	 * @return 返回1则删除成功，返回0则失败
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public int removeAdmin(Admin admin);
	public int removeAdmin(String adminid);

	/**
	 * 插入Admin实例
	 * 
	 * @param admin
	 * @return 返回1则插入成功，0为失败。
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public int insert(Admin admin);

	/**
	 * 获得admin信息
	 * 
	 * @param id
	 * @return 存在则返回实例，不存在则返回空。
	 */
	public Admin getAdmin(String adminid);

	/**
	 * 获得admin信息
	 * 
	 * @param id
	 * @param password
	 * @return 存在则返回实例，不存在则返回空。
	 */
	public Admin getAdmin(String adminid, String password);
}
