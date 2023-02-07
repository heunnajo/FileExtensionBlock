package flow.FileExtensionBlock;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FileExtensionRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(FileExtension fe){
        em.persist(fe);
        return fe.getId();
    }

    public FileExtension find(Long id){
        return em.find(FileExtension.class,id);
    }
}
