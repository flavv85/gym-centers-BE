package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.dto.PaymentDto;
import com.flavius.gymcenter.manager.PaymentManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    private final PaymentManagerService paymentManagerService;

    public PaymentController(PaymentManagerService paymentManagerService) {
        this.paymentManagerService = paymentManagerService;
    }

    @GetMapping("/findPaymentById/{id}")
    PaymentDto findPaymentById(@PathVariable Long id) {
        return paymentManagerService.findPaymentById(id);
    }

    @GetMapping("/findPaymentForCustomer/{idCustomer}")
    List<PaymentDto> findPaymentForCustomer(@PathVariable Long idCustomer) {
        return paymentManagerService.findPaymentForCustomer(idCustomer);
    }

    @PostMapping("/addPayment/{idCustomer}")
    PaymentDto addPayment(@RequestBody PaymentDto paymentDto, @PathVariable Long idCustomer){
        return paymentManagerService.addPayment(paymentDto, idCustomer);
    }

    @PutMapping("/editPayment/{id}")
    PaymentDto editPayment(@RequestBody PaymentDto paymentDto, @PathVariable Long id){
        return paymentManagerService.editPayment(paymentDto, id);
    }

    @DeleteMapping("/deletePayment/{id}")
    void deletePayment(@PathVariable Long id){
        paymentManagerService.deletePayment(id);
    }

}
