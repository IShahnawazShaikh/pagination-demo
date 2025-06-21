package com.example.pagination.service;

import com.example.pagination.dto.PageRequestStudentDto;
import com.example.pagination.entity.StudentEntity;
import com.example.pagination.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Page<StudentEntity> getAllStudent(PageRequestStudentDto dto) {
        Integer pageNo = Objects.nonNull(dto.getPageNo()) ? dto.getPageNo() : 0;
        Integer pageSize = Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : 10;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<StudentEntity> studentEntityPage = studentRepository.findAll(pageable);
        return studentEntityPage;
    }

    public Page<StudentEntity> getAllStudentByOrder(PageRequestStudentDto dto) {
        Integer pageNo = Objects.nonNull(dto.getPageNo()) ? dto.getPageNo() : 0;
        Integer pageSize = Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : 10;
        Sort.Direction sortDirection = Objects.nonNull(dto.getSorDirection()) ? dto.getSorDirection() : Sort.Direction.ASC;
        String sortByColumn = Objects.nonNull(dto.getSortByColumn()) ? dto.getSortByColumn() : "id";

        Pageable pageable = PageRequest.of(pageNo, pageSize, sortDirection, sortByColumn);

        Page<StudentEntity> studentEntityPage = studentRepository.findAll(pageable);
        return studentEntityPage;

    }

    public Page<StudentEntity> getAllStudentUsingPagedListHolder(PageRequestStudentDto dto) {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        // 1. PageList Holder
        PagedListHolder<StudentEntity> pagedListHolder = new PagedListHolder<>(studentEntityList);
        pagedListHolder.setPage(dto.getPageNo());
        pagedListHolder.setPageSize(dto.getPageSize());

        logger.info("pagelist Holder {} ", pagedListHolder);

        //2. Property Comparator
        boolean ascending = dto.getSorDirection().isAscending();

        // Performs in-memory sorting on the current paginated sublist.
        PropertyComparator.sort(pagedListHolder.getPageList(), new MutableSortDefinition(dto.getSortByColumn(),true, ascending));

        return new PageImpl<StudentEntity>(pagedListHolder.getPageList(), PageRequest.of(dto.getPageNo(), dto.getPageSize()), studentEntityList.size());

    }
}
