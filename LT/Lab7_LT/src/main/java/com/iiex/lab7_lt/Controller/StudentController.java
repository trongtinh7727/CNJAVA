package com.iiex.lab7_lt.Controller;

import com.iiex.lab7_lt.Model.Student;
import com.iiex.lab7_lt.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/students")
    public String showStudents(Model model){
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studentList",studentList);
        model.addAttribute("student",new Student());
        return "students";
    }
    @PostMapping ("/students/save")
    public String saveStudent(Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id")Integer id, RedirectAttributes ra){
        try {
            studentRepository.deleteById(id);
            ra.addFlashAttribute("message", "Xóa thành công");
            return "redirect:/students";
        }
        catch (Exception e){
            ra.addFlashAttribute("error", "Có lỗi xảy ra! Xóa thất bại.");
            e.printStackTrace();
            return "redirect:/students";
        }
    }
}
