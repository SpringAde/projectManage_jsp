package com.dgit.project.handler;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JDBCUtil;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class InsertProjectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/insertProjectForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){	
			Connection conn = null;
			
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			String state = req.getParameter("state");
			
			try{
				conn =ConnectionProvider.getConnection();
				ProjectDao dao = ProjectDao.getInstance();
				
				Project project = new Project(title, content, simpleDate.parse(startDate), simpleDate.parse(endDate), state);				
				dao.insert(conn, project);
				
				req.setAttribute("viewData", dao);				
				res.sendRedirect("list.do");
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
