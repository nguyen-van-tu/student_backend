package com.example.student.dto;


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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
