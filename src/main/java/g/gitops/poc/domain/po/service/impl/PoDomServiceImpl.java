package g.gitops.poc.domain.po.service.impl;

import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.entity.PoItem;
import g.gitops.poc.domain.po.entity.SplittedPoItem;
import g.gitops.poc.domain.po.repository.PoItemRepo;
import g.gitops.poc.domain.po.repository.PoRepo;
import g.gitops.poc.domain.po.repository.SplittedPoItemRepo;
import g.gitops.poc.domain.po.service.PoDomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoDomServiceImpl implements PoDomService {
    PoRepo poRepo;
    PoItemRepo poItemRepo;
    SplittedPoItemRepo splittedPoItemRepo;

    @Autowired
    public void setPoRepo(PoRepo poRepo) {
        this.poRepo = poRepo;
    }

    @Autowired
    public void setPoItemRepo(PoItemRepo poItemRepo){
        this.poItemRepo = poItemRepo;
    }

    @Autowired
    public void setSplittedPoItemRepo(SplittedPoItemRepo splittedPoItemRepo){
        this.splittedPoItemRepo = splittedPoItemRepo;
    }

    @Override
    public Po createPo(Po po) {
      return  poRepo.save(po);
    }

    @Override
    public boolean splitPo() {
        return false;
    }

    @Override
    public PoItem findPoItemById(String poItemId){
        return poItemRepo.findPoItemById(poItemId);
    }

    @Override
    public List<Po> findAll() {
        return  poRepo.findAll();
    }

    @Override
    public Po findPoById(String id) {
        return poRepo.findPoById(id);
    }

    @Override
    public Po findPoByPoNum(String poNumber){
        return poRepo.findPoByPoNum(poNumber);
    }

    @Override
    public Po findPoByPoNumberAndCustomerCode(String poNumber, String customerCode){
        return poRepo.findPoByPoNumAndConsignee(poNumber, customerCode);
    }

    @Override
    public Po findPoByPoNumberAndCustomerCodeAndVendorCode(String poNumber, String customerCode, String vendorCode) {
        return poRepo.findPoByPoNumAndConsigneeAndPoVendor(poNumber, customerCode, vendorCode);
    }

    @Override
    public Po updatePo(Po po){
        return poRepo.save(po);
    }

    @Override
    public PoItem updatePoItem(PoItem poItem){
        return poItemRepo.save(poItem);
    }

    @Override
    public SplittedPoItem createSplittedPoItem(SplittedPoItem splittedPoItem){
        return splittedPoItemRepo.save(splittedPoItem);
    }
}
