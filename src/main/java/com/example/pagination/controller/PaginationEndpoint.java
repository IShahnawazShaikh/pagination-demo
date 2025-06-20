package com.example.pagination.controller;

import com.example.pagination.dto.PageRequestStudentDto;
import com.example.pagination.entity.StudentEntity;
import com.example.pagination.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class PaginationEndpoint {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/fetch-details")
    public Page<StudentEntity> getAllStudentUsingPagination(@RequestBody PageRequestStudentDto pageRequestStudentDto) {
        Pageable pageable = new PageRequestStudentDto().getPageable(pageRequestStudentDto);
         Page<StudentEntity> studentEntityPage = studentRepository.findAll(pageable);
         return studentEntityPage;

    }
}
