package com.clinic.app.service.mapper;

import com.clinic.app.config.MapperConfig;
import com.clinic.app.entity.Doctor;
import com.clinic.app.service.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper implements EntityMapper<DoctorDTO, Doctor>{

    @Autowired
    private MapperConfig mapperConfig;
    @Override
    public Doctor toEntity(DoctorDTO dto) {
        Doctor entity = new Doctor();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());

        return entity;
    }

    @Override
    public DoctorDTO toDto(Doctor entity) {
        DoctorDTO dto = new DoctorDTO();

        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());

        return dto;
    }
}
