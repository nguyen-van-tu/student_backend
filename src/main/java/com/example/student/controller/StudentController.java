package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.IStudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> products = studentService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getProductById(@PathVariable("id") ObjectId id) {
        Student product = studentService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable ObjectId id) {
        studentService.remove(id);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateProduct(@PathVariable ObjectId id, @RequestBody Student student) {
        student.set_id(id);
        studentService.save(student);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }
}