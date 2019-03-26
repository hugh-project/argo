package com.argo.region.business.configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <ul>
 * <li>公司名称 : 力微和</li>
 * <li>文件名称 : com.argo.region.business.configuration.AmqpConfiguration</li>
 * <li>创建时间 : 2019年03月26日</li>
 * <li>描    述 :
 * <p>
 * </ul>
 *
 * @author XiaoLong.Tu
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(RegionProperties.class)
public class AmqpConfiguration {




    @Bean("pointTaskContainerFactory")
    public SimpleRabbitListenerContainerFactory pointTaskContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory, RegionProperties properties) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setPrefetchCount(properties.getMq().getMaxCount());
        factory.setConcurrentConsumers(properties.getMq().getMaxThreads());
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
