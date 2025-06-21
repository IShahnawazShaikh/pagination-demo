package com.example.pagination.controller;

import com.example.pagination.dto.PageRequestStudentDto;
import com.example.pagination.entity.StudentEntity;
import com.example.pagination.repository.StudentRepository;
import com.example.pagination.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class PaginationEndpoint {

    @Autowired
    private StudentService studentService;

    @PostMapping("/fetch-details")
    public ResponseEntity<Page<StudentEntity>> getAllStudentUsingPagination(@RequestBody PageRequestStudentDto pageRequestStudentDto) {
          Page<StudentEntity> listPage = studentService.getAllStudent(pageRequestStudentDto);
          return ResponseEntity.ok(listPage);
    }
}
