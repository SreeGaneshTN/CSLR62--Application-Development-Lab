<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps;
 String username,email,mobile,userid;
 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","Bfeb22658");
  ps = con.prepareStatement("select * from users");

 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>
<table class="table-user">

  <thead>
   <tr>
     <td>Username</td>
     <td>Email</td>
     <td>Mobile</td>
     <td>More Info</td>
 </tr>
</thead>
<tbody>
   <% ResultSet rs=ps.executeQuery();
   while(rs.next())
   {
     userid=rs.getString(1);
     username=rs.getString(2);
     email=rs.getString(3);
     mobile=rs.getString(4);
   %>
   <tr>
  <td><%= username %></td>
  <td><%= email %></td>
  <td><%= mobile %></td>
  <td><button id="<%= userid %>" class="more-info" onclick="dialog_user(this.id)">More Info</button></td>
  </tr>
  <% }
   %>
</tbody>
</table>