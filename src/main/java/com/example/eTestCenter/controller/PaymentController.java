package com.example.eTestCenter.controller;

import com.example.eTestCenter.dto.request.PaymentRequest;
import com.example.eTestCenter.dto.response.ApiResponse;
import com.example.eTestCenter.entity.PaymentReceipt;
import com.example.eTestCenter.service.PaymentReceiptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentReceiptService paymentReceiptService;

    PaymentController(PaymentReceiptService paymentReceiptService){
        this.paymentReceiptService = paymentReceiptService;
    }

    @PostMapping
    ApiResponse<PaymentReceipt> createPayment(@RequestBody PaymentRequest request){
        return ApiResponse.<PaymentReceipt>builder()
                .code(200)
                .message("successfully")
                .data(paymentReceiptService.createReceipt(request))
                .build();
    }
    @GetMapping
    ApiResponse<List<PaymentReceipt>> getAllPayments(){
        return ApiResponse.<List<PaymentReceipt>>builder()
                .data(paymentReceiptService. getAllReceipts())
                .code(200)
                .message("successfully")
                .build();
    }
}
