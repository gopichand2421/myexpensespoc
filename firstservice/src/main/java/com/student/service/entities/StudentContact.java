package com.student.service.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "studentcontact")
@Data
public class StudentContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "addressline1")
    private String addressLine1;

    @Column(name="addressline2")
    private String addressLine2;

    @Column(name="landmark")
    private String landMark;

    @Column(name="mobile")
    private String mobile;

    @Column(name="homephone")
    private String homePhone;

    @Column(name="district")
    private String district;

    @Column(name="state")
    private String state;

    @Column(name="pincode")
    private String pincode;

    @Column(name="isprimary")
    private Boolean isprimary;

    @Column(name = "ispermanent")
    private Boolean ispermanent;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="student_id")
//    private Student student;

}
