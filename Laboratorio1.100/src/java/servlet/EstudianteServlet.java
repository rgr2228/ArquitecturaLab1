/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import LaborModel.Estudiante;
import LaborModel.Materia;
import LaborModel.Matricula;
import daoLabora.EstudianteFacade;
import daoLabora.EstudianteFacadeLocal;
import daoLabora.MateriaFacade;
import daoLabora.MateriaFacadeLocal;
import daoLabora.MatriculaFacade;
import daoLabora.MatriculaFacadeLocal;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static org.jboss.weld.servlet.SessionHolder.getSession;

/**
 *
 * @author Santiago
 */
public class EstudianteServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    @EJB
    private MateriaFacadeLocal materiaFacade;
    @EJB
    private MatriculaFacadeLocal matriculaFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if ("list".equals(action)) {
                //findAll para buscar en materias
                 String idE = (String) request.getSession().getAttribute("login");
                 List<Materia> findAll = materiaFacade.findAll();
                 request.getSession().setAttribute("materias", findAll);
                url = "listMateria.jsp";
            } else if ("login".equals(action)) {
                String i = request.getParameter("idE");
                String p = request.getParameter("password");

                boolean checkLogin = estudianteFacade.checkLogin(Integer.valueOf(i), p);
                if (checkLogin) {
                    request.getSession().setAttribute("login", i);
                    url = "manager.jsp";
                } else {
                    url = "login.jsp?error=1";
                }
            } else if ("listMatricula".equals(action)) {

                String idE = (String) request.getSession().getAttribute("login");
                List<Matricula> listMate = matriculaFacade.listEnrollment(Integer.valueOf(idE));
                List<List> materiaMatri = new ArrayList<>();

                int[] codigos = new int[listMate.size()];

                for (int i = 0; i < listMate.size(); i++) {
                    codigos[i] = listMate.get(i).getCodeSubject();
                    materiaMatri.add(materiaFacade.listMaterias(codigos[i]));
                }

                request.getSession().setAttribute("matriculadas", materiaMatri);
                url = "listMatricula.jsp";

            }  else if ("profile".equals(action)) {
                String idE = (String) request.getSession().getAttribute("login");
                Estudiante e = estudianteFacade.find(Integer.valueOf(idE));
                request.getSession().setAttribute("estudiante", e);                
                url = "profile.jsp";
                
            } else if ("upload".equals(action)) {
                String idE = (String)request.getSession().getAttribute("login");
                Estudiante e = estudianteFacade.find(Integer.valueOf(idE));
                System.out.println("Voy acá men");
                Part part = request.getPart("file");
                System.out.println("Se tuesta en el if");
                if (part != null && part.getSize() != 0) {
                    System.out.println("Entré en el if");
                    InputStream is = part.getInputStream();
                    byte[] buffer = new byte[is.available()];
                    is.read(buffer);
                    is.close();
                    e.setPhoto(buffer);
                } else {
                    System.out.println("Entré en el else");
                    e.setPhoto(null);
                }
                estudianteFacade.edit(e);
                request.getSession().setAttribute("estudiante", e);
                url = "profile.jsp";
            }
          else if ("enrollment".equals(action)) {
              
                   //Caputuramos id de la materia
                String idM = request.getParameter("id");
                //Pedimos a la sesión que nos retorne el id del usuario
                String idE = (String) request.getSession().getAttribute("login");
                
                System.out.println(idE);
                System.out.println(idM);               
                
               matriculaFacade.matricula(Integer.valueOf(idM), Integer.valueOf(idE));
                url = "EstudianteServlet?action=list";
              
            } else if ("logout".equals(action)) {
                request.getSession().removeAttribute("login");
                request.getSession().removeAttribute("imagen");
                url = "login.jsp";
            }
            response.sendRedirect(url);
        } finally {
            out.close();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
