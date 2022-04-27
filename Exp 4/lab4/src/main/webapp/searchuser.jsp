<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps1;
String userid,username,email,mobilenumber,gender,country,booksbuy;
 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","Bfeb22658");
  ps1 = con.prepareStatement("select * from users where userid=?");
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>
<%
 String userid = request.getParameter("id");

 //set form data as param value
 ps1.setString(1,userid);
 //excute the query
 ResultSet rs = ps1.executeQuery();
 if(rs.next())
 {
   userid=rs.getString(1);
   username=rs.getString(2);
   email=rs.getString(3);
   mobilenumber=rs.getString(4);
   gender=rs.getString(5);
   country=rs.getString(6);
   booksbuy=rs.getString(7);

}
   

 %>
 <div class="modal-content">
    
  <span class="close" onclick="toggle()">&times;</span>
  <h2>User Info</h2>
  <hr>
  <table class="dialog-table">
      <tr>
        <td>User Id:</td>
        <td><%= userid %></td>

      </tr>
      <tr>
        <td>UserName:</td>
        <td><%= username %></td>

      </tr>
      <tr>
        <td>Email Id:</td>
        <td><%= email %></td>

      </tr>
      <tr>
        <td>Phone Number</td>
        <td><%= mobilenumber %></td>

      </tr>
      <tr>
        <td>Gender</td>
        <td><%= gender %></td>

      </tr>
      <tr>
        <td>Country</td>
        <td><%= country %></td>

      </tr>
      <tr>
        <td>Books Bought</td>
        <td><%= booksbuy %></td>

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