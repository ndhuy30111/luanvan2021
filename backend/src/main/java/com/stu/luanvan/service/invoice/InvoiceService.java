package com.stu.luanvan.service.invoice;

import com.stu.luanvan.model.invoice.InvoiceModel;
import com.stu.luanvan.repository.InvoiceRepository;
import com.stu.luanvan.request.InvoiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
@Service
public class InvoiceService implements InvoiceServiceInterface{
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public Map<String, Object> findByAll(Integer page, Integer size, String nameSort) {
        return null;
    }

    @Override
    public Collection<InvoiceModel> findByAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public InvoiceModel findById(Integer id) {
        return null;
    }

    @Override
    public InvoiceModel saveNew(InvoiceRequest invoiceRequest) throws Exception {
        return null;
    }

    @Override
    public InvoiceModel saveEdit(InvoiceRequest invoiceRequest, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }

    @Override
    public Collection<InvoiceModel> findAllNotReceive() {
        return invoiceRepository.findByStatus(0);
    }
    @Override
    public Collection<InvoiceModel> findAllReceive() {
        return invoiceRepository.findByStatusLessThanAndStatusGreaterThan(0,6);
    }
    @Override
    public Collection<InvoiceModel> findAllCancelReceive() {
        return invoiceRepository.findByStatus(6);
    }
}
