package com.clinic.app.service;

import com.clinic.app.entity.Department;
import com.clinic.app.repository.DepartmentRepository;
import com.clinic.app.service.dto.DepartmentDTO;
import com.clinic.app.service.dto.DoctorDTO;
import com.clinic.app.service.mapper.DepartmentMapper;
import com.clinic.app.service.mapper.DoctorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final DoctorMapper doctorMapper;


    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper, DoctorMapper doctorMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.doctorMapper = doctorMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return StreamSupport
                .stream(departmentRepository.findAll().spliterator(), false)
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }


    public DepartmentDTO findById (String id) {
        Department department =  departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department does not exist"));
        return departmentMapper.toDto(department);
    }

    public List<DoctorDTO> getDepartmentDoctors(String department_name) {
        Department department = departmentRepository.findById(department_name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department does not exist"));

        return department.getDoctors().stream()
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());

    }

    public void deleteById(String id) throws Exception {
        if(departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new Exception("Department not found");
        }
    }

    public void addDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        departmentRepository.save(department);
    }
}
