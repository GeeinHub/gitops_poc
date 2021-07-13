package g.gitops.poc.interfaces.api;

import g.gitops.poc.app.service.PoAppService;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.infrastructure.common.handler.LogExecutionTime;
import g.gitops.poc.interfaces.assembler.PoAssembler;
import g.gitops.poc.interfaces.dto.PoSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("vendor/po")
public class VendorPoController {

    @Autowired
    PoAppService poAppService;

    @Operation(summary = "Vendor searches a PO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search a PO successfully",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = PoSearchDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/searchPo", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity searchPo(@RequestBody PoSearchDto dto){
        Po po = poAppService.searchPo(dto.getPoNumber(), dto.getCustomerCode(), dto.getVendorCode());
        return ResponseEntity.status(HttpStatus.OK).body(PoAssembler.toPoDto(po));
    }
}
