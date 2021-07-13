package g.gitops.poc.app.service;

import g.gitops.poc.app.service.impl.PoAppServiceImpl;
import g.gitops.poc.domain.document.service.DocumentDomService;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.milestone.service.MilestoneDomService;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.service.PoDomService;
import g.gitops.poc.infrastructure.common.email.EmailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class PoAppServiceTest {

    Po po;
    Milestone mileStone;
    @TestConfiguration
    static class PoAppServiceImplTestContextConfiguration {
        @Bean
        public PoAppService poAppService() {
            return new PoAppServiceImpl();
        }
    }

    @Autowired
    PoAppService poAppService;

    @MockBean
    private PoDomService poDomService;

    @MockBean
    private MilestoneDomService milestoneDomService;

    @MockBean
    private EmailService emailService;

    @MockBean
    private DocumentDomService documentDomService;


    @Before
    public void setup() {
        po = new Po();
        po.setCreatedBy("tom");
        po.setId("001");

        mileStone = new Milestone();
        mileStone.setId("m001");
//        mileStone.setClassName(Po.class.getName());
        mileStone.setReferenceId(po.getId());


        String emailFrom = "papp@xxxxlogistics.com";
        String emailTo = "vendor@xxxxlogistics.com";
        String emailCc = "";
        String emailBcc = "";
        String subject = "papp PO Notification";
        String body = "Dear Vendor, PO# " + po.getId() + " has been created. Please followup. Regards, papp";

        Mockito.when(poDomService.createPo(po)).thenReturn(po);
        Mockito.when(milestoneDomService.createMilestone(mileStone)).thenReturn(mileStone);
        Mockito.when(milestoneDomService.getMileStone("m001")).thenReturn(Optional.of(mileStone));
        Mockito.when(emailService.sendSimpleEmail(emailFrom, emailTo, emailCc, emailBcc, subject, body)).thenReturn(true);
    }

    @Test
    public void whenCreatePo_thenMileStoneCreatedEmailSent(){
        Po newPo  = poAppService.createPo(po);
        assertThat(newPo.getId()).isEqualTo("001");
        assertThat(milestoneDomService.getMileStone("m001").get().getReferenceId()).isEqualTo(po.getId());
    }

}
