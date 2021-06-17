package com.example.student.service;

import com.example.student.model.Student;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IStudentService {
    List<Student> findAll();

    Student findById(ObjectId id);

    Student save(Student student);

    void remove(ObjectId id);
}
