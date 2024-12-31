package com.expenses.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenses.orderservice.entities.Invoice;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
