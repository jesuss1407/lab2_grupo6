package com.example.lab2_g6.repository;

import com.example.lab2_g6.entity.Transaction;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


    //Cantidad de la transacción
    @Query(value = "select distinct  amount from transaction", nativeQuery = true)
    List<Transaction> buscarCantidad();

    @Query(value = "select distinct status from transaction ", nativeQuery = true)
    List<String > buscarStatus();

    @Query(value = "select distinct  neetwork_free from transaction  ", nativeQuery = true)
    List<Transaction> buscarNetwork();

    @Query(value = "select distinct  currency from transaction ", nativeQuery = true)
    List<Transaction> buscarCriptomonedas();

    @Query(value = "select address from wallet where user_iduser=?1", nativeQuery = true)
    List<Transaction> buscarAddres(int AddresId);

    @Query(value = "select distinct block from transaction;", nativeQuery = true)
    List<Transaction> buscarTrapsactiones();
    @Query(value = "select distinct tx_id from transaction;", nativeQuery = true)
    List<String> numeroTransaccion();

    @Query(value = "select * from transaction where idtransaction = ?1",
            nativeQuery = true)
    List<Transaction> buscarTrans(int id);



}