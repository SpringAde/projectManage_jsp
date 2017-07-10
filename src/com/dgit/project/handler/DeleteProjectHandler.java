package com.dgit.project.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JDBCUtil;
import com.dgit.project.model.ProjectDao;

public class DeleteProjectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int id = Integer.parseInt(req.getParameter("id"));
			
			int projcet = ProjectDao.getInstance().deleteById(conn, id);
			
			res.sendRedirect("list.do");
			
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
