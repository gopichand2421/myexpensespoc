package com.student.service.test.controller;


import com.student.service.controller.StudentController;
import com.student.service.entities.Student;
import com.student.service.exceptionhandlers.NoRecordsFoundException;
import com.student.service.service.StudentServiceImpl;
import com.student.service.test.util.TestDataCreator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceImpl studentService;

    @Test
    void getResponsefromApi() throws Exception {
        TestDataCreator testDataCreator = new TestDataCreator();
        Student studentData = testDataCreator.intializeStudentData();
        when(studentService.getStudents()).thenReturn(List.of(studentData));
        this.mockMvc.perform(get("/api/student/getstudents")).andDo(print()).andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Disabled
    void handleNoStudentRecordsFoundTest(){
        Exception exception = assertThrows(NoRecordsFoundException.class,() ->{
            List<Student> studentList = new ArrayList<>();
            when(studentService.getStudents()).thenReturn(studentList);
            this.mockMvc.perform(get("/api/student/getstudents")).andDo(print()).andExpect(status().is(200))
                    .andExpect(content().string(containsString("no records are found")));
        });
    }
}
