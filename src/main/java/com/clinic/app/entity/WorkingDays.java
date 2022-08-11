package com.clinic.app.entity;
import java.time.LocalTime;

public class WorkingDays {
    private Integer id;
    private Days day;
    private LocalTime startTime;
    private LocalTime endTime;

    public WorkingDays(Days day, LocalTime starTime, LocalTime endTime) {
        this.day = day;
        this.startTime = starTime;
        this.endTime = endTime;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
