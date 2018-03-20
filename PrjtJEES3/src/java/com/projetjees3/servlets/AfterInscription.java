
package com.projetjees3.servlets;

import com.projetjees3.beans.BeanException;
import com.projetjees3.beans.RechBean;
import com.projetjees3.beans.ThemeBean;
import com.projetjees3.beans.UserInsert;
import com.projetjees3.dao.ChercheurDaoImpMark;
import com.projetjees3.dao.ChercheurDaoImpl;
import com.projetjees3.dao.DaoException;
import com.projetjees3.dao.DaoFactory;
import com.projetjees3.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class AfterInscription extends HttpServlet {
   private ChercheurDaoImpMark chercheurDao;
   private ChercheurDaoImpMark rechercheDao2;
   private ChercheurDaoImpl chercheurDao3;
   public static String dU;
   public static String dR;

    private static final long serialVersionUID = 1L;
    static int nb;
    public static String msg4;
    public static String msg5;
    public void init() throws ServletException
    {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.chercheurDao = daoFactory.getChercheurDao1();
        this.rechercheDao2 = daoFactory.getChercheurDao1();

    }
        public AfterInscription()
     {
         super();
     }
     public static int rech ;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //processRequest(request, response);
        msg4 = request.getParameter("h");
        msg5 = request.getParameter("m");
        int idRech = (int) Math.round(Math.random()*100000);
        RechBean recherche = new RechBean();
        ThemeBean theme = new ThemeBean();
        UserInsert chercheur2 = new UserInsert();
        recherche.setNomRech(request.getParameter("nomrech"));
        recherche.setDescRech(request.getParameter("descrech"));
        recherche.setUniRech(request.getParameter("unirech"));
        recherche.setTerrainRech(request.getParameter("terrainrech"));
        recherche.setLaboRech(request.getParameter("laborech"));
        recherche.setPaysRech(request.getParameter("paysrech"));
        recherche.setMotsCleRech(request.getParameter("motsclesrech"));
        theme.setNomTheme(request.getParameter("nomtheme"));
        try 
        {
           rechercheDao2.ajouterRech(recherche, theme, chercheur2,idRech, msg4);
        } 
        catch (DaoException | SQLException ex) 
        {
           Logger.getLogger(AfterInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("UserDAO.typeCherch via After Inscri"+UserDAO.typeCherchU);
        System.out.println("UserDAO.typeCherchU 99= "+msg4);
        System.out.println("UserDAO.typeCherchU 100= "+msg5);

        if("1".equals(msg4))
        {
        String msg = request.getParameter("urlPop");
        String msg2 = request.getParameter("urlPop2");
        

        System.out.println("msggggggg = "+msg);
        System.out.println("nombre = "+msg2);
        String[] msg3 = msg.split("#,");
        System.out.println(Arrays.toString(msg3));
        System.out.println(msg3[0]);
        UserInsert chercheur = new UserInsert();
        for(int i=0;i<msg3.length;i++)
        {
          if((msg3[i].length())<35)
          {
            chercheur.setMark(msg3[i]);
            try 
            {
                chercheurDao.ajouter(chercheur,ProfileDoc.idU,idRech, msg4);
            } 
            catch (DaoException | SQLException ex) 
            {
                Logger.getLogger(AfterInscription.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        }
       //response.sendRedirect("/WEB-INF/FormRecherche.jsp");
       idRech = (int) Math.round(Math.random()*10000);
       response.sendRedirect("/ProjetJEES3/profiledoc");
    }
    
    /*@Override
    public String getServletInfo() {
        return "Short description";
    }*/

}
