package com.example.student.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "student")
public class Student {
    @Id
    private ObjectId _id;
    private String studentCode;
    private String name;
    private String gender;
    private String address;

}
