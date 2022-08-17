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

    @Transactional
    public List<DepartmentDTO> getAllDepartments() {
        return StreamSupport
                .stream(departmentRepository.findAll().spliterator(), false)
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public DepartmentDTO findById (String id) {
        Department department =  departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department does not exist"));
        return departmentMapper.toDto(department);
    }

    @Transactional
    public List<DoctorDTO> getDepartmentDoctors(String department) {
        Department department1 = departmentRepository.findById(department)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department does not exist"));

        return StreamSupport
                .stream(department1.getDoctors().spliterator(), false)
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());

    }

    @Transactional
    public void deleteById(String id) throws Exception {
        if(departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new Exception("id not found");
        }
    }

    @Transactional
    public Department addDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        return departmentRepository.save(department);
    }
}
