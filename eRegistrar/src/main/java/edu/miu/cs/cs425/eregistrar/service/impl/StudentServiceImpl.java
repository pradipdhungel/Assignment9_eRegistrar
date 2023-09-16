package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.entity.Student;
import edu.miu.cs.cs425.eregistrar.repository.StudentRepo;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private  final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }


    @Override
    public Student addNewStudent(Student student) {
        var newStudent=studentRepo.save(student);
        return newStudent;
    }

    @Override
    public List<Student> addNewStudents(List<Student> students) {
        var newStudents=studentRepo.saveAll(students);
        return newStudents;
    }

    @Override
    public List<Student> getAllStudents() {
        var students=studentRepo.findAll(Sort.by("firstName"));
        return students;

    }

    @Override
    public Student getStudentById(Long studentId)  {
        return studentRepo.findById(studentId)
                .orElseThrow(()->new IllegalArgumentException("Student with ID"+"Not Found"));
    }

    @Override
    public List<Student> searchStudent(String firstName)  {
        return studentRepo.findBySearchParam(firstName)
                .orElseThrow(()-> new IllegalArgumentException("Student with Firstname are "+firstName+"notFound"));
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepo.save(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
     studentRepo.deleteById(studentId);
    }
}
