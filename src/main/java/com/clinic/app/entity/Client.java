package com.clinic.app.entity;

import java.util.List;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private String telephone;
    private String email;
    private List<Request> requestList;

    public Client(UUID id, String name, String telephone, String email, List<Request> requestList) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.requestList = requestList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }
}
