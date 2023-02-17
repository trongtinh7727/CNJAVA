package com.tinne.pojo;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Manufacture")
public class Manufacture implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String location;
    private int employee;

    @OneToMany(mappedBy = "manufacture")//mặc định fetch = FetchType.LAZY
    private List<Phone> phones;//1 khai bào list product

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public List<Phone> getProducts() {
        return phones;
    }

    public void setProducts(List<Phone> products) {
        this.phones = products;
    }
}
