package com.example.lab2_g6.repository;

import com.example.lab2_g6.entity.Wallet;
import com.example.lab2_g6.entity.WalletDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository <Wallet, Double> {

    @Query(value = "select address, name, purchase_price, amount from wallet w inner join wallet_has_currency whc on (whc.wallet_idwallet = w.idwallet) \n" +
            "inner join currency c on (whc.currency_idcurrency = c.idcurrency) where user_iduser=1;",
            nativeQuery = true)
    List<WalletDto> obtenerMyWalletDto();
}
