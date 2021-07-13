package g.gitops.poc.interfaces;

import g.gitops.poc.app.service.PoAppService;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.interfaces.api.CustomerPoController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerPoController.class)
public class CustomerPoControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    PoAppService poAppService;


    @Test
    public void givenPos_whenGetPos_thenStatus200() throws Exception {
        mvc.perform(get("/customer/po/v1/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("001"));
    }

    @Before
    public void setup() {
        List<Po> dummyPos = new ArrayList<>();
        Po po = new Po();
        po.setCreatedBy("tom");
        po.setId("001");
        dummyPos.add(po);

        po = new Po();
        po.setCreatedBy("jerry");
        po.setId("002");
        dummyPos.add(po);

        Mockito.when(poAppService.findAll()).thenReturn(dummyPos);

    }
}
