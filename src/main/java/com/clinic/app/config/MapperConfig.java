package com.clinic.app.config;

import com.clinic.app.service.mapper.DepartmentMapper;
import com.clinic.app.service.mapper.DoctorMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public DepartmentMapper getDepartmentMapper() {
        return new DepartmentMapper();
    }

    @Bean
    public DoctorMapper getDoctorMapper() {
        return new DoctorMapper();
    }
}
