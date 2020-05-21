package com.learning.spring.IDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.spring.UserModel.UserModel;

@Component
public class IDAO_imp implements IDAO {
	String url = "jdbc:h2:tcp://localhost/~/test";
	String user = "sa";
	String pwd = "";
	Connection conn;
	UserModel model;
	PreparedStatement stmt;

	@Override
	public boolean getConnection() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (conn != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<UserModel> getRecords() {
		List<UserModel> userlist = new ArrayList();
		// System.out.println("inside records");

		if (getConnection()) {
			try {
				Statement statement = conn.createStatement();
				String query = "select * from data ";
				ResultSet resultset = statement.executeQuery(query);
				while (resultset.next()) {
					model = new UserModel();
					model.setId(resultset.getInt("ID"));
					model.setName(resultset.getString("Name"));
					model.setEmail(resultset.getString("Email"));
					model.setAddr(resultset.getString("Addr"));
					model.setPhone(resultset.getString("Phone"));

					userlist.add(model);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return userlist;
	}

	@Override
	public boolean insertingRecords(UserModel model) {
		int rowInserted = 0;
		if (getConnection()) {
			System.out.println("Connection is SuccessFully");
			String query = "insert into data  values (?,?,?,?,?)";
			try {
				PreparedStatement preparestmt = conn.prepareStatement(query);
				preparestmt.setInt(1, model.getId());
				preparestmt.setString(2, model.getName());
				preparestmt.setString(3, model.getEmail());
				preparestmt.setString(4, model.getAddr());
				preparestmt.setString(5, model.getPhone());

				rowInserted = preparestmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (rowInserted > 0) {
			return true;
		} else {
			return false;
		}
	}

}
