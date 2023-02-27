import DAO.StudentDAO;
import Pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {""})
public class HomeServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Student> students = studentDAO.sellectAll();
            req.setAttribute("students",students);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("student_name");
        String course = req.getParameter("student_course");
        String fee = req.getParameter("student_fee");
        int check = -1;
        try {
            if (fee != null && name != null && course != null) {
                check =studentDAO.insert(new Student(name,course, Integer.parseInt(fee)));
            }
            if (check == 1) {
                req.setAttribute("successMessage","Thêm thành công!");
            }else{
                req.setAttribute("errorMessage", "Không thể thêm sinh viên. Vui lòng thử lại sau.");
            }
        }catch (Exception e){
            req.setAttribute("errorMessage", "Không thể thêm sinh viên. Vui lòng thử lại sau.");
        }

        List<Student> students = studentDAO.sellectAll();
        req.setAttribute("students",students);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
