<%@page contentType="text/html"  language="java"  import="java.sql.*"%>
<%
String str1=request.getParameter("question1-answer");
String str2=request.getParameter("question2-answer");
String str3=request.getParameter("question3-answer");
String str4=request.getParameter("question4-answer");
String str5=request.getParameter("question5-answer");
String str6=request.getParameter("question6-answer");
String str7=request.getParameter("question7-answer");
String str8=request.getParameter("question8-answer");

int mark=0;
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","Bfeb22658");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT * FROM examTab");
String user = (String)request.getParameter("name");
String rollno = request.getParameter("rollno");
PreparedStatement ps;
ps=con.prepareStatement("insert into marks(rollnumber,username,marks) values(?,?,?);");
while(rs.next())
{
 String dbans1=rs.getString(1);
 String dbans2=rs.getString(2);
 String dbans3=rs.getString(3);
 String dbans4=rs.getString(4);
 String dbans5=rs.getString(5);
 String dbans6=rs.getString(6);
 String dbans7=rs.getString(7);
 String dbans8=rs.getString(8);

 if(str1.equals(dbans1))
 {
 mark=mark+5;
 }
 if(str2.equals(dbans2))
 {
 mark=mark+5;
 }
 if(str3.equals(dbans3))
 {
 mark=mark+5;
 }
 if(str4.equals(dbans4))
 {
 mark=mark+5;
 }
 if(str5.equals(dbans5))
 {
 mark=mark+5;
 }
 if(str6.equals(dbans6))
 {
 mark=mark+5;
 }
 if(str7.equals(dbans7))
 {
 mark=mark+5;
 }
 if(str8.equals(dbans8))
 {
 mark=mark+5;
 }
}
ps.setString(1,rollno);
ps.setString(2,user);
ps.setInt(3,mark);
try{
int rowsInserted = ps.executeUpdate();

}catch(Exception e)
{
e.printStackTrace();
}
ps.close();
con.close();
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="submit.css">
  <title>Result</title>
</head>
<body>
  <div class="container">
    <div class="thanks">
      <h2>Thank you for submission</h2>
      <span style="font-family: Arial Unicode MS, Lucida Grande">
        &#10003; &#10004;
    </span>
    </div>
    <div class="marks">
        <h2>CONGRATULATIONS!!.</h2>
        <p>Your score is <%= mark%>/40</p>
    </div>
    <button><a href="index.jsp">Return to Homepage</a></button>
    
  </div>
  
</body>
</html>