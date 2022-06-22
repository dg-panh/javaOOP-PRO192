/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author PC
 */
public class Task implements Comparable<Task>{
    private String id;
    private String title;
    private String beginDate;
    private String endDate;
    private long totalHours;

    public Task() {
    }

    public Task(String id, String title, String beginDate, String endDate) {
        this.id = id;
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.totalHours = getTotalHours(beginDate, endDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    private long getTotalHours(String beginDate, String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        try {
            Date date1 = formatter.parse(beginDate);
            Date date2 = formatter.parse(endDate);
            
            long date = date2.getTime() - date1.getTime();
            totalHours = TimeUnit.MILLISECONDS.toHours(date);
        } catch (ParseException e) {
        }
        return totalHours;
    }
    
    public long getTotalHours() {
        return totalHours;
    }

    public void setTotalHours() {
        this.totalHours = getTotalHours(beginDate, endDate);
    }
    
    public void output() {
        System.out.printf("|%-6s|%-15s|%16s|%16s|%12d|\n", id, title, beginDate, endDate, totalHours);
    }

    @Override
    public int compareTo(Task t) {
        return id.compareToIgnoreCase(t.id);
    }
    
    public boolean checkEndDate(String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        
        try {
            Date date1 = formatter.parse(beginDate);
            Date date2 = formatter.parse(endDate);
            
            if(date2.before(date1))
                throw new Exception();
            return true;
        } catch (ParseException e) {
            System.out.println(e);
            return false;
        } catch (Exception e) {
            System.out.println("The end date cannot be before the begin date. ");
            return false;
        }
    }
}
