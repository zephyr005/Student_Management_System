package com.AccioJob.Student_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Telling the java application --> this class contain API endpoints
public class StudentController {
    @Autowired //Automatically takes care of the StudentService object creation
    StudentService studentService; //Object has been created --> so that it can call the functions

    //Add a Student
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody() Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Get a Student by id
    @GetMapping("/get_student_by_id")
    public ResponseEntity<Student> getStudentByID(@RequestParam("id") Integer id){
        Student resultStudent = studentService.getStudentByID(id);
        if(resultStudent == null){
            return new ResponseEntity<>(resultStudent,HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(resultStudent,HttpStatus.OK);
        }

    }

    //Get a student by path
    @GetMapping("/get_student_by_path/{id}")
    public ResponseEntity<Student> getStudentByPath(@PathVariable("id") Integer id){
        Student resultantStudent = studentService.getStudentByID(id);
        if(resultantStudent == null){
            return new ResponseEntity<>(resultantStudent,HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(resultantStudent,HttpStatus.OK);
        }
    }

    //Get a student by name
    @GetMapping("/get_student_by_name")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name") String searchName){
        Student resultantStudent = studentService.getStudentByName(searchName);
        return new ResponseEntity<>(resultantStudent,HttpStatus.OK);
    }

    //Update a Student
    @PutMapping("/update_student")
    public ResponseEntity<Student> updateStudent(@RequestBody() Student student){
        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.ACCEPTED);
    }

    //Delete a Student
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") Integer id){
        studentService.studentRepository.studentDB.remove(id);
        return new ResponseEntity<>("The student has been deleted",HttpStatus.OK);
    }
}
