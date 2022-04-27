package com.innovator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/SecondServlet" })
public class secondservelet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      String name = request.getParameter("uname");
      String email=request.getParameter("email");
      String number=request.getParameter("mobile");
out.println("   <html >");
out.println("<head>");
out.println("<title>Servlet Landing by Hidden form field</title><link rel=stylesheet href=\"style2.css\">");
out.println("</head>");
out.println("<body>");
out.println("  <div class=\"container\">");
out.println("    <h1>Welcome "+name+"</h1>");
out.println("    <h1>Email id is "+email+"</h1>");
out.println("    <h1>mobile number is "+number+"</h1>");
out.println("    <h1> Details got through hidden form field</h1>");
out.println("  </div>");
out.println("  <button><a href=\"./index.html\">again</a></button>");
out.println("</body>");
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
  }// </editor-fold>

}
