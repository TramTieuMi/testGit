package vn.iostar.dao.impl;
import vn.iostar.config.DBConnectionSQLServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.util.List;
import java.util.Locale.Category;

import vn.iostar.dao.ICategoryDAO;
import vn.iostar.models.CategoryModel;

public class CategoryDaoImpl implements ICategoryDAO{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<CategoryModel> findAll() {
		String sql = "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectionSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getInt("categoryname"));
				category.setImages(rs.getInt("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "Select * from categories where categoryid=?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectionSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getInt("categoryname"));
				category.setImages(rs.getInt("images"));
				category.setStatus(rs.getInt("status"));
				
			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO categories(categoryname, images, status) VALUSE (?,?,?)";
	
		try {
			conn = new DBConnectionSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close()l;
			while(rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getInt("categoryname"));
				category.setImages(rs.getInt("images"));
				category.setStatus(rs.getInt("status"));
				
			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


}
