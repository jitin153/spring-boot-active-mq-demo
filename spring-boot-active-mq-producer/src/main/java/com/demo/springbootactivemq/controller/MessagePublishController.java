package com.demo.springbootactivemq.controller;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootactivemq.model.Order;
import com.demo.springbootactivemq.model.Product;

@RestController
public class MessagePublishController {

	//private static final Logger LOG = LoggerFactory.getLogger(MessagePublishController.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	// @Autowired
	// private Topic topic;
	@Autowired
	private Queue queueOrder;

	@Autowired
	private Queue queueMessages;

	@GetMapping("/sendmsg/{msg}")
	public String publishMsg(@PathVariable("msg") String msg) {
		try {
			jmsTemplate.convertAndSend(queueMessages, msg);
			return "Message published...";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@GetMapping("/placeorder")
	public String publishOrder() {
		try {
			jmsTemplate.convertAndSend(queueOrder, prepareOrder());
			return "Order Published...";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private static Order prepareOrder() {
		Product laptop = new Product(1001L, "Laptop", new BigDecimal(56000), (short) 1);
		Product bag = new Product(1002L, "Bag", new BigDecimal(1200), (short) 1);
		Product dataCable = new Product(1003L, "Data Cable", new BigDecimal(200), (short) 2);
		return new Order(101L, Arrays.asList(laptop, bag, dataCable), "Andheri East, Mumbai, MH");
	}
}
