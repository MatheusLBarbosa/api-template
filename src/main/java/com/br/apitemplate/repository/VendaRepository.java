package com.br.apitemplate.repository;

import com.br.apitemplate.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface VendaRepository extends JpaRepository<Venda, BigInteger> {
}
