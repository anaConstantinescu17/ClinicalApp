package com.clinic.app.controller;

import com.clinic.app.service.DepartmentService;
import com.clinic.app.service.dto.DepartmentDTO;
import com.clinic.app.service.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/department")
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

    @RequestMapping(path = "/add", method= RequestMethod.PUT)
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        try {
            return new ResponseEntity<>(departmentService.addDepartment(departmentDTO).toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(path = "/{id}/delete", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            departmentService.deleteById(id);
            return new ResponseEntity<>("Department deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
