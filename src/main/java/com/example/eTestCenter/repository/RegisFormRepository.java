package com.example.eTestCenter.repository;

import com.example.eTestCenter.entity.PaymentReceipt;
import com.example.eTestCenter.entity.RegisForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegisFormRepository extends JpaRepository<RegisForm, String> {

}

