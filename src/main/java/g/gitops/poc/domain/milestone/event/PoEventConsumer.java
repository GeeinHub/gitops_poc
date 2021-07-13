package g.gitops.poc.domain.milestone.event;

import g.gitops.poc.app.service.MilestoneAppService;
import g.gitops.poc.domain.milestone.constant.MilestoneConstant;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.infrastructure.common.ActiveMQConfig;
import g.gitops.poc.interfaces.event.PoEventSchema;
import g.gitops.poc.interfaces.event.PoEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class PoEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(PoEventConsumer.class);

    private MilestoneAppService milestoneAppService;

    //@JmsListener(destination = ActiveMQConfig.TOPIC_PO)
    public void receiveMessage(String msg){
        log.debug("PoEventListener:" + msg);
    }

    @JmsListener(destination = ActiveMQConfig.TOPIC_PO)
    public void receiveMessage(@Payload Map<String,Object> msg, MessageHeaders messageHeaders) {
        String msgType = (String)messageHeaders.get(ActiveMQConfig.MSG_HEADER_PROP_MSG_TYPE);
        log.debug("PoEvent Type" + msgType);
        //Map<String,Object> msg = JsonUtil.toMap(msgText);
        if(PoEventType.CREATE_PO.name().equals(msgType)){
            String refType = "PO";
            String refId = (String)msg.get(PoEventSchema.PO_NUM);
            String refOwner = (String)msg.get(PoEventSchema.CONSIGNEE);
            String milestoneCode = MilestoneConstant.VENDOR_BOOKING_CREATED;
            SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD");
            Date baseDate = null;
            try {
                Milestone msInfo = new Milestone();
                msInfo.setReferenceOwner(refOwner);
                msInfo.setReferenceType(refType);
                msInfo.setMilestoneCode(milestoneCode);
                msInfo.setReferenceId(refId);
                baseDate = sf.parse((String)msg.get(PoEventSchema.SHIP_DATE));
                milestoneAppService.createMilestoneViaMsg(msInfo,baseDate);
            } catch (ParseException e) {
                log.error(e.getMessage(),e);
            }
        }

    }

    @Autowired
    public void setMilestoneAppService(MilestoneAppService milestoneAppService){
        this.milestoneAppService = milestoneAppService;
    }

}
