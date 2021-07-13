package g.gitops.poc.app.service;

import g.gitops.poc.domain.document.entity.Document;

import java.util.List;

public interface DocumentAppService {
    String convertExcelToXml(Document document);
    Document uploadDocument(Document document);
    Document createPdf(String docType, Object obj);
    List<Document> createDocuments(String refId, String refType, List<String> fileNames);
}
