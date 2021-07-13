package g.gitops.poc.domain.po.repository;

import g.gitops.poc.domain.po.entity.Po;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoRepo extends JpaRepository<Po, String> {
    Po findPoById(String id);
    Po findPoByPoNum(String poNum);
    Po findPoByPoNumAndConsignee(String poNumber, String customerCode);
    Po findPoByPoNumAndConsigneeAndPoVendor(String poNumber, String customerCode, String vendorCode);
}
