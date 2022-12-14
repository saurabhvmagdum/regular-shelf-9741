package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.masai.build.Faculty;
import com.masai.exceptions.FacultyException;
import com.masai.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao {

	
	// Add New Faculty into Database
	@Override
	public String addFaculty(Faculty faculty) throws FacultyException{

		String message = "Data Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			Statement statement = conn.createStatement();
            String sql = "SELECT MAX( facultyId ) FROM faculty";
            
            ResultSet result = statement.executeQuery(sql);
            
            Integer id = 0;
            
            if(result.next()) {
            	id = result.getInt("max( facultyId )");
            }
            
            id = id + 1;
            String text = String.format("%03d", id);
			String fname = faculty.getFname().toLowerCase();
			String username = fname + text;
			String password = "pass123";
			
			PreparedStatement ps1 = conn .prepareStatement("insert into Faculty(facultyFname, facultyLname, facultyAddress, facultyState, facultyPin, mobile, email, username, password) values(?,?,?,?,?,?,?,?,?)");
			
			ps1.setString(1, faculty.getFname());
			ps1.setString(2, faculty.getLname());
			ps1.setString(3, faculty.getAddress());
			ps1.setString(4, faculty.getState());
			ps1.setString(5, faculty.getPin());
			ps1.setString(6, faculty.getMobile());
			ps1.setString(7, faculty.getEmail());
			ps1.setString(8, username);
			ps1.setString(9, password);
			int x = ps1.executeUpdate();
			
			if(x>0) {		
				message ="Faculty Added Successfully..";	
			}
			
		}catch(SQLException e) {
			
			message =e.getMessage();
			
		}
		
		return message;
	}

	
	// Search Faculty With Name
	@Override
	public List<Faculty> searchFacultyByName(String name) throws FacultyException{
		
		List<Faculty> facultys = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("Select * from Faculty where facultyFname = ?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
		
			while(rs.next()) {		
				int id = rs.getInt("facultyId");
				String fname = rs.getString("facultyFname");
				String lname = rs.getString("facultyLname");
				String address = rs.getString("facultyAddress");
				String state = rs.getString("facultyState");
				String pin = rs.getString("facultyPin");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");

				Faculty faculty = new Faculty(id,fname,lname,address,state,pin,mobile,email,username);
				
				facultys.add(faculty);
			}
			
			if(facultys.size() == 0)
				throw new FacultyException("Faculty does not exist with this name.");
			
			
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new FacultyException(e.getMessage());
		}
		
		
		return facultys;
	}

	
	// Search Faculty With id
	@Override
	public Faculty searchFacultyById(int id) throws FacultyException {
		
		Faculty faculty = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("Select * from Faculty where facultyId = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
		
			if(rs.next()) {		
				int fid = rs.getInt("facultyId");
				String fname = rs.getString("facultyFname");
				String lname = rs.getString("facultyLname");
				String address = rs.getString("facultyAddress");
				String state = rs.getString("facultyState");
				String pin = rs.getString("facultyPin");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");

				faculty = new Faculty(fid,fname,lname,address,state,pin,mobile,email,username);
				
			}else
			
				throw new FacultyException("Faculty does not exist with this id.");
			
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new FacultyException(e.getMessage());
		}
		
		return faculty;
	}
	
	
	// See All Faculty Details Present in Database
	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
		
		List<Faculty> facultys = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from faculty");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				int id = rs.getInt("facultyId");
				String fname = rs.getString("facultyFname");
				String lname = rs.getString("facultyLname");
				String address = rs.getString("facultyAddress");
				String state = rs.getString("facultyState");
				String pin = rs.getString("facultyPin");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");

				Faculty faculty = new Faculty(id,fname,lname,address,state,pin,mobile,email,username);
				
				facultys.add(faculty);
			}
			
			if(facultys.size() == 0)
				throw new FacultyException("No Student found..");

			
		}catch(SQLException e) {
			e.printStackTrace();
			
			throw new FacultyException(e.getMessage());
		}
		
		
		
		return facultys;
	}


	
	// Update details of faculty table
	@Override
	public String updateFacultyDetails(String str, String set, int id) throws FacultyException{

		String message ="Data Not Updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update faculty set "+ str +" = ? where facultyId = ?");
			
			ps.setString(1, set);
			ps.setInt(2, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = "Faculty Details Updated Successfully..";	
			}
			
		}catch(SQLException e) {
			
			message = e.getMessage();
			
		}
		
		return message;
	}


	
	// Delete details of faculty table
	@Override
	public String deleteFaculty(int facultyId) throws FacultyException {
		
		String message = "Faculty Data Not Updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("delete from faculty where facultyId = ?");
			
			ps.setInt(1, facultyId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = "Faculty Deleted Successfully..";
				
			}else {
				throw new FacultyException("Faculty Not Exist");
				
			}
			
		} catch (SQLException e) {

			throw new FacultyException("Wrong Data Format");
		}
		
		return message;
	}


}
