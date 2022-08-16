package com.clinic.app.service;

import com.clinic.app.entity.Department;
import com.clinic.app.entity.Doctor;
import com.clinic.app.repository.DoctorRepository;
import com.clinic.app.service.dto.DepartmentDTO;
import com.clinic.app.service.dto.DoctorDTO;
import com.clinic.app.service.mapper.DepartmentMapper;
import com.clinic.app.service.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    private final DepartmentMapper departmentMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper, DepartmentMapper departmentMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.departmentMapper = departmentMapper;
    }

    public void addDoctor (DepartmentDTO departmentDTO, DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Department department = departmentMapper.toEntity(departmentDTO);
        doctor.setDepartment(department);

        doctorRepository.save(doctor);
    }
}
