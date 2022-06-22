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
public class TimeSheet implements Comparable<TimeSheet>{
    Staff staff;
    Task task;
    long workinghour;
    private int index;

    public TimeSheet() {
    }

    public TimeSheet(Staff staff, Task task) {
        this.staff = staff;
        this.task = task;
        this.workinghour = task.getTotalHours();
        this.index = 0;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public long getWorkinghour() {
        return workinghour;
    }

    public void setWorkinghour(long workinghour) {
        this.workinghour = workinghour;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void output() {
        System.out.printf("|%-6s|%-15s|%-6s|%-15s|%12d|\n", staff.getId(), staff.getName(), task.getId(), task.getTitle(), task.getTotalHours());
    }

    @Override
    public int compareTo(TimeSheet o) {
        if (index == o.getIndex()) {
            return 0;
        } else if (index > o.getIndex()) {
            return 1;
        } else {
            return -1;
        }
    }
}
