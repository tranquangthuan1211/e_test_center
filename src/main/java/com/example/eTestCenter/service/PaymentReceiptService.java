package com.example.eTestCenter.service;

import com.example.eTestCenter.dto.request.PaymentRequest;
import com.example.eTestCenter.entity.PaymentReceipt;
import com.example.eTestCenter.entity.User;
import com.example.eTestCenter.repository.PaymentReceiptRepository;
import com.example.eTestCenter.repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PaymentReceiptService {
    private PaymentReceiptRepository paymentReceiptRepository;
    private UserRepository userRepository;
    PaymentReceiptService(PaymentReceiptRepository paymentReceiptRepository, UserRepository userRepository){
        this.paymentReceiptRepository = paymentReceiptRepository;
        this.userRepository = userRepository;
    }

    public PaymentReceipt createReceipt(PaymentRequest request) {
        User user = userRepository.findById(String.valueOf(request.getUserId()))
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));

        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setMoney(request.getMoney());
        receipt.setDoc(request.getDoc());
        receipt.setDop(request.getDop());
        receipt.setStatus(request.getStatus());
        receipt.setLnk(request.getLnk());
        receipt.setUser(user);

        return paymentReceiptRepository.save(receipt);
    }
    public List<PaymentReceipt> getAllReceipts() {
        return paymentReceiptRepository.findAll();
    }
    public List<PaymentReceipt> getReceiptsByUserId(String userId) {
        return paymentReceiptRepository.findByUserId(userId);
    }

}
