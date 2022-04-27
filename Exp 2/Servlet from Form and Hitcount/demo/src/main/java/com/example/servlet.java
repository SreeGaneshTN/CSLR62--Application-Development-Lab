package com.example;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

public class servlet extends HttpServlet{
  public void processRequest(HttpServletRequest request,HttpServletResponse response)
  {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out;
    try
    {
    out=response.getWriter();
    String user=request.getParameter("user");
    String email=request.getParameter("email");
    String mobile=request.getParameter("number");
    out.println("<html>");
    out.println("<head><title>Servlet landing</title><link rel=\"stylesheet\" href=\"style2.css\">"+"</head>\n");
    out.println("<body>");
    out.println("<div class=\"container\">");
    out.println("<h3>Welcome "+user+"</h3>");
    out.println("<h3>Your email is "+email+"</h3>");
    out.println("<h3>Contact: "+mobile+"</h3>");
    out.println("<hr>");
    out.println("<h3>Explore the Unexplored</h3>");
    out.println("<h3>New servlet at "+request.getContextPath()+"</h3>");
    out.println("</div>");
    out.println("<button><a href=\"./index.html\">Again</a></button>");
    out.println("</body>");
    out.println("</html>");
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  @Override
  public void doGet(HttpServletRequest request,HttpServletResponse response)
  throws ServletException,IOException{processRequest(request, response);
  }
  
  @Override
  public void doPost(HttpServletRequest request,HttpServletResponse response)
  throws ServletException,IOException{processRequest(request, response);}

}
