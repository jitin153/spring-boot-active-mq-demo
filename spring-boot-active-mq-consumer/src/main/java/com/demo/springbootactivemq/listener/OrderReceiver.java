package com.demo.springbootactivemq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.demo.springbootactivemq.model.Order;

@Component
public class OrderReceiver {

	private static final Logger LOG = LoggerFactory.getLogger(OrderReceiver.class);

	@JmsListener(destination = "${active.mq.queue.name.order}")
	public void readMessage(Order order) {
		LOG.info("Order Received: {}", order);
	}
}
