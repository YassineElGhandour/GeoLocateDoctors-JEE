package com.projetjees3.servlets;


import com.projetjees3.beans.BeanException;
import com.projetjees3.beans.UserInsert;
import com.projetjees3.dao.ChercheurDaoImpl;
import com.projetjees3.dao.DaoException;
import com.projetjees3.dao.DaoFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetjees3.dao.ChercheurDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet 
{

    private static final long serialVersionUID = 1L;
    private ChercheurDaoImpl chercheurDao;
    
    public void init() throws ServletException
    {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.chercheurDao = daoFactory.getChercheurDao();
    }
        
    public InscriptionServlet()
     {
         super();
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {     
       //this.getServletContext().getRequestDispatcher("/WEB-INF/AddMarkUser.jsp").forward(request, response);  

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {        
        try 
        {
            UserInsert chercheur = new UserInsert();
            chercheur.setNomCherch(request.getParameter("nom"));
            chercheur.setPrenomCherch(request.getParameter("prenom"));
            String email = request.getParameter("email");
            chercheur.setEmailCherch(email);
            chercheur.setNumTelCherch(request.getParameter("num"));
            chercheur.setDescCherch(request.getParameter("descprofile"));
            chercheur.setDateNaissCherch(request.getParameter("datenaissance"));
            chercheur.setNivCherch(request.getParameter("nivetudes"));
            chercheur.setPaysOrgCherch(request.getParameter("paysorg"));
            chercheur.setPostActCherch(request.getParameter("posact"));
            chercheur.setPswCherch(request.getParameter("password"));
            String res = request.getParameter("typecherch");

            request.setAttribute("emails", chercheurDao.lister9(email));
            int vv= chercheurDao.lister9(email);
            
            if(res.equals("0"))
            {
                chercheur.setType_cherch("0");
                System.out.println("Test1"+res);
            }
            else
            {
                chercheur.setType_cherch("1");
            System.out.println("Test2"+res);}
            
            System.out.println(res);
            String verify= request.getParameter("code");
            System.out.println("Verify : " +verify);
            if(verify.equals("XXX") && vv==1)
            {
                chercheurDao.ajouter(chercheur);
                response.sendRedirect("/ProjetJEES3/home#login"); 
            }
            else
            {   
                response.sendRedirect("/ProjetJEES3/home?Error=NotFound#sinscrire"); 
          
            }
            
            
            request.setAttribute("users", chercheurDao.lister());
        } 
        catch (BeanException | DaoException | SQLException e) 
        {
            //e.printStackTrace();
        }
        
    }
    
}

