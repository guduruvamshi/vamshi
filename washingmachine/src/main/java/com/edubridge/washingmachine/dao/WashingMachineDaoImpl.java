package com.edubridge.washingmachine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.washingmachine.model1.WashingMachine;
import com.edubridge.washingmachine.utils.DBUtils;

public class WashingMachineDaoImpl implements WashingMachineDao {
	@Override
	public int addWashingMachine(WashingMachine w) {
		String INSERT = " insert into WashingMachine( modelno,brand,price,rating,warrenty) values(?,?,?,?,?)";
		Connection con = DBUtils.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setInt(1, w.getModelno());
			ps.setString(2, w.getBrand());
			ps.setFloat(3, w.getPrice());
			ps.setFloat(4, w.getRating());
			ps.setString(5, w.getWarrenty());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}

	@Override
	public List<WashingMachine> getAllWashingMachine() {
		String SELECT = "select * from WashingMachine";
		Connection con = DBUtils.getConnection();
		List<WashingMachine> WashingMachines = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WashingMachine w = new WashingMachine();
				w.setModelno(rs.getInt("modelno"));
				w.setBrand(rs.getString("brand"));
				w.setPrice(rs.getFloat("price"));
				w.setRating(rs.getFloat("rating"));
				w.setWarrenty(rs.getString("warrenty"));
				WashingMachines.add(w);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return WashingMachines;
	}

	@Override
	public WashingMachine getWashingMachine(String brand) {
		String SELECT_BY_NAME = "select * from WashingMachine  where brand=?";
		Connection con = DBUtils.getConnection();

		WashingMachine wash = new WashingMachine();

		try {
			PreparedStatement ps = con.prepareStatement(SELECT_BY_NAME);
			ps.setString(1, brand);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				wash.setModelno(rs.getInt("modelno"));
				wash.setBrand(rs.getString("brand"));
				wash.setPrice(rs.getFloat("price"));
				wash.setRating(rs.getFloat("rating"));
				wash.setWarrenty(rs.getString("warrenty"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wash;
	}

	@Override
	public int updateWashingMachine(WashingMachine w) {

		String UPDATE = "update WashingMachine SET modelno = ?, brand = ?, price = ?,rating=?,wrrenty=? where modelno = ?";
		Connection con = DBUtils.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setInt(1, w.getModelno());
			ps.setString(2, w.getBrand());
			ps.setFloat(3, w.getPrice());
			ps.setFloat(4, w.getRating());
			ps.setString(5, w.getWarrenty());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int deleteWashingMachine(String Brand) {
		String DELETE = "delete from WashingMachine where Brand = ?";
		Connection con = DBUtils.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE);
			ps.setString(1, Brand);
			status = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void deleteAllWashingMachine() {
		String DELETE_ALL = "delete from WashingMachine";
		Connection con = DBUtils.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_ALL);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkModelExists(int modelno) {
		String query = "SELECT * FROM WashingMachine WHERE modelno = ?";
		Connection con = DBUtils.getConnection();
		boolean exists = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, modelno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				exists = rs.getInt(1) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exists;
	}
}
