<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps;
 String bookid,bookname,bookauthor,bookdesc,bookprice,bookpublisher,bookqty;

 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","Bfeb22658");

 ps=con.prepareStatement("insert into books values(?,?,?,?,?,?,?);");
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>
<%

 //set form data as param value

 bookid=request.getParameter("bookid");
 bookname=request.getParameter("bookname");
 bookdesc=request.getParameter("bookdesc");
 bookprice=request.getParameter("bookprice");
 bookauthor=request.getParameter("bookauthor");
 bookpublisher=request.getParameter("bookpublisher");
 bookqty=request.getParameter("bookqty");
 try{
 ps.setString(1,bookid);
 ps.setString(2,bookname);
 ps.setString(3,bookdesc);
 ps.setString(4,bookprice);
 ps.setString(5,bookauthor);
 ps.setString(6,bookpublisher);
 ps.setString(7,bookqty);

 //excute the query

 int rowsInserted = ps.executeUpdate();
 }catch(Exception e)
 {
  e.printStackTrace();
 }
 ps.close();
 con.close();
%>
