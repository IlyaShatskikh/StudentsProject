package org.home.ilya.tz;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.home.ilya.tz.entity.Student;

@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {
    
    @EJB
    StudentFacade studentFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("id") != null && request.getParameter("id") != ""){
            int id = Integer.valueOf(request.getParameter("id"));         
            getServletContext().setAttribute("student", studentFacade.find(id));;
        }
        
        request.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(request, response);
        
//        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.valueOf(request.getParameter("id"));
        
        Student student = studentFacade.find(id);

        student.setStudentFio(request.getParameter("student_fio"));
//        student.setGroupId(new StudentGroup(Integer.getInteger(request.getParameter("group_id"))));
        student.setScholarship(Integer.parseInt(request.getParameter("scholarship")));
        
        try {
            student.setEnrollmentDate(new SimpleDateFormat("dd.mm.yyyy").parse(request.getParameter("enrollment_date")));
        } catch (ParseException ex) {
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        studentFacade.edit(student);

        response.sendRedirect("/StudentsProject-web/main");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
