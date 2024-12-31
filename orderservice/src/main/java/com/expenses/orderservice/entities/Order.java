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
@Table(name = "order_table")
public class Order extends BaseEntity {

	@Column(name = "user_id", nullable = false)
	private Long userid;
	
	@Column(name = "order_date", nullable = false)
	private LocalDate orderDate;

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private OrderManagement orderManagement;
}
