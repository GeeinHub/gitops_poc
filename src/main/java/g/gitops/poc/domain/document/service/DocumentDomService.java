package g.gitops.poc.domain.document.service;

import g.gitops.poc.domain.document.entity.Document;

import java.util.List;

public interface DocumentDomService {
    Document createDocument(Document document);
    String convertExcelToXml(Document document);
    Document uploadDocument(Document document);
    List<Document> createDocuments(List<Document> documents);
}
