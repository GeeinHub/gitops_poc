package g.gitops.poc.app.service;

import g.gitops.poc.app.service.impl.MilestoneAppServiceImpl;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.milestone.service.MilestoneDomService;
import g.gitops.poc.domain.testdata.MilestoneData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class MilestoneAppServiceTest {
    @TestConfiguration
    static class MilestoneAppServiceTestContextConfiguration {
        @Bean
        public MilestoneAppService milestoneAppService() {
            return new MilestoneAppServiceImpl();
        }
    }

    @Autowired
    private MilestoneAppService milestoneAppService;

    @MockBean
    private MilestoneDomService milestoneDomService;

    private List<Milestone> milestoneList;

    private Milestone ms1;

    @Before
    public void setUp(){
        ms1 = MilestoneData.milestone1();
        Milestone ms2 = MilestoneData.milestone2();
        milestoneList = Arrays.asList(ms1,ms2);
        Mockito.when(milestoneDomService.findByReferenceIdAndReferenceType(ms1.getReferenceId(),ms1.getReferenceType())).thenReturn(milestoneList);
    }

    @Test
    public void whenCriteriaOK_thenReturnRigthCollection(){
        Assert.assertEquals(milestoneList,milestoneAppService.searchMilestone(ms1.getReferenceId(),ms1.getReferenceType()));
    }

    @Test
    public void whenCriteriaWrong_thenReturnEmptyCollection(){
        Assert.assertEquals(new ArrayList<>(),milestoneAppService.searchMilestone("random",""));
    }

    @Test
    public void testCreateViaMsg() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date baseDate = formatter.parse("11-07-2021");
        Date expDate = formatter.parse("10-07-2021");

        Milestone msInfo = MilestoneData.milestone1();
        msInfo.setExpectedDate(expDate);
        Mockito.when(milestoneDomService.
                calculateMilestoneExpectedDate("POCreated","Disney",baseDate)).thenReturn(expDate);
        Mockito.when(milestoneDomService.createMilestone(Mockito.any(Milestone.class))).thenReturn(msInfo);
        Milestone newMs = milestoneAppService.createMilestoneViaMsg(msInfo,baseDate);
        assertThat(newMs.getExpectedDate()).isEqualTo(expDate);

    }
}
