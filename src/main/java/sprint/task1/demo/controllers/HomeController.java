package sprint.task1.demo.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sprint.task1.demo.db.DBManager;
import sprint.task1.demo.db.Student;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Student> students = DBManager.getAllStudents();
        model.addAttribute("students",students);
        return "index";
    }

    @GetMapping(value = "/add_student")
    public String addStudentPage(){
        return "addStudentPage";
    }

    @PostMapping(value = "/add_student_info")
    public String addStudent(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "exam") int exam){
        Student student=new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);

        DBManager.addStudent(student);
        return "redirect:/";
    }
}
