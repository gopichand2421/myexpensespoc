package com.student.service.service;

import com.student.service.entities.Student;
import com.student.service.exceptionhandlers.NoRecordsFoundException;
import com.student.service.model.StudentDTO;
import com.student.service.model.StudentDetailsDTO;
import com.student.service.repositories.StudentContactRepo;
import com.student.service.repositories.StudentRepo;
import com.student.service.util.Patcher;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService{

    private StudentRepo studentRepo;

    private ModelMapper modelMapper;

    private StudentContactRepo studentContactRepo;

    private Patcher patcher;

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setStudentContactRepo(StudentContactRepo studentContactRepo){
        this.studentContactRepo = studentContactRepo;
    }

    @Autowired
    public void setPatcher(Patcher patcher){
        this.patcher = patcher;
    }


    @Override
    public List<Student> getStudents() {
         return studentRepo.findAll();
    }

    @Override
    public void addNewStudent(StudentDetailsDTO studentDetailsDTO) {
        try{
            Student studentData = this.modelMapper.map(studentDetailsDTO, Student.class);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(studentDetailsDTO.getDateOfbirth());
            studentData.setDateOfbirth(date);
            studentRepo.save(studentData);
            log.info(studentData.getEmail());
        }catch (Exception ex){
            log.error("failed to create student", ex);
        }
    }

    @Override
    public StudentDetailsDTO updateStudent(StudentDetailsDTO studentDetailsDTO) {
        Student previousStudentData = this.studentRepo.findById(studentDetailsDTO.getId())
                .orElseThrow(() -> new NoRecordsFoundException("no records found with id: "+studentDetailsDTO.getId().toString()));
        StudentDetailsDTO updatedStudentDetailsDTO = null;
        Student currentData = this.modelMapper.map(studentDetailsDTO, Student.class);
        currentData.setId(previousStudentData.getId());
        Student student = this.studentRepo.save(currentData);
        updatedStudentDetailsDTO = this.modelMapper.map(student, StudentDetailsDTO.class);
        return updatedStudentDetailsDTO;
    }

    @Override
    public void removeStudentData(Long id) {
        Optional<Student> student = this.studentRepo.findById(id);
        try{
            student.ifPresentOrElse((obj) ->{
                this.studentRepo.delete(obj);
            }, ()->{
                log.error("No records are found with this Id {}",id);
            });
        }catch (Exception ex){
            log.error("error occured while deleting the record", ex);
        }
    }

    @Override
    public Student updateOnlyStudentData(Long id,StudentDTO studentDTO) {

        Optional<Student> student = this.studentRepo.findById(id);
        StudentDetailsDTO extistingStudentDetails = this.modelMapper.map(student,StudentDetailsDTO.class);
        try{
            this.patcher.patch(studentDTO, extistingStudentDetails);
            Student updatedStudentDetails = this.modelMapper.map(extistingStudentDetails,Student.class);
            this.studentRepo.save(updatedStudentDetails);
        }catch(Exception ex){
            log.error("Error while updating student detials", ex);
        }

        return null;
    }
}
