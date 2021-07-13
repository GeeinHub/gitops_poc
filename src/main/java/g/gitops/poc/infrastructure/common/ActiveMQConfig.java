package g.gitops.poc.infrastructure.common;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.Queue;
import javax.jms.Topic;

@EnableJms
@Configuration
public class ActiveMQConfig {

    public static final String TOPIC_PO = "ISCMS_T_PO";
    public static final String TOPIC_MILESTONE = "ISCMS_T_MILESTONE";
    public static final String TOPIC_DOC = "ISCMS_T_DOC";


    public static final String MSG_HEADER_PROP_MSG_TYPE = "msgType";

    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
//        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(messageConverter());
        return factory;
    }

//    @Bean
//    public CachingConnectionFactory connectionFactory() {
//        CachingConnectionFactory cachConnectionFactory = new CachingConnectionFactory();
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        connectionFactory.setBrokerURL("vm://localhost?broker.persistent=false");
//        cachConnectionFactory.setTargetConnectionFactory(connectionFactory);
//        return cachConnectionFactory;
//    }

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean(name = "topicPo")
    public Topic topicPo(){
        return  new ActiveMQTopic(TOPIC_PO);
    }

    @Bean(name = "topicMileStone")
    public Topic topicMileStone(){
        return  new ActiveMQTopic(TOPIC_MILESTONE);
    }

    @Bean(name = "topicDoc")
    public Topic topicDoc(){
        return new ActiveMQTopic(TOPIC_DOC);
    }

}