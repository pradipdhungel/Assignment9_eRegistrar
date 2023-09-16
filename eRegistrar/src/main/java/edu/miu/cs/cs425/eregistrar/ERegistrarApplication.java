package edu.miu.cs.cs425.eregistrar;

import edu.miu.cs.cs425.eregistrar.entity.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ERegistrarApplication implements CommandLineRunner {
    private final StudentService studentService;

    public ERegistrarApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student rocky = new Student("622122", "Ram", "Thapa", "Magar", 3.9, LocalDate.of(2023, 1, 1), "Yes", "Male", true);
        Student student1 = new Student("622122", "John", "Michael", "Smith", 3.9, LocalDate.of(2023, 1, 1), "Yes", "Male", true);
        Student student2 = new Student("622123", "Emily", "Elizabeth", "Johnson", 3.7, LocalDate.of(2023, 1, 15), "No", "Female", false);
        Student student3 = new Student("622124", "William", "James", "Brown", 3.5, LocalDate.of(2023, 2, 1), "Yes", "Male", true);
        Student student4 = new Student("622125", "Olivia", "Grace", "Davis", 3.6, LocalDate.of(2023, 2, 15), "No", "Female", false);
        Student student5 = new Student("622126", "Michael", "David", "Miller", 3.8, LocalDate.of(2023, 3, 1), "Yes", "Male", true);
        Student student6 = new Student("622127", "Sophia", "Marie", "Wilson", 3.4, LocalDate.of(2023, 3, 15), "No", "Female", false);
        Student student7 = new Student("622128", "James", "Robert", "Anderson", 3.9, LocalDate.of(2023, 4, 1), "Yes", "Male", true);
        Student student8 = new Student("622129", "Emma", "Ava", "Clark", 3.6, LocalDate.of(2023, 4, 15), "No", "Female", false);
        Student student9 = new Student("622130", "Liam", "Matthew", "Walker", 3.7, LocalDate.of(2023, 5, 1), "Yes", "Male", true);
        Student student10 = new Student("622131", "Mia", "Olivia", "Hall", 3.5, LocalDate.of(2023, 5, 15), "No", "Female", false);
        Student student11 = new Student("622122", "Ram", "Thapa", "Magar", 3.9, LocalDate.of(2023, 1, 1), "Yes", "Male", true);
        Student student12 = new Student("622123", "Sita", "Gurung", "Shrestha", 3.7, LocalDate.of(2023, 1, 15), "No", "Female", false);
        Student student13 = new Student("622124", "Hari", "Koirala", "Dhakal", 3.5, LocalDate.of(2023, 2, 1), "Yes", "Male", true);
        Student student14 = new Student("622125", "Gita", "Rai", "Limbu", 3.6, LocalDate.of(2023, 2, 15), "No", "Female", false);
        Student student15 = new Student("622126", "Raj", "Sharma", "Pandit", 3.8, LocalDate.of(2023, 3, 1), "Yes", "Male", true);
        Student student16 = new Student("622127", "Asha", "Bhattarai", "Shahi", 3.4, LocalDate.of(2023, 3, 15), "No", "Female", false);
        Student student17 = new Student("622128", "Surya", "Acharya", "Shrestha", 3.9, LocalDate.of(2023, 4, 1), "Yes", "Male", true);
        Student student18 = new Student("622129", "Bina", "Magar", "Rai", 3.6, LocalDate.of(2023, 4, 15), "No", "Female", false);
        Student student19 = new Student("622130", "Krishna", "Poudel", "Bista", 3.7, LocalDate.of(2023, 5, 1), "Yes", "Male", true);
        Student student20 = new Student("622131", "Mina", "Ghimire", "Dahal", 3.5, LocalDate.of(2023, 5, 15), "No", "Female", false);
        List<Student> students = studentService.addNewStudents(List.of(student1, student2, student4, student5, student6, student7, student8, student9, student10, student11, student12, student13, student14, student15, student16, student17, student18, student19, student20));

    }
}
