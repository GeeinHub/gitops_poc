package g.gitops.poc.domain.po.service;

import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.entity.PoItem;
import g.gitops.poc.domain.po.entity.SplittedPoItem;

import java.util.List;

/**
 * Po domain service {@link PoDomService}.
 *
 * @author Jackie Dong
 */
public interface PoDomService {
    /**
     * Saves a Po.
     *
     * @param po
     * @return the saved po
     */
    Po createPo(Po po);

    /**
     *Split a Po
     * @return boolean
     */
    boolean splitPo();

    PoItem findPoItemById(String poItemId);

    /**
     *Find all Pos
     * @return List of Po Entity
     */
    List<Po> findAll();

    Po findPoById(String id);

    Po findPoByPoNum(String poNumber);

    Po findPoByPoNumberAndCustomerCode(String poNumber, String customerCode);

    Po findPoByPoNumberAndCustomerCodeAndVendorCode(String poNumber, String customerCode, String vendorCode);

    Po updatePo(Po po);

    PoItem updatePoItem(PoItem poItem);

    SplittedPoItem createSplittedPoItem(SplittedPoItem splittedPoItem);
}
