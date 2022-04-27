<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps;

 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","Bfeb22658");

 ps=con.prepareStatement("insert into users(username,password,role,email) values(?,?,?,?);");
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
 String email = request.getParameter("email");
 String role = request.getParameter("role");
 //set form data as param value
 try{
 ps.setString(1,user);
 ps.setString(2,pass);
 ps.setString(3,role);
 ps.setString(4,email);

 //excute the query

 int rowsInserted = ps.executeUpdate();
 out.println(rowsInserted);
if (rowsInserted > 0) {
    out.println("A new user was inserted successfully!");
}
 }catch(Exception e)
 {
  e.printStackTrace();
 }
 ps.close();
 con.close();
 response.sendRedirect("index.jsp");
%>
<%!
 public void jspDestroy()
 {
 try
 {
 //colse

 }
 catch(Exception ex)
 {
 ex.printStackTrace();
 }
 }
%>