package com.edubridge.mini_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.mini_project.model.refrigerator;
import com.edubridge.mini_project.util.DBUtils;



public class refrigeratorDaoImpl implements refrigeratorDao{
	static Connection con = DBUtils.getConnection();
    @Override
	public int addrefrigerator(refrigerator r) {
		
		String INSERT_QUERY = "insert into refrigerator(brand,price,colour,star_rating) values(?,?,?,?)";
		int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, r.getBrand());
			ps.setInt(2, r.getPrice());
			ps.setString(3, r.getColour());
			ps.setString(4, r.getStar_rating());
			status = ps. executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
    @Override
	public List<refrigerator> findrefrigerators() {
		// TODO Auto-generated method stub
		String SELECT_QUERY = "select * from refrigerator";
		List<refrigerator> refrigeratorList = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				refrigerator r = new refrigerator();
				r.setId(rs.getInt("Id"));
				r.setBrand(rs.getString("Brand"));
				r.setPrice(rs.getInt("Price"));
				r.setColour(rs.getString("colour"));
				r.setStar_rating(rs.getString("Star_rating"));
				refrigeratorList.add(r);
				
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return refrigeratorList;
	}

	public refrigerator findrefrigeratorByName(String Brand) {
		// TODO Auto-generated method stub
		String SELECT_QUERY = "select * from refrigerator where brand = ?";
		refrigerator r = null;
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1,  Brand);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				r = new refrigerator();
				r.setId(rs.getInt("Id"));
				r.setBrand(rs.getString("brand"));
				r.setPrice(rs.getInt("price"));
				r.setColour(rs.getString("colour"));
				r.setStar_rating(rs.getString("star_rating"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public int upadterefrigerator(refrigerator r) {
		String UPDATE_QUERY = "update refrigerator set brand=?,price=?,colour=? ,star_rating= ? where id=?";
		int status = 0;
				
				try {
					PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
					
					ps.setString(1, r.getBrand());
					ps.setInt(2, r.getPrice());
					ps.setString(3, r.getColour());
					ps.setString(4, r.getStar_rating());
					ps.setInt(5,  r.getId());
					status = ps. executeUpdate();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				return status;
	}
	

	@Override
	public int deleterefrigeratorByName(String Brand) {
		// TODO Auto-generated method stub
		String DELETE_QUERY = "delete from refrigerator where brand=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1,Brand);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void deleteallrefrigerators(){
		// TODO Auto-generated method stub
		String DELETE_QUERY = "delete from refrigerator";
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	

}
