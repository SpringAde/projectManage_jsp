package com.dgit.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dgit.jdbc.JDBCUtil;

public class ProjectDao {	
	private static final ProjectDao dao = new ProjectDao();	
	
	public static ProjectDao getInstance() {
		return dao;
	}
	
	private ProjectDao() {	}
	
	public int insert(Connection conn, Project project) throws SQLException{	
		PreparedStatement pstmt = null;
		
		try{
			String query = "INSERT INTO project (title, content, startdate, enddate, state) VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, project.getTitle());
			pstmt.setString(2, project.getContent());
			pstmt.setTimestamp(3, new Timestamp(project.getStartDate().getTime()));
			pstmt.setTimestamp(4, new Timestamp(project.getEndDate().getTime()));
			pstmt.setString(5, project.getState());
			int result = pstmt.executeUpdate();			
			return result;
			
		}finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<Project> selectByList(Connection conn) throws SQLException{
		List<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try{
			String query = "select * from project";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();			
			
			while(rs.next()){
				Project project = new Project();
				project.setId(rs.getInt("id"));
				project.setTitle(rs.getString("title"));
				project.setContent(rs.getString("content"));				
				project.setStartDate(rs.getDate("startDate"));
				project.setEndDate(rs.getDate("endDate"));				
				project.setState(rs.getString("state"));
				list.add(project);			
			}
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return null;
	}
	
	
	public Project selectById(Connection conn, int id) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select * from project where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				Project project = new Project();
				project.setId(rs.getInt("id"));
				project.setTitle(rs.getString("title"));
				project.setContent(rs.getString("content"));
				project.setStartDate(new Date(rs.getTimestamp("startDate").getTime()));
				project.setEndDate(new Date(rs.getTimestamp("endDate").getTime()));
				project.setState(rs.getString("state"));
				return project;				 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return null;
	}
	
	public int deleteById (Connection conn, int id) throws SQLException{
		PreparedStatement pstmt = null;
		
		try{
			String query =  "delete from project where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return id;				
	}
	
	public int update(Connection conn, Project project) throws SQLException{
		PreparedStatement pstmt = null;
		
		try{
			String query = "update project set title=?, content=?, startdate=?, enddate=?, state=? where id=?";
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, project.getTitle());
			pstmt.setString(2, project.getContent());
			pstmt.setTimestamp(3, new Timestamp(project.getStartDate().getTime()));
			pstmt.setTimestamp(4, new Timestamp(project.getEndDate().getTime()));
			pstmt.setString(5, project.getState());
			pstmt.setInt(6, project.getId());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();			
		}finally {
			JDBCUtil.close(pstmt);
		}
		return 0;
	}

	
	
	
	
}
