package com.edubridge.mini_project.dao;

import java.util.List;

import com.edubridge.mini_project.model.refrigerator;


public interface refrigeratorDao {
	int addrefrigerator(refrigerator r);
	List<refrigerator> findrefrigerators();
	refrigerator findrefrigeratorByName(String Brand);
	int upadterefrigerator(refrigerator r);
	int deleterefrigeratorByName(String Brand);
	void deleteallrefrigerators();
	
	
	

	
	
	

}


