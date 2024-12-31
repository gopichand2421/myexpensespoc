package com.expenses.orderservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_management")
public class OrderManagement extends BaseEntity{

	
	@OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
	@Column(name = "product_id")
	private long productId;
	@Column(name = "product_count")
	private int count;
	@OneToOne
	@JoinColumn(name="invoice_id",referencedColumnName ="id")
	private Invoice invoice;
	
	
}
