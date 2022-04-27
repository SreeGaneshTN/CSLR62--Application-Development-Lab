<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps;
 String bookid,bookname,bookauthor;
 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","Bfeb22658");
  ps = con.prepareStatement("select * from books");

 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>
<table class="table-book">

  <thead>
   <tr>
     <td>Bookid</td>
     <td>Book Name</td>
     <td>Book Author</td>
     <td>More Info</td>
 </tr>
</thead>
<tbody>
   <% ResultSet rs=ps.executeQuery();
   while(rs.next())
   {
     bookid=rs.getString(1);
     bookname=rs.getString(2);
     bookauthor=rs.getString(5);
   %>
   <tr>
  <td><%= bookid %></td>
  <td><%= bookname %></td>
  <td><%= bookauthor %></td>
  <td><button id="<%= bookid %>" class="more-info" onclick="dialog(this.id)">More Info</button></td>
  </tr>
  <% }
   %>
</tbody>
</table>