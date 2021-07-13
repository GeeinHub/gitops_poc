package g.gitops.poc.app.service;

import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.entity.SplittedPoItem;

import java.util.List;

public interface PoAppService {
    Po uploadPo(Document doc);
    Po convertPoXmlToPo(String poXml);
    Po createPo(Po po);
    List<Po> findAll();
    void createPoNotification(Po po);
    Po searchPo(String poNumber);
    Po searchPo(String poNumber, String customerCode);
    Po searchPo(String poNumber, String customerCode, String vendorCode);
    Po updatePo(Po updatedPo);
    Document uploadPoSuppDocument(Document document);
    SplittedPoItem splitPoItem(String poItemId, int quantity);
}
