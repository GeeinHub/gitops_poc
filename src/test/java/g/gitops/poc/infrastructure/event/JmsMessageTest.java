package g.gitops.poc.infrastructure.event;

import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.event.PoCreateEvent;
import g.gitops.poc.interfaces.event.PoEventType;
import g.gitops.poc.infrastructure.common.ActiveMQConfig;
import g.gitops.poc.infrastructure.common.event.JacksonToObject;
import g.gitops.poc.infrastructure.common.event.JmsEventPublisher;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.TextMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class JmsMessageTest {

    @Autowired
    JmsEventPublisher jmsEventPublisher;

    @Autowired
    JacksonToObject jacksonToObject;

    @Autowired
    private JmsTemplate jmsTemplate;

    //@Test
    public void sendReceiveMessage() throws Exception {
        System.out.println("Start JmsMessageTest.sendReceiveMessage");
        Po po = new Po();
        po.setId("123456");
        po.setPoNum("PO 123456");

        jmsEventPublisher.send(PoCreateEvent.create(PoEventType.CREATE_PO, po), ActiveMQConfig.TOPIC_PO);

        TextMessage textMsg = (TextMessage) jmsTemplate.receive(ActiveMQConfig.TOPIC_PO);

        PoCreateEvent event = (PoCreateEvent) jacksonToObject.toObject(textMsg.getText(),PoCreateEvent.class);

        assertEquals(PoEventType.CREATE_PO,event.getPoEventType());
        Assertions.assertEquals(po,event.getPo());
        System.out.println("End JmsMessageTest.sendReceiveMessage");
    }

}
