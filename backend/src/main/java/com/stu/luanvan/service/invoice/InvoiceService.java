package com.stu.luanvan.service.invoice;

import com.stu.luanvan.locales.ExceptionLocales;
import com.stu.luanvan.model.invoice.InvoiceModel;
import com.stu.luanvan.model.invoicedetails.InvoiceDetailsModel;
import com.stu.luanvan.repository.InvoiceDetailsRepository;
import com.stu.luanvan.repository.InvoiceRepository;
import com.stu.luanvan.request.BillRequest;
import com.stu.luanvan.request.InvoiceRequest;
import com.stu.luanvan.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class InvoiceService implements InvoiceServiceInterface{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;
    @Autowired
    private ProductService productService;
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
    public InvoiceModel saveNew(InvoiceRequest invoiceRequest) throws Exception{
        try{
            var code = (int) Math.floor(((Math.random() * 89999) + 10000));
            var billCode = (invoiceRequest.getPayment() + invoiceRequest.getNumberPhone().substring(7) + code);
            var i = new InvoiceModel(invoiceRequest.getNumberPhone(), invoiceRequest.getAddress(),
                    invoiceRequest.getNote(), billCode, invoiceRequest.getPayment());
            var invoice = invoiceRepository.saveAndFlush(i);
            invoiceRequest.getInvoiceDetailsRequests().forEach(c->{
                var product = productService.findById(c.getProductId());
                var invoicedetails = new InvoiceDetailsModel(c.getName(), c.getAmount(), c.getPrice(), product, invoice);
                invoiceDetailsRepository.saveAndFlush(invoicedetails);
            });
            return invoice;
        } catch (Exception ex){
            logger.error("Save New Invoice: ",ex);
            throw new Exception(ExceptionLocales.INTERNAL_SERVER_ERROR);
        }
    }

    public InvoiceModel savePayment(BillRequest billRequest) throws Exception{
        try{
            var invoice = invoiceRepository.findByBillCode(billRequest.getBillCode());
            if(invoice != null){
                invoice.setStatusPayment(true);
            }
            return invoiceRepository.save(invoice);
        }
        catch (Exception ex){
            logger.error("Save Payment: ",ex);
            throw new Exception(ExceptionLocales.INTERNAL_SERVER_ERROR);
        }
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
