package com.flavius.gymcenter.managerImpl;

import com.flavius.gymcenter.dao.CustomerDao;
import com.flavius.gymcenter.dao.PaymentDao;
import com.flavius.gymcenter.dto.PaymentDto;
import com.flavius.gymcenter.manager.PaymentManagerService;
import com.flavius.gymcenter.model.Customer;
import com.flavius.gymcenter.model.OrikaBeanMapper;
import com.flavius.gymcenter.model.Payment;
import com.flavius.gymcenter.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PaymentManagerServiceImpl implements PaymentManagerService {

    private final OrikaBeanMapper orikaBeanMapper;
    private final PaymentService paymentService;
    private final PaymentDao paymentDao;
    private final CustomerDao customerDao;

    public PaymentManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, PaymentService paymentService, PaymentDao paymentDao, CustomerDao customerDao) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.paymentService = paymentService;
        this.paymentDao = paymentDao;
        this.customerDao = customerDao;
    }

    @Override
    public PaymentDto addPayment(PaymentDto paymentDto, Long idCustomer) {
        Customer customer = customerDao.findById(idCustomer).orElse(null);
        Payment payment = orikaBeanMapper.map(paymentDto, Payment.class);
        return orikaBeanMapper.convertDTO(paymentService.addPayment(payment, customer), PaymentDto.class);
    }

    @Override
    public PaymentDto editPayment(PaymentDto paymentDto, Long id) {
        Payment payment = orikaBeanMapper.map(paymentDto, Payment.class);
        Payment existsPayment = paymentDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(paymentService.editPayment(payment, existsPayment), PaymentDto.class);
    }

    @Override
    public PaymentDto findPaymentById(Long id) {
        return orikaBeanMapper.convertDTO(paymentDao.findById(id).orElse(null), PaymentDto.class);
    }

    @Override
    public List<PaymentDto> findPaymentForCustomer(Long idCustomer) {
        Customer customer = customerDao.findById(idCustomer).orElse(null);
        List<Payment> payments = customer.getPayments();
        return orikaBeanMapper.convertListDTO(payments, PaymentDto.class);
    }

    @Override
    public void deletePayment(Long id) {
        Payment existsPayment = paymentDao.findById(id).orElse(null);
        paymentDao.delete(existsPayment);
    }
}
