package g.gitops.poc.interfaces.assembler;

import g.gitops.poc.domain.so.entity.So;
import g.gitops.poc.domain.so.entity.SoItem;
import g.gitops.poc.interfaces.dto.SoDto;
import g.gitops.poc.interfaces.dto.SoItemDto;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SoAssembler {
    public static So toSoEntity(SoDto soDto) {
        So so = new So();
        BeanUtils.copyProperties(soDto, so);
        List<SoItemDto> soItemDtos = soDto.getItemDtos();
        if(soItemDtos != null){
            List<SoItem> soItems = new ArrayList<>();
            for(SoItemDto soItemDto: soItemDtos){
                SoItem soItem = toSoItemEntity(soItemDto);
                soItem.setTheSo(so);
                soItems.add(soItem);
            }
            so.setSoItems(soItems);
        }
        return so;
    }

    public static SoItem toSoItemEntity(SoItemDto soItemDto) {
        SoItem soItem = new SoItem();
        BeanUtils.copyProperties(soItemDto, soItem);
        return soItem;
    }

    public static SoDto toSoDto(So so) {
        SoDto soDto = new SoDto();
        BeanUtils.copyProperties(so, soDto);
        List<SoItem> soItems = so.getSoItems();
        if(soItems != null){
            List<SoItemDto> soItemDtos = soItems.stream().map(soItem -> toSoItemDto(soItem)).collect(Collectors.toList());
            soDto.setItemDtos(soItemDtos);
        }
        return soDto;
    }

    public static SoItemDto toSoItemDto(SoItem soItem) {
        SoItemDto soItemDto = new SoItemDto();
        BeanUtils.copyProperties(soItem, soItemDto);
        return soItemDto;
    }

    public static List<SoDto> toSoDtoList(List<So> sos) {
        return sos.stream().map(so -> toSoDto(so)).collect(Collectors.toList());
    }

}
