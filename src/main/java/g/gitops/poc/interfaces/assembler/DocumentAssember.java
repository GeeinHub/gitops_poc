package g.gitops.poc.interfaces.assembler;

import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.interfaces.dto.DocumentDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentAssember {
    public static Document toDocumentEntity(DocumentDto docDto) {
        Document doc = new Document();
        BeanUtils.copyProperties(docDto, doc);
        return doc;
    }

    public static DocumentDto toDocumentDto(Document doc) {
        DocumentDto dto = new DocumentDto();
        BeanUtils.copyProperties(doc, dto);
        return dto;
    }

    public static List<DocumentDto> toDocumentDtoList(List<Document> docs) {
        return docs.stream().map(doc -> toDocumentDto(doc)).collect(Collectors.toList());
    }
}
