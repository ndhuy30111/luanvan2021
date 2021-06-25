package com.stu.luanvan.repository;

import com.stu.luanvan.model.invoice.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel,Integer> {
   Collection<InvoiceModel>  findByStatus(Integer status);
   Collection<InvoiceModel> findByStatusLessThanAndStatusGreaterThan(Integer min,Integer max);
}
