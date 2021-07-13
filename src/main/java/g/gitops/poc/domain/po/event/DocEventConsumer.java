package g.gitops.poc.domain.po.event;

import g.gitops.poc.domain.milestone.event.PoEventConsumer;
import g.gitops.poc.infrastructure.common.ActiveMQConfig;
import g.gitops.poc.interfaces.event.DocEventSchema;
import g.gitops.poc.interfaces.event.DocEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "poDocEventConsumer")
public class DocEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(PoEventConsumer.class);

    @JmsListener(destination = ActiveMQConfig.TOPIC_DOC)
    public void receiveMessage123(@Payload Map<String,Object> msg, MessageHeaders messageHeaders) {
        System.out.println("po doc event listener");
        String refType = (String)msg.get(DocEventSchema.REF_TYPE);
        if(DocEventType.DOC_REF_TYPE_PO.name().equals(refType)){
            List<String> docs = (List<String>)msg.get(DocEventSchema.DOCS);
            //TODO link po object with doc objects
            log.debug("receiving docs of total count:"+docs.size());
        }
    }
}
