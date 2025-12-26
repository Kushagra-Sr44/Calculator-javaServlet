package com.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class add extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException{
	int n1=Integer.valueOf(req.getParameter("n1"));
	int n2=Integer.valueOf(req.getParameter("n2"));
    PrintWriter pw= res.getWriter();
         pw.print("Sum : "+(int)(n1+n2));


}
}