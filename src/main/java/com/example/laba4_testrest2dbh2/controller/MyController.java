package com.example.laba4_testrest2dbh2.controller;

import com.example.laba4_testrest2dbh2.entity.Student;
import com.example.laba4_testrest2dbh2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students") // Получение всех студентов
    public List<Student> showAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/students/{id}") // Получение одного студента
    public Student getStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }

    @PostMapping("/students") //Добавление студента
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PutMapping("/students") // Изменение студен
    public Student updateStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }
    @DeleteMapping("/students/{id}") // Удаление одного студента
    public void updateStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }


}