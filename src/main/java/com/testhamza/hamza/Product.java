package com.testhamza.hamza;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {
    private int id;
    private String name;
    private String descrption;
    private String category;
    private String creation_date;

    protected Product() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getName() {
        return name;
    }

    public String getDescrption() {
        return descrption;
    }

    public String getCategory() {
        return category;
    }

    public String getCreation_date() {
        return creation_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    // other getters and setters are hidden for brevity
}