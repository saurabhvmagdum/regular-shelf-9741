package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.build.Course;
import com.masai.exceptions.CourseException;
import com.masai.utility.DBUtil;

public class CourseDaoImpl implements CourseDao{
	
	
	// Add New Course into Database
	@Override
	public String addCourse(Course course) throws CourseException{
		
		String message = "Data Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("insert into course(courseName, courseFee, courseDesc) values(?,?,?)");
			
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getCourseFee());
			ps.setString(3, course.getCourseDesc());
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = "New Course Added Successfully..";	
			}else {
				throw new CourseException("Duplicate Entry");
			}
			
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(e.getMessage());
			
		}
		
		return message;
	}
	
	
	// Search Course With Name
	@Override
	public Course searchCourse(String name) throws CourseException{
		
		Course course = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course where courseName = ?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {		
				
				int cid = rs.getInt("courseId");
				String cname = rs.getString("courseName");
				int cfee = rs.getInt("courseFee");
				String cdesc = rs.getString("courseDesc");
				
				course = new Course(cid, cname, cfee, cdesc);
				
			}else {
				throw new CourseException("Course does not exist.");
			}
			
				
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(e.getMessage());
		}
		
		return course;
	}


	// See All Course Details Present in Database
	@Override
	public List<Course> getAllCourse() throws CourseException {
		
		List<Course> courses = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course");

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int cid = rs.getInt("courseId");
				String cname = rs.getString("courseName");
				int cfee = rs.getInt("courseFee");
				String cdesc = rs.getString("courseDesc");
				
				Course course = new Course(cid, cname, cfee, cdesc);
				
				courses.add(course);
				
			}
			
			if(courses.size() == 0) {
				throw new CourseException("No Course found..");
			}
			
				
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(e.getMessage());
		}
		
		return courses;
	}

	
	// Update details of Course table
	@Override
	public String updateCourseDetails(String str, String set, String name) throws CourseException{
		
		String message = "Course Data Not Updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update course set "+ str +" = ? where courseName = ?");
			
			ps.setString(1, set);
			ps.setString(2, name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = "course Details Updated Successfully..";	
			}else {
				throw new CourseException("Course Not Exist");
			}
			
		} catch (SQLException e) {	
			throw new CourseException(e.getMessage());
			
		}
		
		return message;
	}


	// Delete details from Course table
	@Override
	public String deleteBatch(String cName) throws CourseException {

		String message = "Batch Data Not Updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from course where courseName = ?");
			
			ps.setString(1, cName);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message ="Course Deleted Successfully..";	
			}else {
				throw new CourseException("Course Not Exist");
				
			}
		}catch (SQLException e) {
			
			throw new CourseException("Wrong Data Format");
		}
		
		return message;
		
	}

	
}


