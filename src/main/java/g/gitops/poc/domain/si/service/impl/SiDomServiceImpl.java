package g.gitops.poc.domain.si.service.impl;

import g.gitops.poc.domain.si.entity.Si;
import g.gitops.poc.domain.si.repository.SiRepo;
import g.gitops.poc.domain.si.service.SiDomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiDomServiceImpl implements SiDomService {

    @Autowired
    SiRepo siRepo;

    @Override
    public Si createSi(Si si) {
        return siRepo.save(si);
    }
}
