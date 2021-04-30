package ru.kapishev.count_value.counters_crud;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "counter")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CounterModel {
    @Id
    @Column(name = "id_c")
    @SequenceGenerator(name = "counteridcseq", sequenceName = "counter_id_c_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "counteridcseq")
    private int id;
    @Column(name = "sn")
    private String sn;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private int building;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }
}
