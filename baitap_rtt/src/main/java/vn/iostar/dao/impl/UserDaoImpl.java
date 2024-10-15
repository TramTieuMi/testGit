package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.config.DBConnectionSQLServer;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModels;
//import vn.iotstar.configs.DBConnectSQL;
//import vn.iotstar.dao.impl.UserDaoImpl;
//import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectionSQLServer implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public List<UserModels> findAll() {
		String sql = "SELECT * FROM ThongTinUser";
        try {
            conn = new DBConnectionSQLServer().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                List<UserModels> list = new ArrayList<>();
                list.add(new UserModels(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("fullname"),
                    rs.getString("images"),
                    rs.getInt("roleId"),
                    rs.getString("phone"),
                    rs.getDate("createDate"),
                    rs.getString("code")
                ));
                // ... xử lý danh sách user ở đây ...
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public UserModels findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModels user) {
		String sql = "INSERT INTO ThongTinUser (username, password, images, fullname, email, phone, roleid, createddate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectionSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getImage());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setInt(7, user.getRoleid());
			ps.setDate(8, user.getCreatedDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public UserModels findByUsername(String username) {
		String sql = "SELECT * FROM ThongTinUser WHERE username = ? ";
		try {
			conn = new DBConnectionSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModels user = new UserModels();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("image"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatedDate(rs.getDate("createDate"));
				user.setCode(rs.getString("code"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public static void main(String[] args) {
//		try {
//			IUserDao userDao = new UserDaoImpl(); 
//			System.out.println(userDao.findByUsername("tieumi"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	@Override
	public void insertregister(UserModels user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkExistEmail(String Email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(String username, String password) {
		// TODO Auto-generated method stub
		
	}
//	public static void main(String[] args){
//		try 
//		{
//			IUserDao userDao=new UserDaoImpl();		
//			
//			userDao.insert(new UserModels("usename", "email", "password", "fullname", 3, null));
//			System.out.println(userDao.findAll());
//			
//		
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
	    try 
	    {
	    	UserDaoImpl userDao = new UserDaoImpl();
	    	System.out.println(userDao.findByUsername("tieumi"));
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
