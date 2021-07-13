package g.gitops.poc.interfaces.api;

import g.gitops.poc.app.service.MilestoneAppService;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.infrastructure.common.handler.LogExecutionTime;
import g.gitops.poc.interfaces.assembler.MilestoneAssembler;
import g.gitops.poc.interfaces.dto.MilestoneSearchDto;
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

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("milestone")
public class MilestoneController {

    @Autowired
    private MilestoneAppService milestoneAppService;

    @Operation(summary = "Fetch Milestones according to refType and refId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search Milestones with proper criteria",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = MilestoneSearchDto.class)) }),
            @ApiResponse(responseCode = "500", description = "internal error",
                    content = @Content)})
    @PostMapping(value="v1/search", consumes = APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity searchMilestone(@RequestBody MilestoneSearchDto criteria){
        List<Milestone> milestones = milestoneAppService.searchMilestone(criteria.getRefId(),criteria.getRefType());

        return ResponseEntity.status(HttpStatus.OK).body(MilestoneAssembler.toDtos(milestones));
    }
}
