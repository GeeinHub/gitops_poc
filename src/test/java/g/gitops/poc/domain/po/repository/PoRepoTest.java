package g.gitops.poc.domain.po.repository;

import g.gitops.poc.domain.po.entity.Po;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PoRepoTest {

    @Autowired
    PoRepo poRepo;

    @Test
    public void testSaveAndFind(){
        Po po = new Po();
        po.setCreatedBy("dongja3");
        Po newPo= poRepo.save(po);
        Assert.assertEquals("dongja3", newPo.getCreatedBy());

    }


}
