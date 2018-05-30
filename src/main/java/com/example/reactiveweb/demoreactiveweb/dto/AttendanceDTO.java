package com.example.reactiveweb.demoreactiveweb.dto;

import com.example.reactiveweb.demoreactiveweb.domain.Attendance;
import com.example.reactiveweb.demoreactiveweb.domain.User;

public class AttendanceDTO {

    private String id;
    private String timeStamp;
    private User user;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String id, String timeStamp, User user) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.user = user;
    }

    public AttendanceDTO(Attendance attendance){
        this(attendance.getId(),attendance.getTimeStamp(),attendance.getUser());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AttendanceRepository{" +
                "id='" + id + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", user=" + user +
                '}';
    }
}
