package com.clinic.app.repository;

import com.clinic.app.entity.Department;
import com.clinic.app.entity.Doctor;
import com.clinic.app.service.dto.DoctorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer>, JpaRepository<Doctor, Integer> {
    Doctor findByNameAndDepartment(String name, Department department);
    void deleteByNameAndDepartment(String name, Department department);





}
