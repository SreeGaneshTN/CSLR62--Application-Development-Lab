<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps3;
 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","Bfeb22658");
 ps3= con.prepareStatement("select count(*) from admin where username = ? and password=?");
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>
<%
 
 String user = request.getParameter("username");
 String pass = request.getParameter("password");
 //set form data as param value
 ps3.setString(1,user);
 ps3.setString(2,pass);
 //excute the query
 ResultSet rs1 = ps3.executeQuery();
 if(rs1.next())
 {
   int cnt=0;
   cnt = rs1.getInt(1);
   if(cnt==0)
  {
    response.sendRedirect("invalid.html");
  }
  else
 {
   response.sendRedirect("dashboard.html");
 }
 }
 
 %>
<%!
 public void jspDestroy()
 {
 try
 {
 //close
 ps3.close();
 con.close();
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
 }
 }
%>