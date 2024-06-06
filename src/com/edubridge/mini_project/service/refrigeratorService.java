package com.edubridge.mini_project.service;

import java.util.List;

import com.edubridge.mini_project.model.refrigerator;


public interface refrigeratorService {
	int addrefrigerator (refrigerator r);
	List<refrigerator> findrefrigerators();
	refrigerator findrefrigeratorByName(String Brand);
	int updaterefrigerator(refrigerator r);
	int deleterefrigeratorByName(String Brand);
	void deleteallrefrigerator();

}
