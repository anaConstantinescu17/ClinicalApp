package com.clinic.app.service.mapper;

import com.clinic.app.config.MapperConfig;
import com.clinic.app.entity.Department;
import com.clinic.app.service.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DepartmentMapper implements EntityMapper<DepartmentDTO, Department>{

    @Autowired
    private MapperConfig mapperConfig;


    @Override
    public Department toEntity(DepartmentDTO dto) {
        Department entity = new Department();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDoctors(dto.getDoctorDTOList()
                .stream()
                .map(x -> mapperConfig.getDoctorMapper().toEntity(x))
                .collect(Collectors.toList()));


        return entity;
    }

    @Override
    public DepartmentDTO toDto(Department entity) {
        DepartmentDTO dto = new DepartmentDTO();

        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setDoctorDTOList(entity.getDoctors()
                .stream()
                .map(x -> mapperConfig.getDoctorMapper().toDto(x))
                .collect(Collectors.toList()));

        return dto;
    }
}
