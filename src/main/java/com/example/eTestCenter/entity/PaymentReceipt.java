package com.example.eTestCenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private float money;
    private String doc;// ngày tạo thanh toán
    private String dop;// ngày thanh toán
    private String status;
    private String lnk;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regis_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RegisForm form;

}
