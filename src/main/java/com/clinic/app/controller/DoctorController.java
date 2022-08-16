package com.clinic.app.controller;

import com.clinic.app.entity.Department;
import com.clinic.app.entity.Doctor;
import com.clinic.app.service.DepartmentService;
import com.clinic.app.service.DoctorService;
import com.clinic.app.service.dto.DepartmentDTO;
import com.clinic.app.service.dto.DoctorDTO;
import com.clinic.app.service.mapper.DepartmentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DoctorController {

    public final DoctorService doctorService;
    public final DepartmentService departmentService;

    public DoctorController(DoctorService doctorService, DepartmentService departmentService) {
        this.doctorService = doctorService;
        this.departmentService = departmentService;
    }

    @PostMapping("/{departmentName}/save")
    public ResponseEntity<?> addDoctor (@PathVariable String departmentName, @RequestBody DoctorDTO doctorDTO) {
        try {

            DepartmentDTO departmentDTO = departmentService.findById(departmentName);
            doctorService.addDoctor(departmentDTO, doctorDTO);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //getAllDoctors /api/doctors
    //getDoctorsByDepartment /api/{}/all
    //delete
}
