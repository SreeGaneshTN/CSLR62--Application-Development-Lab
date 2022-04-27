<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps1;
String bookid,bookname,bookauthor,bookdesc,bookprice,bookpublisher,bookqty;
 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","Bfeb22658");
  ps1 = con.prepareStatement("select * from books where bookid=?");
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>
<%
 String bookid = request.getParameter("id");

 //set form data as param value
 ps1.setString(1,bookid);
 //excute the query
 ResultSet rs = ps1.executeQuery();
 if(rs.next())
 {
   bookid=rs.getString(1);
   bookname=rs.getString(2);
   bookdesc=rs.getString(3);
   bookprice=rs.getString(4);
   bookauthor=rs.getString(5);
   bookpublisher=rs.getString(6);
   bookqty=rs.getString(7);

}
   

 %>
 <div class="modal-content">
    
  <span class="close" onclick="toggle()">&times;</span>
  <h2>Book Info</h2>
  <hr>
  <table class="dialog-table">
      <tr>
        <td>Book Id</td>
        <td><%= bookid %></td>

      </tr>
      <tr>
        <td>Book Name</td>
        <td><%= bookname %></td>

      </tr>
      <tr>
        <td>Book Author</td>
        <td><%= bookauthor %></td>

      </tr>
      <tr>
        <td>Book Description</td>
        <td><%= bookdesc %></td>

      </tr>
      <tr>
        <td>Book Price</td>
        <td><%= bookprice %></td>

      </tr>
      <tr>
        <td>Book Publisher</td>
        <td><%= bookpublisher %></td>

      </tr>
      <tr>
        <td>Available</td>
        <td><%= bookqty %></td>

      </tr>
  </table>
  <hr>
</div>

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