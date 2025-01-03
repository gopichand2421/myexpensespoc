package com.expenses.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenses.orderservice.entities.OrderManagement;
@Repository
public interface OrderManagementRepository extends JpaRepository<OrderManagement, Long>{

	
}
