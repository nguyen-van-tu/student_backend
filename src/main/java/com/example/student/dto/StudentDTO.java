package com.example.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private String _id;
    private String studentCode;
    private String name;
    private String gender;
    private String address;

    public StudentDTO(String _id, String studentCode, String name, String gender, String address) {
        this._id = _id;
        this.studentCode = studentCode;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public StudentDTO() {

    }
}
