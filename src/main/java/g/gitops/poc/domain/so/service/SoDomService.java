package g.gitops.poc.domain.so.service;

import g.gitops.poc.domain.so.entity.So;

import java.util.List;

public interface SoDomService {

    /**
     * Saves a So.
     *
     * @param so
     * @return the saved so
     */
    So createSo(So so);

    List<So> findAll();

    So updateSo(So so);

    So findSoById(String id);
}
