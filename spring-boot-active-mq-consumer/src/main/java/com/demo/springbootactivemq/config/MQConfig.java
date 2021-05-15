package com.demo.springbootactivemq.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class MQConfig {

	/*@Value("${active.mq.username}")
	private String activeMqUsername;
	
	@Value("${active.mq.password}")
	private String activeMqPassword;
	
	@Value("${active.mq.url}")
	private String activeMqBrokerUrl;*/

	//@Value("${active.mq.queue.name}")
	//private String queueName;
	
	//@Bean public Queue queue() { return new ActiveMQQueue(queueName); }
	 
	
	/*@Bean
	public Topic topic() {
		return new ActiveMQTopic("test.topic");
	}*/

	//@Bean
	//public ActiveMQConnectionFactory activeMQConnectionFactory() {
		//ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(activeMqUsername,activeMqPassword,activeMqBrokerUrl);
		/*activeMQConnectionFactory.setUserName(activeMqUsername);
		activeMQConnectionFactory.setPassword(activeMqPassword);
		activeMQConnectionFactory.setBrokerURL(brokerUrl);*/
		//return activeMQConnectionFactory;
	//}
	
	/*@Bean
	public JmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		configurer.configure(defaultJmsListenerContainerFactory, connectionFactory);
		return defaultJmsListenerContainerFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
	*/

	/*
	 * @Bean public DefaultJmsListenerContainerFactory
	 * jmsListenerContainerFactory(){ DefaultJmsListenerContainerFactory
	 * defaultJmsListenerContainerFactory = new
	 * DefaultJmsListenerContainerFactory();
	 * defaultJmsListenerContainerFactory.setConnectionFactory(
	 * activeMQConnectionFactory());
	 * defaultJmsListenerContainerFactory.setConcurrency("1-1");
	 * defaultJmsListenerContainerFactory.setMessageConverter(messageConverter());
	 * return defaultJmsListenerContainerFactory; }
	 */
	

    @Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(messageConverter());
        configurer.configure(factory, connectionFactory);
        return factory;
    }
	
	@Bean
	public MessageConverter messageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		/*
		 * TypeIdPropertyName can be anything but should be same on both producer & consumer side.
		 */
		converter.setTypeIdPropertyName("_jkg_");
		return converter;
	}
	
	/*
	 * @Bean public JmsListenerContainerFactory jsaFactory(ConnectionFactory
	 * connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
	 * DefaultJmsListenerContainerFactory factory = new
	 * DefaultJmsListenerContainerFactory();
	 * factory.setMessageConverter(messageConverter());
	 * configurer.configure(factory, connectionFactory); return factory; }
	 */
}
