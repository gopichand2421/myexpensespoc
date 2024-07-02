package com.student.service.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="email")
    private String email;

    @Column(name = "dateofbirth")
    private Date dateOfbirth;

    @OneToMany(cascade = CascadeType.ALL,
            targetEntity = StudentContact.class)
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private List<StudentContact> studentContactDetails;
}
