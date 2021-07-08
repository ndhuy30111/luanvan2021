package com.stu.luanvan.service.invoice;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.locales.ExceptionLocales;
import com.stu.luanvan.model.invoice.InvoiceModel;
import com.stu.luanvan.model.invoicedetails.InvoiceDetailsModel;
import com.stu.luanvan.model.user.UserModel;
import com.stu.luanvan.repository.InvoiceDetailsRepository;
import com.stu.luanvan.repository.InvoiceRepository;
import com.stu.luanvan.request.BillRequest;
import com.stu.luanvan.request.InvoiceRequest;
import com.stu.luanvan.response.InvoiceResponse;
import com.stu.luanvan.security.MyUserDetails;
import com.stu.luanvan.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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

    @Override
    public Collection<InvoiceModel> findAllStatus(Integer status) {
        try{
            return invoiceRepository.findByStatus(status);
        }catch (Exception ex){
            logger.error(String.valueOf(ex));
            throw ex;
        }
    }
    @Override
    public InvoiceModel saveStatus(Integer id) throws Exception {
        var invoice = invoiceRepository.findById(id).orElse(null);
        if(invoice == null){
            throw new NotFoundEx(ExceptionLocales.NOT_FOUND_PRODUCT);
        }
        invoice.Status();
        return invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceModel savePaid(Integer id) throws Exception {
        var invoice = invoiceRepository.findById(id).orElse(null);
        if(invoice == null){
            throw new NotFoundEx(ExceptionLocales.NOT_FOUND_PRODUCT);
        }
        invoice.Paid();
        return invoiceRepository.save(invoice);

    }

    @Override
    public InvoiceModel saveDel(Integer id) throws Exception {
        var invoice = invoiceRepository.findById(id).orElse(null);
        if(invoice == null){
            throw new NotFoundEx(ExceptionLocales.NOT_FOUND_PRODUCT);
        }
        invoice.Del();
        return invoiceRepository.save(invoice);
    }
    public Collection<InvoiceResponse> findByCreateByAndStatus(UserModel user, Integer status) {
        try{
            var invoice =  invoiceRepository.findByCreateByAndStatus(user, status);
            Collection<InvoiceResponse> listInvoive = new ArrayList<>();
            invoice.forEach(el -> {
                var invoiceResponse = new InvoiceResponse();
                invoiceResponse.setCreateDate(el.getCreateDate());
                invoiceResponse.setAddress(el.getAddress());
                invoiceResponse.setNumberPhone(el.getNumberPhone());
                invoiceResponse.setBillCode(el.getBillCode());
                invoiceResponse.setStatus(el.getStatus());
                el.getInvoicedetals().forEach(elm -> {
                    invoiceResponse.setName(elm.getName());
                    invoiceResponse.setAmount(elm.getAmount());
                    invoiceResponse.setPrice(elm.getPrice());
                    invoiceResponse.setProductId(elm.getId().getProductId());
                    var product = productService.findById(elm.getId().getProductId());
                    invoiceResponse.setImage(product.getImage().getUrl());
                });
                listInvoive.add(invoiceResponse);
            });
            return listInvoive;
        }catch (Exception ex){
            throw ex;
        }
    }
}
