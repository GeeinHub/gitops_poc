package g.gitops.poc.domain.milestone.repository;

import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.testdata.MilestoneData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MilestoneRepoTest {

    @Autowired
    private MileStoneRepo mileStoneRepo;

    @Test
    public void testSaveThenFindByReferenceIdAndReferenceType(){
        Milestone milestone1 = MilestoneData.milestone1();
        Milestone milestone2 = MilestoneData.milestone2();
        List<Milestone> milestoneList = Arrays.asList(milestone1,milestone2);
        mileStoneRepo.save(milestone1);
        mileStoneRepo.save(milestone2);

        Assert.assertEquals(2,mileStoneRepo.findByReferenceIdAndReferenceType("TestPO1","PO").size());
        mileStoneRepo.deleteAll();
    }
}
