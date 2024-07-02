package com.student.service.repositories;

import com.student.service.entities.StudentContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentContactRepo extends JpaRepository<StudentContact, Long> {
}
