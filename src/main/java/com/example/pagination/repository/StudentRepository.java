package com.example.pagination.repository;

import com.example.pagination.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Page<StudentEntity> findAllByCity(String city, Pageable pageable);
}
