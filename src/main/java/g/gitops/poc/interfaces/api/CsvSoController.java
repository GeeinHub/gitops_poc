package g.gitops.poc.interfaces.api;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("csv/so")
public class CsvSoController {

    @Autowired
    SoAppService soAppService;

    /**
     * Submit a So
     *
     * @return
     */
    @Operation(summary = "CSV submits a SO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Submit SO",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SoDto.class))}),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @GetMapping(value = "v1/submit")
    @LogExecutionTime
    public ResponseEntity<SoDto> submit(@RequestBody SoDto soDto) {
        So so = soAppService.submitSo(SoAssembler.toSoEntity(soDto));
        return ResponseEntity.status(HttpStatus.OK).body(SoAssembler.toSoDto(so));
    }

    /**
     * Create SI document
     *
     * @return
     */
    @Operation(summary = "CSV creates a SI document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create SI document",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SoDto.class))}),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @GetMapping(value = "v1/createSiDocument")
    @LogExecutionTime
    public ResponseEntity<DocumentDto> createSiDocument(@RequestBody SoDto soDto) {
        Document siDoc= soAppService.createSiDocument(SoAssembler.toSoEntity(soDto));
        return ResponseEntity.status(HttpStatus.OK).body(DocumentAssember.toDocumentDto(siDoc));
    }
}
