package com.dgit.project.handler;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JDBCUtil;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class ModifyProjectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Connection conn = null;

			try {
				conn = ConnectionProvider.getConnection();
				ProjectDao dao = ProjectDao.getInstance();
				Project project = dao.selectById(conn, id);
				req.setAttribute("viewData", project);
				return "/WEB-INF/view/modifyProjectForm.jsp";				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
			
		}else if(req.getMethod().equalsIgnoreCase("post")){
			Connection conn = null;			
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
			
			int id = Integer.parseInt(req.getParameter("id"));		
			String title = req.getParameter("title");
			String content = req.getParameter("content");			
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			String state = req.getParameter("state");
						
			try{
				conn = ConnectionProvider.getConnection();
				ProjectDao dao = ProjectDao.getInstance();
				
				Project project = new Project(id, title, content, simpleDate.parse(startDate), simpleDate.parse(endDate), state);
				dao.update(conn, project);
				
				req.setAttribute("viewData", project);
				//res.sendRedirect("list.do");	//주소창이 바뀌고 이동
				return "/read.do?id="+id;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
