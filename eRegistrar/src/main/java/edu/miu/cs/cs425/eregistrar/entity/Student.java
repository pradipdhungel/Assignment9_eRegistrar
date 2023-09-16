package edu.miu.cs.cs425.eregistrar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue
    Long StudentId;

    @NotEmpty(message = "Student number must be fill")
    @NotBlank(message = "Student number cannot be null or blank")
    @NotNull
    @Column(nullable = false)
    private String studentNo;

    @NotEmpty(message = "Student firstName must be fill")
    @NotBlank(message = "Student firstName cannot be null or blank")
    @NotNull
    @Column(nullable = false)
    private String firstName;


    @Column(nullable = false)
    private String middleName;

    @NotEmpty(message = "Student lastName must be fill")
    @NotBlank(message = "Student lastName cannot be null or blank")
    @NotNull
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private double cgpa;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    private String isInternationalStudent;

    @NotEmpty(message = "Student gender must be fill")
    @NotBlank(message = "Student gender cannot be null or blank")
    @NotNull
    @Column(nullable = false)
    private String gender;

    @Column(columnDefinition = "boolean default false")
    private Boolean fpp;

    public Student(String studentNo, String firstName, String middleName, String lastName, double cgpa, LocalDate enrollmentDate, String isInternationalStudent, String gender, Boolean fpp) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternationalStudent = isInternationalStudent;
        this.gender = gender;
        this.fpp = fpp;
    }
}
