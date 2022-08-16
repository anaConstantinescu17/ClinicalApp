package com.clinic.app.service.dto;

import com.clinic.app.entity.Department;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DoctorDTO {
    private String name;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
}
