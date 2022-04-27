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
  ps = con.prepareStatement("select * from marks");

 }
 catch(Exception ex)
 {
 ex.printStackTrace();
}
 }
%>



 <!DOCTYPE html>
 <html>
   <head>
     <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <title>hitcount</title>
     <meta name="description" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel=stylesheet href="teacher.css">
   </head>
   <body>

     <h2>MARK LIST</h2>
 <div class="table-wrapper">
     <table class="fl-table">

         <tbody>
          <tr>
            <td>Id</td>
            <td>Rollnumber</td>
            <td>Username</td>
            <td>Marks</td>
            <td>Submission time</td>
        </tr>
          <% ResultSet rs=ps.executeQuery();
          while(rs.next())
          {
            String id=rs.getString(1);
            String rollnumber=rs.getString(2);
            String username=rs.getString(3);
            String marks=rs.getString(4);
            String time=rs.getString(5);
            out.println("<tr>");
            out.println("<td>"+id+"</td>");
            out.println("<td>"+rollnumber+"</td>");
            out.println("<td>"+username+"</td>");
            out.println("<td>"+marks+"</td>");
            out.println("<td>"+time+"</td>");
            out.println("</tr>");
          }
          %>
     </tbody>
     </table>
 </div>
 <button class="download" onclick="downloaddata()">Click to Download</button>
 
     
  <script>
  function downloaddata()
  {
  var table = document.getElementsByClassName("fl-table");
  
     /* Declaring array variable */
  var rows =[];
  
  //iterate through rows of table
  for(var i=0,row; row = table[0].rows[i];i++){
     //rows would be accessed using the "row" variable assigned in the for loop
     //Get each cell value/column from the row
     column1 = row.cells[0].innerText;
     column2 = row.cells[1].innerText;
     column3 = row.cells[2].innerText;
     column4 = row.cells[3].innerText;
     column5 = row.cells[4].innerText;
         
  
     /* add a new records in the array */
         rows.push(
             [column1,column2,column3,column4,column5]);
  
  }
   csvContent = "data:text/csv;charset=utf-8,";
    /* add the column delimiter as comma(,) and each row splitted by new line character (\n) */
   rows.forEach(function(rowArray){
       row = rowArray.join(",");
       csvContent += row + "\r\n";
   });
  
         /* create a hidden <a> DOM node and set its download attribute */
  var encodedUri = encodeURI(csvContent);
  var link = document.createElement("a");
  link.setAttribute("href", encodedUri);
  link.setAttribute("download", "content.csv");
  document.body.appendChild(link);
  link.click();
  }
  </script>
   </body>
 </html>
 <%!
 public void jspDestroy()
 {
 try
 {
 //close
ps.close();

 con.close();
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
 }
 }
%>