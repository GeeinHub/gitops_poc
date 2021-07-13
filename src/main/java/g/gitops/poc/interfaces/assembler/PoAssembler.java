package g.gitops.poc.interfaces.assembler;

import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.entity.PoItem;
import g.gitops.poc.interfaces.dto.PoDto;
import g.gitops.poc.interfaces.dto.PoItemDto;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoAssembler {
    public static Po toPoEntity(PoDto poDto) {
        Po po = new Po();
        BeanUtils.copyProperties(poDto, po);
        List<PoItemDto> poItemDtos = poDto.getPoItemDtos();
        if(poItemDtos !=null){
            List<PoItem> poItems = new ArrayList<>();
            for(PoItemDto poItemDto: poItemDtos){
                PoItem poItem = toPoItemEntity(poItemDto);
                poItem.setThePo(po);
                poItems.add(poItem);
            }
            po.setPoItems(poItems);
        }
        return po;
    }

    public static PoItem toPoItemEntity(PoItemDto poItemDto) {
        PoItem poItem = new PoItem();
        BeanUtils.copyProperties(poItemDto, poItem);
        return poItem;
    }

    public static PoDto toPoDto(Po po) {
        PoDto poDto = new PoDto();
        BeanUtils.copyProperties(po, poDto);
        List<PoItem> poItems = po.getPoItems();
        if(poItems !=null){
            List<PoItemDto> poItemDtos = poItems.stream().map(poItem -> toPoItemDto(poItem)).collect(Collectors.toList());
            poDto.setPoItemDtos(poItemDtos);
        }
        return poDto;
    }

    public static PoItemDto toPoItemDto(PoItem poItem) {
        PoItemDto poItemDto = new PoItemDto();
        BeanUtils.copyProperties(poItem, poItemDto);
        return poItemDto;
    }

    public static List<PoDto> toPoDtoList(List<Po> pos) {
        return pos.stream().map(po -> toPoDto(po)).collect(Collectors.toList());
    }
}
