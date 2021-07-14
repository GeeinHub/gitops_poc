package g.gitops.poc.app.service;

import g.gitops.poc.app.service.impl.PoAppServiceImpl;
import g.gitops.poc.domain.document.service.DocumentDomService;
import g.gitops.poc.domain.milestone.service.MilestoneDomService;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.entity.PoItem;
import g.gitops.poc.domain.po.entity.SplittedPoItem;
import g.gitops.poc.domain.po.service.PoDomService;
import g.gitops.poc.infrastructure.common.email.EmailService;
import g.gitops.poc.infrastructure.common.event.JmsEventPublisher;
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

import static org.mockito.ArgumentMatchers.eq;

@RunWith(SpringRunner.class)
public class PoAppServiceTest {

    private Po po;
    private PoItem poItem;
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

    @MockBean
    private DocumentAppService documentAppService;

    @MockBean
    private JmsEventPublisher jmsEventPublisher;


    @Before
    public void setup() {
        po = new Po();
        po.setCreatedBy("tom");
        po.setId("001");

        poItem = new PoItem();
        poItem.setThePo(po);
        poItem.setId("POITEM001");

        Mockito.when(poDomService.createPo(po)).thenReturn(po);
        Mockito.when(poDomService.findPoItemById(poItem.getId())).thenReturn(poItem);
        Mockito.when(poDomService.findPoItemById("non-existed")).thenReturn(null);
    }

    @Test
    public void whenPoItemIdOK_thenSplitOK(){
        int quantity = 10;
        SplittedPoItem splittedPoItem = new SplittedPoItem();
        splittedPoItem.setQuantity(quantity);
        splittedPoItem.setThePoItem(poItem);
        Mockito.when(poDomService.splitPoItem(Mockito.any(PoItem.class),eq(quantity))).thenReturn(splittedPoItem);
        Assert.assertEquals(quantity,poAppService.splitPoItem(poItem.getId(),quantity).getQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void whenPoItemIdWrong_thenExceptionThrows(){
        poAppService.splitPoItem("non-existed",10);
    }

}
