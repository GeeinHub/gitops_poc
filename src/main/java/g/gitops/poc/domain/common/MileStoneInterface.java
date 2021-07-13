package g.gitops.poc.domain.common;

import java.util.Date;

public interface MileStoneInterface {
    Date getTime();

    String getAction();

    String getDetails();

    String getClassName();

    String getRefId();
}
