package org.home.ilya.tz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.home.ilya.tz.entity.Student;


@WebServlet(name = "MainServlet", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {
    
    @EJB
    StudentFacade studentFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().setAttribute("student", studentFacade.findAll());
        request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String searchString = request.getParameter("student_text");
        
        List<Student> foundStudents = new ArrayList<Student>();
        List<Student> students = studentFacade.findAll();
        
        for(int i=0; i < students.size(); i++ ){
            if(students.get(i).getStudentFio().contains(searchString)){
                foundStudents.add(students.get(i));     
            }
        }
        
        getServletContext().setAttribute("student", foundStudents );
        
        request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
