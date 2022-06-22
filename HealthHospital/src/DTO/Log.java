/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Log implements Comparable<Log> {
    private Pet pet;
    private Service service;
    private Date date;
    private int index;

    public Log() {
    }

    public Log(Pet pet, Service service) {
        this.pet = pet;
        this.service = service;
        this.date = new Date();
        this.index = 0;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(this.date);
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void output() {
        System.out.printf("|%s|%-6s|%-15s|%-6s|%-15s|%7.1f|\n", getDate(), pet.getId(), pet.getName(), service.getId(), service.getName(), service.getPrice());
    }

    @Override
    public int compareTo(Log l) {
        return date.compareTo(l.date);
    }
}
