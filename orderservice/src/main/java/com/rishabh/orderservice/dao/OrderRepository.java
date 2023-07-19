package com.rishabh.orderservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.orderservice.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
