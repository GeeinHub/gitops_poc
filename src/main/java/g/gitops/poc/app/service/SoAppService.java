package g.gitops.poc.app.service;

import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.si.entity.Si;
import g.gitops.poc.domain.so.entity.So;
import g.gitops.poc.interfaces.dto.SoDto;

import java.util.List;

public interface SoAppService {
    So createSo(SoDto soDto);

    List<So> findAll();

    So submitDraftSo(So so);

    void sendSoEdi(So so);

    So updateSoStatus(So so, String status);

    void notifyCsv(So so);

    Document uploadSoSuppDocument(String id, Document document);

    So searchSo(String id);

    Document createSiDocument(So so);

    Si generateSi(So so);

    So submitSo(So so);

}
