package com.hendisantika.controller;

import com.hendisantika.entity.Student;
import com.hendisantika.service.StudentService;
import net.bytebuddy.TypeCache;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@SpringBootApplication
public class StudentWebController {
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/tampil")
    public String index2(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "2";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("student", new Student());
        return "formStudent";
    }

    @PostMapping(value = "/create")
    public String tambahStudent(Model model, Student student) {
        model.addAttribute("student", studentService.save(student));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "formStudent";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }
}
