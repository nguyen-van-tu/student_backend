package com.example.student.repository;

import com.example.student.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, ObjectId> {
    Student findBy_id(ObjectId _id);
}
