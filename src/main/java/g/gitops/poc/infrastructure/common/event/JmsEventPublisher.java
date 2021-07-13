package g.gitops.poc.infrastructure.common.event;

import g.gitops.poc.domain.milestone.event.PoEventConsumer;
import g.gitops.poc.infrastructure.common.ActiveMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Topic;

@Service
public class JmsEventPublisher {

    private static final Logger log = LoggerFactory.getLogger(PoEventConsumer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Object message, String queue) {
        jmsTemplate.convertAndSend(queue, message);
    }

    public void publish(Object message, String msgType, String dest) {
        try {
            Topic topic = jmsTemplate.getConnectionFactory().createConnection()
                    .createSession().createTopic(dest);
            jmsTemplate.convertAndSend(topic, message, m -> {
                m.setStringProperty(ActiveMQConfig.MSG_HEADER_PROP_MSG_TYPE,msgType);
                return m;
            });

        } catch (JMSException e) {
            log.error(e.getMessage(),e);
        }
    }

}