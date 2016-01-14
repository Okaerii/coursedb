package edu.buaa.scse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wood on 2016/1/11.
 */
@Entity
@Table
public class Classroom {
    private String id;
    private int size;
    private  String location;
    @Id
    @Column(nullable = false , unique = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(nullable = true)
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
