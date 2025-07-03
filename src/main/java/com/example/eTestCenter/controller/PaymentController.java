package com.example.eTestCenter.controller;

import com.example.eTestCenter.dto.response.ApiResponse;
import com.example.eTestCenter.entity.PaymentReceipt;
import com.example.eTestCenter.service.PaymentReceiptService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentReceiptService paymentReceiptService;

    PaymentController(PaymentReceiptService paymentReceiptService){
        this.paymentReceiptService = paymentReceiptService;
    }

    @PostMapping
    ApiResponse<PaymentReceipt> createPayment(@RequestBody PaymentReceipt request){
        return ApiResponse.<PaymentReceipt>builder()
                .code(200)
                .message("successfully")
                .data(paymentReceiptService.createReceipt(request))
                .build();
    }
}
