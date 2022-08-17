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

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    public final DoctorService doctorService;
    public final DepartmentService departmentService;

    public DoctorController(DoctorService doctorService, DepartmentService departmentService) {
        this.doctorService = doctorService;
        this.departmentService = departmentService;
    }

    @PostMapping("/{departmentName}/add")
    public ResponseEntity<?> addDoctor (@PathVariable String departmentName, @RequestBody DoctorDTO doctorDTO) {
        try {

            DepartmentDTO departmentDTO = departmentService.findById(departmentName);
            doctorService.addDoctor(departmentDTO, doctorDTO);

            return new ResponseEntity<>("Doctor added", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(path = "/{departmentName}/delete", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable String departmentName, @RequestBody DoctorDTO doctorDTO) {
        try {
            DepartmentDTO departmentDTO = departmentService.findById(departmentName);
            doctorService.deleteDoctor(departmentDTO, doctorDTO);

            return new ResponseEntity<>("Doctor deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors () {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }
}
