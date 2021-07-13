package g.gitops.poc.app.service.impl;

import g.gitops.poc.app.service.DocumentAppService;
import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.document.service.DocumentDomService;
import g.gitops.poc.infrastructure.common.ActiveMQConfig;
import g.gitops.poc.infrastructure.common.event.JmsEventPublisher;
import g.gitops.poc.interfaces.event.DocEventSchema;
import g.gitops.poc.interfaces.event.DocEventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentAppServiceImpl implements DocumentAppService {

    @Autowired
    private DocumentDomService documentDomService;

    @Autowired
    private JmsEventPublisher jmsEventPublisher;

    @Autowired
    @Qualifier(value = "topicDoc")
    private Destination topicDoc;



    @Override
    public String convertExcelToXml(Document document) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        return xml;
    }

    @Override
    public Document uploadDocument(Document document) {
        return documentDomService.createDocument(document);
    }

    public Document createPdf(String docType, Object obj){
        return null;
    }



    public List<Document> createDocuments(String refId,String refType,List<String> fileNames){
        List<Document> documents = fileNames.stream().map(fileName -> {
            Document document = new Document();
            document.setReferenceId(refId);
            document.setReferenceType(refType);
            document.setDocumentId(fileName);
            return document;
        }).collect(Collectors.toList());
        documents = documentDomService.createDocuments(documents);
        Map<String,Object> msg = new HashMap<>();
        msg.put(DocEventSchema.REF_ID,refId);
        msg.put(DocEventSchema.REF_TYPE,refType);
        msg.put(DocEventSchema.DOCS,fileNames); //to decouple, cannot send whole Document object here

        jmsEventPublisher.publish(msg, DocEventType.CREATE_DOC.name(), ActiveMQConfig.TOPIC_DOC);
        return documents;
    }
}
