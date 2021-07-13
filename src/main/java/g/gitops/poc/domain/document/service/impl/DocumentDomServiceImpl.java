package g.gitops.poc.domain.document.service.impl;

import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.document.repository.DocumentRepo;
import g.gitops.poc.domain.document.service.DocumentDomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentDomServiceImpl implements DocumentDomService {

    @Autowired
    DocumentRepo documentRepo;

    @Override
    public Document createDocument(Document document) {
        return documentRepo.save(document);
    }

    @Override
    public List<Document> createDocuments(List<Document> documents) {
        return documentRepo.saveAll(documents);
    }

    @Override
    public String convertExcelToXml(Document document) {
        return null;
    }

    @Override
    public Document uploadDocument(Document document) {
        return null;
    }
}
