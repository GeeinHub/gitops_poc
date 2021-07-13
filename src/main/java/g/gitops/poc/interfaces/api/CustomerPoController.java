package g.gitops.poc.interfaces.api;

import g.gitops.poc.app.service.DocumentAppService;
import g.gitops.poc.app.service.PoAppService;
import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.infrastructure.common.handler.LogExecutionTime;
import g.gitops.poc.interfaces.assembler.DocumentAssember;
import g.gitops.poc.interfaces.assembler.PoAssembler;
import g.gitops.poc.interfaces.dto.DocumentDto;
import g.gitops.poc.interfaces.dto.PoDto;
import g.gitops.poc.interfaces.dto.PoSearchDto;
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
@RequestMapping("customer/po")
public class CustomerPoController {

    @Autowired
    PoAppService poAppService;

    @Autowired
    DocumentAppService documentAppService;

    @Operation(summary = "Customer uploads a PO document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a PO successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = PoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/uploadPo", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity uploadPo(@RequestBody DocumentDto dto){
        Document doc = DocumentAssember.toDocumentEntity(dto);
        Po po = poAppService.uploadPo(doc);
        return ResponseEntity.status(HttpStatus.OK).body(PoAssembler.toPoDto(po));
    }

    @Operation(summary = "Customer creates a PO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a PO successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = PoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/create", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity createPo(@RequestBody PoDto dto){
        Po po = PoAssembler.toPoEntity(dto);
        po = poAppService.createPo(po);
        return ResponseEntity.status(HttpStatus.OK).body(PoAssembler.toPoDto(po));
    }

    @Operation(summary = "Customer updates a PO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updates a PO successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = PoSearchDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/update", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity updatePo(@RequestBody PoDto dto){
        Po po = poAppService.updatePo(PoAssembler.toPoEntity(dto));
        return ResponseEntity.status(HttpStatus.OK).body(PoAssembler.toPoDto(po));
    }

    @Operation(summary = "Test api to create a new PO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a PO successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = PoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @GetMapping(value = "v1/new")
    @LogExecutionTime
    public ResponseEntity<PoDto> newPo(){
        PoDto dto = new PoDto();
        Po po = PoAssembler.toPoEntity(dto);
        poAppService.createPo(po);
        return ResponseEntity.status(HttpStatus.OK).body(PoAssembler.toPoDto(po));
    }

    /**
     * test usage
     * @return
     */
    @Operation(summary = "Test api to list  PO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List Po",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = PoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @GetMapping(value = "v1/list")
    @LogExecutionTime
    public ResponseEntity<List<PoDto>> listPos(){
       List<Po> pos = poAppService.findAll();
       return ResponseEntity.status(HttpStatus.OK).body(PoAssembler.toPoDtoList(pos));
    }

    @Operation(summary = "Customer uploads a PO supporting document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Upload a PO supporting document successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = DocumentDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/uploadPoSuppDoc", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity uploadPoSuppDoc(@RequestBody DocumentDto dto){
        Document document = documentAppService.uploadDocument(DocumentAssember.toDocumentEntity(dto));
        return ResponseEntity.status(HttpStatus.OK).body(DocumentAssember.toDocumentDto(document));
    }

    @Operation(summary = "Customer searches a PO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search a PO successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = PoSearchDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/searchPo", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity searchPo(@RequestBody PoSearchDto dto){
        Po po = poAppService.searchPo(dto.getPoNumber());
        return ResponseEntity.status(HttpStatus.OK).body(PoAssembler.toPoDto(po));
    }
}
