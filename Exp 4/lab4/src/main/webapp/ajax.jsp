<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
  Connection con;
  String t1,t2;
    PreparedStatement ps1;
    public void jspInit()
    {
    try
    {
     Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","Bfeb22658");
     ps1 = con.prepareStatement("select * from USERS where username = ? and email=?");
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
   }
    }
   %>

<%
		String user=request.getParameter("username");
		String email=request.getParameter("email");
 //set form data as param value
 ps1.setString(1,user);
 ps1.setString(2,email);
 //excute the query
 ResultSet rs = ps1.executeQuery();

 while(rs.next())
 {
    t1=rs.getString(2);
    t2=rs.getString(3);
    //out.println("<h3>Username is "+t1+"</h3>");
    //out.println("<h3>email is "+t2+"</h3>");
 }
%>
<h3>Username is <%= t1 %></h3>  
<h3>password is <%= t2 %></h3>
<%!
 public void jspDestroy()
 {
 try
 {
 //close
ps1.close();

 con.close();
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
 }
 }
%>