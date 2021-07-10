package com.flavius.gymcenter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double cost;
    private String duration;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private Customer customer;

    public Payment(){
        super();
    }

    public Payment(double cost, String duration, Date date, Customer customer) {
        super();
        this.cost = cost;
        this.duration = duration;
        this.date = date;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
