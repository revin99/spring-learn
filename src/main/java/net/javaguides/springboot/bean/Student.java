package net.javaguides.springboot.bean;

public class Student {

    private int id;
    private String fname;
    private String lname;

    public Student(String lname, String fname, int id) {
        this.lname = lname;
        this.fname = fname;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
