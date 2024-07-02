package com.student.service.service;

import com.student.service.entities.Student;
import com.student.service.model.StudentDTO;
import com.student.service.model.StudentDetailsDTO;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    void addNewStudent(StudentDetailsDTO studentDetailsDTO);

    StudentDetailsDTO updateStudent(StudentDetailsDTO studentDetailsDTO);

    void removeStudentData(Long id);

    Student updateOnlyStudentData(Long id,StudentDTO studentDTO);
}
