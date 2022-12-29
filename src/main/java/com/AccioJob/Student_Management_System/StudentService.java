package com.AccioJob.Student_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //This is a way of telling JAVA --> this is the service layer
public class StudentService {
    //Option 1 is to create an object myself
    //Don't need to do it because of AutoWire
    //StudentRepository obj = new StudentRepository();

    @Autowired //It is used to connect the different classes via object
    StudentRepository studentRepository; //Assume object is already created

    String addStudent(Student student){
        String result = studentRepository.addStudentToDB(student);
        return result;
    }

    Student getStudentByID(Integer id){
        Student student = studentRepository.getStudentByIDFromDB(id);
        return student;
    }

    Student getStudentByName(String name){
        Student student = studentRepository.getStudentByNameFromDB(name);
        return student;
    }

    Student updateStudent(Student student){
        return studentRepository.updateStudentInDB(student);
    }
}
