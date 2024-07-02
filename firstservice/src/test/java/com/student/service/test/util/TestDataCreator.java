package com.student.service.test.util;

import com.student.service.entities.Student;
import com.student.service.entities.StudentContact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDataCreator {

    public static Student intializeStudentData(){
        Student student = new Student();
        List<StudentContact> studentContactList = new ArrayList<>();
        StudentContact studentContact = new StudentContact();
        student.setId(1L);
        student.setDateOfbirth(new Date());
        student.setEmail("gopi@email.com");
        student.setFirstname("firstname");
        student.setLastname("lastname");
        student.setEmail("email");
        student.setUsername("username");
        studentContact.setId(1L);
        studentContact.setDistrict("district");
        studentContact.setIspermanent(true);
        studentContact.setIsprimary(false);
        studentContact.setMobile("123456789");
        studentContact.setPincode("12345678");
        studentContact.setAddressLine1("addressLine1");
        studentContact.setAddressLine2("addressLine2");
        studentContact.setHomePhone("12345679");
        studentContactList.add(studentContact);
        student.setStudentContactDetails(studentContactList);
        return student;
    }
}
