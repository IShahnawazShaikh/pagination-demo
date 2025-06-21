package com.example.pagination.controller;

import com.example.pagination.dto.PageRequestStudentDto;
import com.example.pagination.entity.StudentEntity;
import com.example.pagination.repository.StudentRepository;
import com.example.pagination.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/fetch-details-sort")

    public ResponseEntity<Page<StudentEntity>> getAllStudentByOrder(@RequestBody PageRequestStudentDto pageRequestStudentDto) {
        Page<StudentEntity> response = studentService.getAllStudentByOrder(pageRequestStudentDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/fetch-details-sort-pageholder")
    public ResponseEntity<Page<StudentEntity>> getAllStudentByOrderPageHolder(@RequestBody PageRequestStudentDto pageRequestStudentDto) {
        Page<StudentEntity> response = studentService.getAllStudentUsingPagedListHolder(pageRequestStudentDto);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/fetch-detail-city/{city}")
    public ResponseEntity<Page<StudentEntity>> getAllStudentByCity(@RequestBody PageRequestStudentDto pageRequestStudentDto,
                                                                   @PathVariable(name = "city") String city) {
        Page<StudentEntity> response = studentService.findStudentByCity(pageRequestStudentDto, city);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/fetch-detail-city/native/{city}")
    public ResponseEntity<Page<StudentEntity>> getAllStudentByCityNative(@RequestBody PageRequestStudentDto pageRequestStudentDto,
                                                                         @PathVariable(name = "city") String city) {
        Page<StudentEntity> response = studentService.findAllStudentByCityNative(pageRequestStudentDto, city);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/fetch-detail-city/nativeSort/{city}")
    public ResponseEntity<Page<StudentEntity>> getAllStudentByCityNativeSort(@RequestBody PageRequestStudentDto pageRequestStudentDto,
                                                                         @PathVariable(name = "city") String city) {
        Page<StudentEntity> response = studentService.findAllStudentByCityNativeSort(pageRequestStudentDto, city);
        return ResponseEntity.ok(response);
    }
}

