package com.stu.luanvan.repository;

import com.stu.luanvan.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel,Integer> {
}
