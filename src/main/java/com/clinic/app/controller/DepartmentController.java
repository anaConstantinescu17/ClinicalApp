package com.clinic.app.controller;

import com.clinic.app.service.DepartmentService;
import com.clinic.app.service.dto.DepartmentDTO;
import com.clinic.app.service.dto.DoctorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/department")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments () {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{departmentName}/doctors")
    public ResponseEntity<List<DoctorDTO>> getDepartmentDoctors (@PathVariable String departmentName) {
        return new ResponseEntity<>(departmentService.getDepartmentDoctors(departmentName), HttpStatus.OK);
    }

//    @PutMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        try {
            departmentService.addDepartment(departmentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.info("The error is {}", e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            departmentService.deleteById(id);
            return new ResponseEntity<>("Department deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
