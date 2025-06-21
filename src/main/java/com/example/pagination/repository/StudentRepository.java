package com.example.pagination.repository;

import com.example.pagination.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Page<StudentEntity> findAllByCity(String city, Pageable pageable);

    /**
     *
     * value: the main SQL query
     *
     * countQuery: used to calculate totalElements for Page<> metadata
     *
     * nativeQuery = true: tells Spring this is raw SQL, not JPQL
     *
     * @param city
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * from student WHERE city = :city",
            countQuery = "SELECT count(*) from student WHERE city = :city", nativeQuery = true)
    Page<StudentEntity> findAllStudentByCityNative(@Param(value = "city") String city, Pageable pageable);


    @Query(value = "SELECT * FROM student where city = :city",
            countQuery = "SELECT COUNT(*) FROM student WHERE city = :city", nativeQuery = true)
    Page<StudentEntity> findAllStudentByCityNativeSort(@Param(value = "city") String city, Pageable pageable);
}
