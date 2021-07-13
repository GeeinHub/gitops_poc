package g.gitops.poc.domain.po.event;

import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.interfaces.event.PoEventType;
import lombok.Data;


/**
 * use PoEvent instead
 */
@Data
@Deprecated
public class PoCreateEvent {
    private PoEventType poEventType;
    //this is a sample, you may define your needed attribute here
    // put whole domain object here is not recommended.
    private Po po;



    public static  PoCreateEvent create (PoEventType poEventType, Po po){
        PoCreateEvent event = new PoCreateEvent();
        event.setPo(po);
        event.setPoEventType(poEventType);
        return event;
    }
}
