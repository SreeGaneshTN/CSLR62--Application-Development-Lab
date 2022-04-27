package com.innovator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/FirstServlet" })
public class firstservelet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {

      String name = request.getParameter("userName");
      String email=request.getParameter("email");
      String mobile=request.getParameter("number");
out.println("      <html>");
out.println(" <head>");
out.println("<title>Servlet Submission by Hidden form field</title>");
out.println("    <link rel=stylesheet href=\"style1.css\">");
out.println("  </head>");
out.println("  <body>");
out.println("    <h2> Details to be sent to servlet by Hidden form fields</h2>");
out.println("<div class=\"table-wrapper\">");
out.println("    <table class=\"fl-table\">");
out.println(" <tbody>");
out.println("<tr>");
out.println(" <td>Username</td>");
out.println(" <td>"+name+"</td>");
out.println(" </tr>");
out.println("<tr>");
out.println(" <td>Email Id</td>");
out.println(" <td>"+email+"</td>");
out.println("        </tr>");
out.println("<tr>");
out.println(" <td>Mobile</td>");
out.println(" <td>"+mobile+"</td>");
out.println(" </tr>");
out.println(" </tbody>");
out.println(" </table>");
out.println("</div>");
out.println("<form action=\"./SecondServlet\">");
out.println("    <input type=\"hidden\" name=\"uname\" value="+name+">");
out.println("    <input type=\"hidden\" name=\"email\" value="+email+">");
out.println("    <input type=\"hidden\" name=\"mobile\" value="+mobile+">");
out.println("<input type=\"submit\" value=\"Click to Submit \">");
out.println("</form>");
out.println("  </body>");
out.println("</html>");
      out.close();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
