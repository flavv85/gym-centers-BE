package com.flavius.gymcenter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private int age;
    private String sex;
    private String avatar;

    @ManyToOne
    private Worktime worktime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Sport> sports;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Payment> payments;

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, int age, String sex, String avatar, Worktime worktime, List<Sport> sports, List<Payment> payments) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.avatar = avatar;
        this.worktime = worktime;
        this.sports = sports;
        this.payments = payments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Worktime getWorktime() {
        return worktime;
    }

    public void setWorktime(Worktime worktime) {
        this.worktime = worktime;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    // methods for adding sports and payments

    public void addSport(Sport sport) {
        if (getSports() == null) {
            this.sports = new ArrayList<>();
        }
        getSports().add(sport);
        sport.setCustomer(this);
    }

    public void addPayment(Payment payment){
        if (getPayments()==null){
            this.payments = new ArrayList<>();
        }
        getPayments().add(payment);
        payment.setCustomer(this);
    }

}
