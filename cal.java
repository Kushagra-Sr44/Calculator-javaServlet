package com.myServlet;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class cal extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
			throws IOException, ServletException{
		String op=req.getParameter("opt");
		if(op.equals("+")) {
		RequestDispatcher pq=req.getRequestDispatcher("add");
		pq.forward(req, res);
		}
		else if(op.equals("-")) {
			RequestDispatcher pd=req.getRequestDispatcher("sub");
			pd.forward(req,res);
		}
		else if(op.equals("*")) {
			RequestDispatcher pd=req.getRequestDispatcher("mul");
			pd.forward(req,res);
		}
		else if(op.equals("/")) {
			RequestDispatcher pd=req.getRequestDispatcher("div");
			pd.forward(req,res);
		}
		else {
			PrintWriter out=res.getWriter();
			out.print("Wrong operator entered !Enter Correct operator");
		}
		
	}
}