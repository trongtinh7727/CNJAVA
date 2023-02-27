import DAO.StudentDAO;
import Pojo.Student;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/student"})
public class UpdateServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        int check =-1;
        if (action.equals("edit")) {
            Student student = studentDAO.selectById(id);
            req.setAttribute("student", student);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        }
        else if (action.equals("delete")){
           check =  studentDAO.delete(Integer.parseInt(id));
            if (check == 1) {
                req.setAttribute("successMessage","Xóa thành công!");
            }else{
                req.setAttribute("errorMessage", "Không thể Xóa sinh viên. Vui lòng thử lại sau.");
            }
            List<Student> students = studentDAO.sellectAll();
            req.setAttribute("students",students);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("student_name");
        String course = req.getParameter("student_course");
        String fee = req.getParameter("student_fee");
        System.out.println(id);
        System.out.println(name);
        System.out.println(course);
        System.out.println(fee);
        int check = -1;
        try {
            if (fee != null && name != null && course != null) {
                check =studentDAO.upate(new Student(Integer.parseInt(id),name,course, Integer.parseInt(fee)));
            }
            if (check == 1) {
                req.setAttribute("successMessage","Cập nhật thành công!");
            }else{
                req.setAttribute("errorMessage", "Không thể Cập nhật sinh viên. Vui lòng thử lại sau.");
            }
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("errorMessage", "Có lỗi xảy ra. Vui lòng thử lại sau.");
        }

        List<Student> students = studentDAO.sellectAll();
        req.setAttribute("students",students);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
