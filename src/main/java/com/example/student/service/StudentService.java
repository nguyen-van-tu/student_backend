package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    public StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(ObjectId id) {
        return repository.findBy_id(id);
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public void remove(ObjectId id) {
        repository.deleteById(id);
    }
}
