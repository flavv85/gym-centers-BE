package com.flavius.gymcenter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Worktime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String day;
    private String start;
    private String end;

    @Temporal(TemporalType.DATE)
    private Date timetable;

    @ManyToOne Gym gym;

    @OneToMany(mappedBy = "worktime")
    private List<Customer> customers;

    public Worktime(){
        super();
    }

    public Worktime(String day, String start, String end, Date timetable, Gym gym, List<Customer> customers) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.timetable = timetable;
        this.gym = gym;
        this.customers = customers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Date getTimetable() {
        return timetable;
    }

    public void setTimetable(Date timetable) {
        this.timetable = timetable;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    // method for allocating workout to customer

    public void addCustomerForWork(Customer customer){
        if (getCustomers()==null){
            this.customers = new ArrayList<>();
        }
        getCustomers().add(customer);
        customer.setWorktime(this);
    }
}
