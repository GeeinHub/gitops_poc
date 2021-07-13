package g.gitops.poc.domain.po.service;

import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.repository.PoRepo;
import g.gitops.poc.domain.po.service.impl.PoDomServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoDomServiceTest {
    @Test
    void service() {
        PoDomServiceImpl service = new PoDomServiceImpl();
        PoRepo repo = Mockito.mock(PoRepo.class);
        List<Po> list = new ArrayList<>();
        Mockito.when(repo.findAll()).thenReturn(list);
        service.setPoRepo(repo);
        assertEquals(list, service.findAll());
    }


}
