package com.dgit.project.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JDBCUtil;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class ReadProjectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int id = Integer.parseInt(req.getParameter("id"));
			
			Project dao = ProjectDao.getInstance().selectById(conn, id);			
			req.setAttribute("contentView", dao);			
			
			return "/WEB-INF/view/listReadProject.jsp";		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}				
		return null;
	}

}
