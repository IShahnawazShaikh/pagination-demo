package com.example.pagination.service;

import com.example.pagination.dto.PageRequestStudentDto;
import com.example.pagination.entity.StudentEntity;
import com.example.pagination.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Page<StudentEntity> getAllStudent(PageRequestStudentDto dto) {
        Integer pageNo = Objects.nonNull(dto.getPageNo()) ? dto.getPageNo() : 0;
        Integer pageSize = Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : 10;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<StudentEntity> studentEntityPage = studentRepository.findAll(pageable);
        return studentEntityPage;
    }
}
