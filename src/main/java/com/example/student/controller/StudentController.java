package com.example.student.controller;

import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import com.example.student.service.IStudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> getAllStudent() {
        List<Student> students = studentService.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s : students) {
            studentDTOS.add(new StudentDTO(s.get_id().toString(), s.getStudentCode(), s.getName(), s.getGender(),
                    s.getAddress()));
        }
        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getProductById(@PathVariable("id") ObjectId id) {
        Student product = studentService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getStudentCode(), studentDTO.getName(),
                studentDTO.getGender(), studentDTO.getAddress());
        studentService.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable ObjectId id) {
        studentService.remove(id);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateProduct(@PathVariable ObjectId id, @RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        student.set_id(id);
        Student student1 = new Student(studentDTO.getStudentCode(), studentDTO.getName(),
                studentDTO.getGender(), studentDTO.getAddress());
        studentService.save(student1);
        return new ResponseEntity<Student>(student1,HttpStatus.OK);
    }
}