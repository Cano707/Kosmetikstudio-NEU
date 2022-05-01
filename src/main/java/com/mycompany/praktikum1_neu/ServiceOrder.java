/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum1_neu;

import java.util.Date;

/**
 *
 * @author cano
 */
public class ServiceOrder  {
    private Service service;
    private Date appointment;
    private String time;

    public ServiceOrder(Service service, Date appointment, String time) {
        this.service = service;
        this.appointment = appointment;
        this.time = time;
    }

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ServiceOrder(Date date) {
        this.appointment = date;
    }

    public Date getDate() {
        return appointment;
    }

    public void setDate(Date date) {
        this.appointment = date;
    }
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
