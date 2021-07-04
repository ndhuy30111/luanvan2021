package com.stu.luanvan.repository;

import com.stu.luanvan.model.invoice.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel,Integer> {
   InvoiceModel findByBillCode(String billCode);
   Collection<InvoiceModel>  findByStatus(Integer status);
   Collection<InvoiceModel>  findByStatusAndLastModifiedDateAfterAndLastModifiedDateBefore(Integer status, Date start, Date end);
   Collection<InvoiceModel> findByStatusLessThanAndStatusGreaterThan(Integer min,Integer max);
}
