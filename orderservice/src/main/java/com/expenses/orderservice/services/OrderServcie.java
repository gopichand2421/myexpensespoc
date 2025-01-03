package com.expenses.orderservice.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.orderservice.dto.OrderDto;
import com.expenses.orderservice.entities.Invoice;
import com.expenses.orderservice.entities.Order;
import com.expenses.orderservice.entities.OrderManagement;
import com.expenses.orderservice.exceptions.BadRequestException;
import com.expenses.orderservice.exceptions.OutOfStockException;
import com.expenses.orderservice.repositories.InvoiceRepository;
import com.expenses.orderservice.repositories.OrderManagementRepository;
import com.expenses.orderservice.repositories.OrderRepository;

@Service
public class OrderServcie {

	private InvoiceRepository invoiceRepository;

	private OrderManagementRepository orderManagementRepository;

	private OrderRepository orderRepository;

	@Autowired
	public OrderServcie(InvoiceRepository invoiceRepository, OrderManagementRepository orderManagementRepository,
			OrderRepository orderRepository) {
		this.invoiceRepository = invoiceRepository;
		this.orderManagementRepository = orderManagementRepository;
		this.orderRepository = orderRepository;
	}

	public String createOrder(OrderDto orderDto) {

		if (orderDto != null) {
			// inventory status check
			if (true) {
				Order order = new Order();
				order.setOrderDate(LocalDate.now());
				
				OrderManagement orderManagement = new OrderManagement();
				orderManagement.setOrder(order);
				orderManagement.setCount(orderDto.getQuantity());
				orderManagement.setProductId(orderDto.getProductId());
				
				order.setOrderManagement(orderManagement);
				
				Invoice invoice = new Invoice();
				invoice.setBilldate(LocalDate.now());
				invoice.setOrderManagement(orderManagement);
				invoice.setPrice(0);
				
				orderManagement.setInvoice(invoice);

				invoiceRepository.save(invoice);
				orderManagementRepository.save(orderManagement);
				orderRepository.save(order);
			} else {
				throw new OutOfStockException("Out of stock");
			}
		} else {
			throw new BadRequestException("bad Request");
		}

		return null;
	}

}
