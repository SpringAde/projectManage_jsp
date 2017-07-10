package com.dgit.project.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JDBCUtil;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class ListProjectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try{
			conn = ConnectionProvider.getConnection();
			ProjectDao dao = ProjectDao.getInstance();
			
			List<Project> list = dao.selectByList(conn);
			req.setAttribute("viewData", list);
			
			return "/WEB-INF/view/listProject.jsp";	
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
