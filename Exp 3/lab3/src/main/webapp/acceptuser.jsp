<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
 Connection con;
 PreparedStatement ps1, ps2,ps3;
 public void jspInit()
 {
 try
 {
  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","Bfeb22658");
  ps1 = con.prepareStatement("select * from USERS where username = ? and password=?");

 ps2 = con.prepareStatement("select * from USERS");
 ps3= con.prepareStatement("select count(*) from USERS where username = ? and password=?");
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>
<%
 String param = request.getParameter("s1");
 if(param =="link")
 {
 ResultSet rs = ps2.executeQuery();
 out.println("<table>");
 while(rs.next())
 {
 out.println("<tr>");
 out.println("<td>"+rs.getString(1)+"</td>");
 out.println("<td>"+rs.getString(2)+"</td");
 out.println("</tr>");
 }
 out.println("</table>");
 rs.close();
 }
 else
 {
 String user = request.getParameter("username");
 String pass = request.getParameter("password");
 //set form data as param value
 ps1.setString(1,user);
 ps1.setString(2,pass);
 ps3.setString(1,user);
 ps3.setString(2,pass);
 //excute the query
 ResultSet rs = ps1.executeQuery();
 ResultSet rs1 = ps3.executeQuery();
 if(rs1.next())
 {
   int cnt=0;
   cnt = rs1.getInt(1);
   if(cnt==0)
  {
    response.sendRedirect("invalid.html");

  }
 }
 if (rs.next())
 {
 String s=rs.getString(4);
 String role1="Student";
 String role2="Teacher";
 if(role2.equals(s))
 {
  response.sendRedirect("teacher.jsp");
 }
}}

 %>
 <!DOCTYPE html>
 <html lang="en">
 <head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="inst.css">
   <title>Instruction Page</title>
 </head>
 <body>
   <% String username = request.getParameter("username");%>
   <h2 class="welcome">Welcome <%= username %></h2>
   <div class="wrapper">
     <h2>Instructions to Note</h2>
     <div class="instructions">
       <ol>
         <li>There are total of 8 Questions in the Test-No Negative marking</li>
         <li>All are of Multiple Choice Questions-Each Question carries 5 marks</li>
         <li>All Questions are Mandatory</li>
         <li>Make Sure to complete the Exam within the Time window - 10 minutes</li>
         <li>Please refrain from indulging in any Malpractices.</li>
         <li>Make sure to have proper working Internet and power connectivity</li>
       </ol>
       <h1>All the Very Best</h1>
       <form action="examclient.jsp">
         <input type="hidden" name="name" value="<%= username %>">
         <input type="number" name="rollno" placeholder="Enter your Rollnumber">
         <input type="submit" value="Click Here to start the test">
       </form>
     </div>
   </div>
   
 </body>
 </html>



<%!
 public void jspDestroy()
 {
 try
 {
 //close
ps1.close();
 ps2.close();
 ps3.close();
 con.close();
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
 }
 }
%>