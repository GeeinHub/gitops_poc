package g.gitops.poc.domain.milestone.event;


import g.gitops.poc.app.service.MilestoneAppService;
import g.gitops.poc.domain.milestone.constant.MilestoneConstant;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.infrastructure.common.ActiveMQConfig;
import g.gitops.poc.interfaces.event.DocEventSchema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class DocEventConsumer {
    @Autowired
    private MilestoneAppService milestoneAppService;

    private static final Logger log = LoggerFactory.getLogger(PoEventConsumer.class);

    @JmsListener(destination = ActiveMQConfig.TOPIC_DOC)
    public void receiveMessage(@Payload Map<String,Object> msg, MessageHeaders messageHeaders) {
        System.out.println("milestone doc event listener");
        Milestone msInfo = new Milestone();
        msInfo.setReferenceId((String)msg.get(DocEventSchema.REF_ID));
        msInfo.setMilestoneCode(MilestoneConstant.DOC_UPLOADED);
        msInfo.setReferenceType((String)msg.get(DocEventSchema.REF_TYPE));
        msInfo.setReferenceOwner("Disney");
        milestoneAppService.createMilestoneViaMsg(msInfo,new Date());
        //TODO create milestone for doc upload
    }
}
