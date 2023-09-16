package edu.miu.cs.cs425.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query(value = "select s from Student s where s.firstName like %:searchParam% or " +
            "s.lastName like %:searchParam% or " + "s.middleName like %:searchParam% or " +
            "s.studentNo like %:searchParam% or " + "s.isInternationalStudent like %:searchParam% ")
    Optional<List<Student>> findBySearchParam(String searchParam);
}
