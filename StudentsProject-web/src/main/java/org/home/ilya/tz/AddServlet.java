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
import org.home.ilya.tz.entity.StudentGroup;

@WebServlet(name = "AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {

    @EJB
    StudentFacade studentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student student = new Student();

        student.setStudentFio(request.getParameter("student_fio"));
//        student.setGroupId(new StudentGroup(Integer.getInteger(request.getParameter("group_id"))));
        student.setScholarship(Integer.parseInt(request.getParameter("scholarship")));
        
        try {
            student.setEnrollmentDate(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("enrollment_date")));
        } catch (ParseException ex) {
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        studentFacade.create(student);

        response.sendRedirect("/StudentsProject-web/main");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
