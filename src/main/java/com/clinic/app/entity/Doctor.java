package com.clinic.app.entity;

import java.util.List;
import java.util.UUID;

public class Doctor {
    private UUID id;
    private String name;
    private String description;
    private List<WorkingDays> programme;
    private Request appointments;

    public Doctor(UUID id, String name, String description, List<WorkingDays> programme, Request appointments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.programme = programme;
        this.appointments = appointments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WorkingDays> getProgramme() {
        return programme;
    }

    public void setProgramme(List<WorkingDays> programme) {
        this.programme = programme;
    }

    public Request getAppointments() {
        return appointments;
    }

    public void setAppointments(Request appointments) {
        this.appointments = appointments;
    }
}
