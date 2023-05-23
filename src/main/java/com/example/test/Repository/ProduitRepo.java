package com.example.test.Repository;

import com.example.test.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo  extends JpaRepository <Produit , Long> {
}
