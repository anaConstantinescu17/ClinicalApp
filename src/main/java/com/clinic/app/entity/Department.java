package com.clinic.app.entity;

import java.util.List;

public class Department {

    private String name;
    private String description;
    private List<Doctor> doctors;

    public Department(String name, String description, List<Doctor> doctors) {
        this.name = name;
        this.description = description;
        this.doctors = doctors;
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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
