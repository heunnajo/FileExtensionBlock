package flow.FileExtensionBlock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileExtensionRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(FileExtension fileExtension){
        if(fileExtension.getId() == null){
            em.persist(fileExtension);
        } else{
            em.merge(fileExtension);
        }
    }

    public FileExtension findOne(Long id){
        return em.find(FileExtension.class,id);
    }

    public Optional<FileExtension> findById(Long id) {
        FileExtension fe = em.find(FileExtension.class, id);
        return Optional.ofNullable(fe);
    }

    public List<FileExtension> findAll(){
        return em.createQuery("select m from FileExtension m", FileExtension.class).getResultList();
    }

    public Optional<FileExtension> findByName(String extensionName) {
        List<FileExtension> result = em.createQuery("select m from FileExtension m where m.extensionName = :extensionName", FileExtension.class)
                .setParameter("extensionName", extensionName)
                .getResultList();
        return result.stream().findAny();
    }
//    public List<FileExtension> findByName(String name) {//ifPresent에서 타입별 특징으로 인한 에러.
//        return em.createQuery("select m from FileExtension m where m.name = :name", FileExtension.class)
//                .setParameter("name", name)
//                .getResultList();
//    }

    public void clearAll(){
        em.clear();
    }
}
