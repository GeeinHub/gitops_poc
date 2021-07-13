package g.gitops.poc.domain.so.service.impl;

import g.gitops.poc.domain.so.entity.So;
import g.gitops.poc.domain.so.repository.SoRepo;
import g.gitops.poc.domain.so.service.SoDomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoDomServiceImpl implements SoDomService {

    @Autowired
    SoRepo soRepo;

    @Override
    public So createSo(So so) {
        return soRepo.save(so);
    }

    @Override
    public List<So> findAll() {
        return soRepo.findAll();
    }

    @Override
    public So updateSo(So so) {
        return soRepo.save(so);
    }

    @Override
    public So findSoById(String id){
        return soRepo.findSoById(id);
    }
}
