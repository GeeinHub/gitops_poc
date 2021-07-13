package g.gitops.poc.interfaces.api;

import g.gitops.poc.app.service.DocumentAppService;
import g.gitops.poc.app.service.SoAppService;
import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.so.entity.So;
import g.gitops.poc.infrastructure.common.handler.LogExecutionTime;
import g.gitops.poc.interfaces.assembler.DocumentAssember;
import g.gitops.poc.interfaces.assembler.SoAssembler;
import g.gitops.poc.interfaces.dto.DocumentDto;
import g.gitops.poc.interfaces.dto.SoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("vendor/so")
public class VendorSoController {
    @Autowired
    SoAppService soAppService;

    @Autowired
    DocumentAppService documentAppService;


    /**
     * Create a So
     *
     * @return
     */
    @Operation(summary = "Vendor creates a SO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create SO",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SoDto.class))}),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value = "v1/create")
    @LogExecutionTime
    public ResponseEntity<SoDto> createSo(@RequestBody SoDto soDto) {
        So so = soAppService.createSo(soDto);
        return ResponseEntity.status(HttpStatus.OK).body(SoAssembler.toSoDto(so));
    }

    /**
     * Submit a So
     *
     * @return
     */
    @Operation(summary = "Vendor submits a SO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Submit SO",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SoDto.class))}),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value = "v1/submit")
    @LogExecutionTime
    public ResponseEntity<SoDto> submit(@RequestBody SoDto soDto) {
        So so = soAppService.submitDraftSo(SoAssembler.toSoEntity(soDto));
        return ResponseEntity.status(HttpStatus.OK).body(SoAssembler.toSoDto(so));
    }


    @GetMapping(value = "v1/list")
    @LogExecutionTime
    public ResponseEntity<List<SoDto>> listSos(){
        List<So> sos = soAppService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(SoAssembler.toSoDtoList(sos));
    }

    @Operation(summary = "Vendor uploads a SO supplement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Upload SO supporting document",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DocumentDto.class))}),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/uploadSoSuppDoc", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity uploadSoSuppDoc(@RequestBody DocumentDto dto){
        Document document = documentAppService.uploadDocument(DocumentAssember.toDocumentEntity(dto));
        return ResponseEntity.status(HttpStatus.OK).body(DocumentAssember.toDocumentDto(document));
    }
}
