package com.clinic.app.service;

import com.clinic.app.repository.DepartmentRepository;
import com.clinic.app.service.dto.DepartmentDTO;
import com.clinic.app.service.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    private List<DepartmentDTO> getAllDepartments() {
        return StreamSupport
                .stream(departmentRepository.findAll().spliterator(), true)
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }
}
