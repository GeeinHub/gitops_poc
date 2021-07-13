package g.gitops.poc.interfaces.assembler;

import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.interfaces.dto.MilestoneDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MilestoneAssembler {
    public static MilestoneDto toDto(Milestone milestone){
        MilestoneDto dto = new MilestoneDto();
        BeanUtils.copyProperties(milestone, dto);
        return dto;
    }

    public static List<MilestoneDto> toDtos(List<Milestone> milestones){
        return milestones.stream().map(m -> toDto(m)).collect(Collectors.toList());
    }
}
