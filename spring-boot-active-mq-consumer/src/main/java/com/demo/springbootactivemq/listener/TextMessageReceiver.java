package com.demo.springbootactivemq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TextMessageReceiver {

	private static final Logger LOG = LoggerFactory.getLogger(TextMessageReceiver.class);

	@JmsListener(destination = "${active.mq.queue.name.messages}")
	public void readMessage(String msg) {
		LOG.info("Message received: {}", msg);
	}

}
