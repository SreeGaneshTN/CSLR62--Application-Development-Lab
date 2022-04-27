package com.example;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class hitcount extends HttpServlet {
 public void doGet(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {
HttpSession session = req.getSession(true);
         
      // Get session creation time.
      Date createTime = new Date(session.getCreationTime());
         
      // Get last access time of this web page.
      Date lastAccessTime = new Date(session.getLastAccessedTime());

      String title = "Welcome Back to my website";
      Integer visitCount = 0;
      String visitCountKey = new String("visitCount");
      String userIDKey = new String("userID");
      String userID = new String("ABCD");

      // Check if this is new comer on your web page.
      if (session.isNew()) {
         title = "Welcome to my website";
         session.setAttribute(userIDKey, userID);
      } else {
         visitCount = (Integer)session.getAttribute(visitCountKey);
         visitCount = visitCount + 1;
         userID = (String)session.getAttribute(userIDKey);
      }
      session.setAttribute(visitCountKey,  visitCount);

      // Set response content type
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();

      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title>"+"<link rel=\"stylesheet\" href=\"style.css\">"+"</head>\n" +            
            "<body>\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<h2>Session Infomation</h2>\n" +
               "<div class=\"table-wrapper\">"+
               "<table class=\"fl-table\" >\n" +
                  "<thead>"+
                  "<tr>\n" +
                     "  <th>Session info</th><th>value</th></tr>\n" +
                  "</thead>"+ 
                  "<tbody>"+
                  "<tr>\n" +
                     "  <td>id</td>\n" +
                     "  <td>" + session.getId() + "</td></tr>\n" +
                  "<tr>\n" +
                     "  <td>Creation Time</td>\n" +
                     "  <td>" + createTime + "  </td></tr>\n" +
                  "<tr>\n" +
                     "  <td>Time of Last Access</td>\n" +
                     "  <td>" + lastAccessTime + "  </td></tr>\n" +
                  "<tr>\n" +
                     "  <td>User ID</td>\n" +
                     "  <td>" + userID + "  </td></tr>\n" +
                  "<tr>\n" +
                     "  <td>Number of visits</td>\n" +
                     "  <td>" + visitCount + "</td></tr>\n" +
                  "</tbody>"+
               "</table>\n" +
               "</div>"+
            "</body></html>"
      );
 }
}
