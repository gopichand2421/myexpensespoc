package com.expenses.orderservice.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "invoice_table")
public class Invoice extends BaseEntity{
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "bill_date")
	private LocalDate billdate;
	
	@OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
	private OrderManagement orderManagement;
}
