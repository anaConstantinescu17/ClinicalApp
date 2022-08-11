package com.clinic.app.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Request {
    private Integer id;
    private Department departmentName;
    private Doctor doctor;
    private LocalDateTime appointment;
    private Client client;


    public Request(Department departmentName, Doctor doctor, LocalDateTime appointment, Client client) {
        this.departmentName = departmentName;
        this.doctor = doctor;
        this.appointment = appointment;
        this.client = client;
    }

    public Department getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(Department departmentName) {
        this.departmentName = departmentName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getAppointment() {
        return appointment;
    }

    public void setAppointment(LocalDateTime appointment) {
        this.appointment = appointment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
