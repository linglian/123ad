package com.news.linglian.serviceImpl;

import com.news.linglian.dao.IAdminDao;
import com.news.linglian.daoImpl.IAdminDaoImpl;
import com.news.linglian.entity.Admin;
import com.news.linglian.service.IAdminService;

public class IAdminServiceImpl implements IAdminService {
	IAdminDao iad = null;

	public IAdminServiceImpl() {
		iad = new IAdminDaoImpl();
	}

	@Override
	public int updateAdmin(Admin admin) {
		return iad.updateAdmin(admin);
	}

	@Override
	public int removeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return iad.removeAdmin(admin);
	}

	@Override
	public int removeAdmin(String adminid) {
		// TODO Auto-generated method stub
		return iad.removeAdmin(adminid);
	}

	@Override
	public int insert(Admin admin) {
		// TODO Auto-generated method stub
		return iad.insert(admin);
	}

	@Override
	public Admin getAdmin(String adminid) {
		// TODO Auto-generated method stub
		return iad.getAdmin(adminid);
	}

	@Override
	public Admin getAdmin(String adminid, String password) {
		// TODO Auto-generated method stub
		return iad.getAdmin(adminid, password);
	}

}
