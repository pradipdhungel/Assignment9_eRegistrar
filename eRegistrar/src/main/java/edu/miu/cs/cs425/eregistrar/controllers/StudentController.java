package edu.miu.cs.cs425.eregistrar.controllers;

import edu.miu.cs.cs425.eregistrar.entity.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.swing.text.html.parser.Entity;

@Controller
@RequestMapping(value = "/eregistrar/students/")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping(value = "/about")
    public String displayAboutPage(){
        return "/public/about";
    }

    @GetMapping(value = "/list")
    public ModelAndView listOfStudents(){
        var students=studentService.getAllStudents();
        var searchParam="";
        System.out.println("Students are:"+students);
        var modelAndView= new ModelAndView();
        modelAndView.addObject("searchParam",searchParam);
        modelAndView.setViewName("secured/Students/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String displayedNewPublisherForm(Model entity){
        var newStudent= new Student();
        entity.addAttribute("student", newStudent);
      return "secured/students/new";
    }

    @PostMapping(value = {"/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/students/new";
        }
        return "redirect:/eregistrar/students/list";
    }
    @GetMapping(value = "/edit/{studentId}")
    public String displayEditStudentForm(Model model, @PathVariable Long studentId)throws IllegalArgumentException {
        var student=studentService.getStudentById(studentId);
        if (student!=null) {
            model.addAttribute("student", student);
            return "secured/students/edit";
        }
        return "redirect:/eregistrar/students/list";
    }
    @PostMapping(value = {"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/students/new";
        }
        return "redirect:/eregistrar/students/list";
    }
    @GetMapping(value = "/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/students/list";
    }
    @GetMapping(value = "/search")
    public String searchStudent(Model model, @RequestParam("search") String search){
        var students=studentService.searchStudent(search);
        model.addAttribute("students",students);
        return "secured/students/new";
    }
}
