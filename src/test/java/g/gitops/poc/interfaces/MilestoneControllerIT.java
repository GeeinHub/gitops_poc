package g.gitops.poc.interfaces;

import g.gitops.poc.app.service.MilestoneAppService;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.testdata.MilestoneData;
import g.gitops.poc.infrastructure.util.JsonUtil;
import g.gitops.poc.interfaces.api.MilestoneController;
import g.gitops.poc.interfaces.dto.MilestoneSearchDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.reset;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MilestoneController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class MilestoneControllerIT {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MilestoneAppService milestoneAppService;

    private List<Milestone> milestones;

    private Milestone ms1;

    private Milestone ms2;

    @Before
    public void setup(){
        ms1 = MilestoneData.milestone1();
        ms2 = MilestoneData.milestone2();
        milestones = Arrays.asList(ms1,ms2);
        Mockito.when(milestoneAppService.searchMilestone(ms1.getReferenceId(),ms1.getReferenceType())).thenReturn(milestones);
    }

    @Test
    public void testSearchMilestone() throws Exception {
        MilestoneSearchDto criteria = new MilestoneSearchDto();
        criteria.setRefId(ms1.getReferenceId());
        criteria.setRefType(ms1.getReferenceType());
        //MvcResult result =
                mvc.perform(post("/milestone/v1/search").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toMessage(criteria))).andExpect(status().isOk())//.andReturn();
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id",is("XXX1")))
                .andExpect(jsonPath("$[1].id",is("XXX2")));
//        System.out.println(result);
        verify(milestoneAppService, VerificationModeFactory.times(1)).searchMilestone(ms1.getReferenceId(),ms1.getReferenceType());
        reset(milestoneAppService);
    }

}
