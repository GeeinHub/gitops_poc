package g.gitops.poc.interfaces.api;

import g.gitops.poc.app.service.DocumentAppService;
import g.gitops.poc.app.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private StorageService storageService;

    private DocumentAppService documentAppService;

    @Autowired
    public void setStorageService(StorageService storageService){
        this.storageService = storageService;
    }

    @Autowired
    public void setDocumentAppService(DocumentAppService documentAppService){
        this.documentAppService = documentAppService;
    }

    @PostMapping(value="/doc",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadDoc(@RequestParam("refId") String refId,
                            @RequestParam(value = "refType") String refType,@RequestParam("data") MultipartFile... file){
        List<String> fileNames = storageService.store(file);
        documentAppService.createDocuments(refId,refType,fileNames);

        return "";
    }
}
