/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private String gender;
    private String address;
    private Campus campus;

    public Student(String id, String name, String gender, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
    
    public void output() {
        System.out.printf("|%-8s|%-15s|%6s|%20s|", id, name, gender, address);
        if (campus != null) {
            System.out.printf("%6s|\n", campus.getCode());
        } else System.out.printf("%6s|\n", "None");
    }
    
    @Override
    public int compareTo(Student o) {
        return id.compareToIgnoreCase(o.id);
    }
    
    public Campus checkCampus() {
        if (campus != null) {
            return campus;
        }
        return null;
    }
    
}
