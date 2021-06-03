package com.qa.ims.controller;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController  implements CrudController<Order> {
	
public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO OrderDAO;
	private Utils utils;
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.OrderDAO = orderDAO;
		this.utils = utils;
}
	@Override
	public List<Order> readAll() {
		List<Order> orders = OrderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}
	@Override
	public Order create() {
		LOGGER.info("Please enter order id");
		Long id = utils.getLong();
				
		Order order = OrderDAO.create(new Order(id));
		LOGGER.info("Order created");
		return order;
	}
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		
		 Order order = OrderDAO.update(new Order(id));
		LOGGER.info("Item Updated");
		return order;
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Order you would like to delete");
		Long Order_id = utils.getLong();
		int order = OrderDAO.delete(Order_id);
		LOGGER.info("Order Deleted");
		return order;
	}
}
