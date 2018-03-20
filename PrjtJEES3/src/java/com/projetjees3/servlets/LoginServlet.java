
package com.projetjees3.servlets;

import com.projetjees3.beans.UserBean;
import com.projetjees3.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public LoginServlet()
     {
         super();
     }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try
		{	    

		     UserBean user = new UserBean();
		     user.setEmail(request.getParameter("email"));
		     user.setPsw(request.getParameter("pass"));
		     user = UserDAO.login(user);
		     if (user.isValid())
		     {
			        
		          HttpSession session = request.getSession();
                          //nt id = session.getAttribute("users").getIdUser();
		          session.setAttribute("currentSessionUser",user);
                          String encodedURL = response.encodeRedirectURL("/ProjetJEES3/profiledoc");
                          System.out.println("encoded URL:"+encodedURL);
                          response.sendRedirect(encodedURL);
                          //response.sendRedirect("/ProjetJEES3/profiledoc");  
		     } 
			        
		     else {
		         //JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect veuillez s'inscrire"); 
                         response.sendRedirect("/ProjetJEES3/home?Error2=NotFound#login");
                     } }
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
    }

    
}
