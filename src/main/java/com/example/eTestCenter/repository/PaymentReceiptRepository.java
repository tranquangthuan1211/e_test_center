package com.example.eTestCenter.repository;

import com.example.eTestCenter.entity.PaymentReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentReceiptRepository extends JpaRepository<PaymentReceipt,String> {
    @Query("SELECT p FROM PaymentReceipt p WHERE p.user.id = :userId")
    List<PaymentReceipt> findByUserId(@Param("userId") String userId);
}
