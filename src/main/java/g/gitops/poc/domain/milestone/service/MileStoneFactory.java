package g.gitops.poc.domain.milestone.service;

import g.gitops.poc.domain.common.MileStoneInterface;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.infrastructure.util.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MileStoneFactory {
    static Logger logger = LoggerFactory.getLogger(MileStoneFactory.class);

    public Milestone createMileStone(MileStoneInterface msi) {
        Milestone mileStone = new Milestone();
        mileStone.setId(IdGenerator.nextId());
        BeanUtils.copyProperties(msi, mileStone);
        return mileStone;
    }

}
