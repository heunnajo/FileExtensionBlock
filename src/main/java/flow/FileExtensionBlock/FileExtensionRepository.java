package flow.FileExtensionBlock;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FileExtensionRepository {

    @PersistenceContext
    private EntityManager em;
}
