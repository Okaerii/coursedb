package edu.buaa.scse.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

/**
 * Created by wood on 2016/1/12.
 */
@Entity
@Table
public class User {

    private String id;
    private String password;
    private int power;
    @Id
    @Column(nullable = false,unique = true)
    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Range(min =0,max=1)
    @Column(nullable = false)
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Column(length = 10,nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
