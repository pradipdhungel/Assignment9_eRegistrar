package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.entity.Student;

import java.util.List;

public interface StudentService {
    Student addNewStudent(Student student);
    List<Student> addNewStudents(List<Student> students);
    List<Student> getAllStudents();
    Student getStudentById(Long studentId) throws IllegalArgumentException;
    List<Student> searchStudent(String firstName) throws IllegalArgumentException;
    Student updateStudent(Student updatedStudent);
    void deleteStudentById(Long studentId);
}
