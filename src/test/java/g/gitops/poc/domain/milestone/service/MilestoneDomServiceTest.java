package g.gitops.poc.domain.milestone.service;

import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.milestone.repository.MileStoneRepo;
import g.gitops.poc.domain.milestone.service.impl.MilestoneDomServiceImpl;
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


@RunWith(SpringRunner.class)
public class MilestoneDomServiceTest {
    @TestConfiguration
    static class MilestoneDomServiceTestContextConfiguration {
        @Bean
        public MilestoneDomService milestoneDomService() {
            return new MilestoneDomServiceImpl();
        }
    }

    @Autowired
    private MilestoneDomService milestoneDomService;

    @MockBean
    private MileStoneRepo mileStoneRepo;

    private List<Milestone> milestoneList;

    @Before
    public void setUp(){
        Milestone milestone1 = MilestoneData.milestone1();
        milestoneList = Arrays.asList(milestone1,MilestoneData.milestone2());
        mileStoneRepo.saveAll(milestoneList);
        Mockito.when(mileStoneRepo.findByReferenceIdAndReferenceType(milestone1.getReferenceId(),milestone1.getReferenceType())).thenReturn(milestoneList);
        //Mockito.when(mileStoneRepo.findByReferenceIdAndReferenceType("notexisted","unknown")).thenReturn(null);
    }

    @Test
    public void whenRefIdAndRefTypeOK_thenRelatedMilestoneShouldBeFound(){
        Assert.assertEquals(milestoneList,milestoneDomService.findByReferenceIdAndReferenceType("TestPO1","PO"));
    }

    @Test
    public void whenRefIdAndRefTypeWrong_thenNoMilestoneShouldBeFound(){
        //Assert.assertNull(milestoneDomService.findByReferenceIdAndReferenceType("notexisted","unknown"));
        Assert.assertEquals(new ArrayList<>(),milestoneDomService.findByReferenceIdAndReferenceType("notexisted","unknown"));
    }

    @Test
    public void testCalcExpectedDateWithCode() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date baseDate = formatter.parse("11-07-2021");
        Date expectedDate = formatter.parse("01-07-2021");
        Assert.assertEquals(expectedDate,milestoneDomService.calculateMilestoneExpectedDate("PO Created","123", baseDate));
    }

    @Test
    public void testCalcExpectedDateWithoutCode(){
        Date baseDate = new Date();
        Assert.assertEquals(baseDate,milestoneDomService.calculateMilestoneExpectedDate(null,"", baseDate));
    }



}
