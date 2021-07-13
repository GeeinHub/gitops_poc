package g.gitops.poc.interfaces.assembler;

import g.gitops.poc.domain.si.entity.Si;
import g.gitops.poc.domain.so.entity.So;
import org.springframework.beans.BeanUtils;

public class SiAssember {
    public static Si convertSoToSi(So so){
        Si si = new Si();
        BeanUtils.copyProperties(so, si);
        return si;
    }
}
