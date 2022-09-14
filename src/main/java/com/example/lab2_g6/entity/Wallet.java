package com.example.lab2_g6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "idwallet", nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @Column(name = "total_usd", nullable = false, length = 45)
    private String totalUsd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotalUsd() {
        return totalUsd;
    }

    public void setTotalUsd(String totalUsd) {
        this.totalUsd = totalUsd;
    }

}