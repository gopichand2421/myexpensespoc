package com.student.service.controller;


import com.student.service.entities.Student;
import com.student.service.exceptionhandlers.InvalidRequestException;
import com.student.service.exceptionhandlers.NoRecordsFoundException;
import com.student.service.model.StudentDTO;
import com.student.service.model.StudentDetailsDTO;
import com.student.service.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentServiceImpl studentService;

    @Autowired
    public void setStudentService(StudentServiceImpl studentService){
        this.studentService = studentService;
    }

    @GetMapping(path = "/getstudents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> studentList = studentService.getStudents();
        if(studentList.isEmpty()){
            throw new NoRecordsFoundException("no records are found");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentList);
    }


    @PostMapping(path = "/addstudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDetailsDTO studentDetailsDTO){
        if(studentDetailsDTO == null){
            throw  new InvalidRequestException("Invalid Student request");
        }
        studentService.addNewStudent(studentDetailsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student data is created sucessfully");
    }

    @PutMapping(path = "/updatestudentdetails")
    public ResponseEntity<StudentDetailsDTO> updateStudentDetails(@RequestBody StudentDetailsDTO studentDetailsDTO){
        StudentDetailsDTO updatedData = this.studentService.updateStudent(studentDetailsDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedData);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable(name = "id") Long id){
        this.studentService.removeStudentData(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("REMOVED");
    }

    @PatchMapping(path = "/{id}/updatestudent")
    public ResponseEntity<String> updateOnlyStudent(@PathVariable(name = "id") Long id,@RequestBody StudentDTO studentDTO){
        this.studentService.updateOnlyStudentData(id,studentDTO);
        return null;
    }
}
