package com.edubridge.mini_project.service;

import java.util.List;

import com.edubridge.mini_project.dao.refrigeratorDao;
import com.edubridge.mini_project.dao.refrigeratorDaoImpl;
import com.edubridge.mini_project.model.refrigerator;



public class refrigeratorServiceImpl implements refrigeratorService {
	private refrigeratorDao dao = new refrigeratorDaoImpl();

	@Override
	public int addrefrigerator(refrigerator r) {
		// TODO Auto-generated method stub
		return dao.addrefrigerator(r);
	}

	@Override
	public List<refrigerator> findrefrigerators() {
		// TODO Auto-generated method stub
		return dao.findrefrigerators();
	}

	@Override
	public refrigerator findrefrigeratorByName(String Brand) {
		// TODO Auto-generated method stub
		return dao.findrefrigeratorByName(Brand);
	}

	@Override
	public int updaterefrigerator(refrigerator r) {
		// TODO Auto-generated method stub
		return dao.upadterefrigerator(r);
	}

	@Override
	public int deleterefrigeratorByName(String Brand) {
		// TODO Auto-generated method stub
		return dao.deleterefrigeratorByName(Brand);
	}

	@Override
	public void deleteallrefrigerator() {
		// TODO Auto-generated method stub
		dao.deleteallrefrigerators();
	}

}


