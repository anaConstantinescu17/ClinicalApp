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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Transactional
    public void addDoctor (DepartmentDTO departmentDTO, DoctorDTO doctorDTO) throws Exception{

        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Department department = departmentMapper.toEntity(departmentDTO);
        doctor.setDepartment(department);

        if(doctorRepository.findByNameAndDepartment(doctor.getName(), doctor.getDepartment()) != null) {
            throw new Exception("Doctor already exists");
        } else {
            doctorRepository.save(doctor);
        }
    }

    @Transactional
    public List<DoctorDTO> getAllDoctors() {
        return StreamSupport
                .stream(doctorRepository.findAll().spliterator(), false)
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteDoctor(DepartmentDTO departmentDTO, DoctorDTO doctorDTO) throws Exception {

        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Department department = departmentMapper.toEntity(departmentDTO);
        doctor.setDepartment(department);

        if(doctorRepository.findByNameAndDepartment(doctor.getName(), doctor.getDepartment()) == null) {
            throw new Exception("Doctor does not exist");
        } else {
            doctorRepository.deleteByNameAndDepartment(doctor.getName(), doctor.getDepartment());
        }
    }

}
