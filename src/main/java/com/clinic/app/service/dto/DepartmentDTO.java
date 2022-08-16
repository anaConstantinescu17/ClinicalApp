package com.clinic.app.service.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DepartmentDTO {
    private String name;
    private String description;
    private List<DoctorDTO> doctorDTOList;
}
