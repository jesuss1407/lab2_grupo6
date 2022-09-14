package com.example.lab2_g6.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "transaction")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idtransaction")
    private int idtransaction;


    @Column(name = "description")
    private String description;

    @Column(name = "tx_id")
    private String txId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "neetwork_free")
    private double neetworkFree;

    @Column(name = "block")
    private int block;

    @Column(name = "status")
    private String status;

    @Column(name = "currency")
    private String currency;

    @ManyToOne
    @JoinColumn( name ="user_iduser")
    private User userIduser;

    @ManyToOne
    @JoinColumn(name="wallet_idwallet")
    private Wallet walletIdwallet;


}