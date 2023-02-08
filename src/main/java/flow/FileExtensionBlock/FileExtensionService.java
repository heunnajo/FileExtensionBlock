package flow.FileExtensionBlock;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FileExtensionService {
    //생성자 주입:생성자가 하나이면 @Autowired 생략가능.
    private final FileExtensionRepository fileExtensionRepository;

//    public FileExtensionService(FileExtensionRepository fileExtensionRepository) {
//        this.fileExtensionRepository = fileExtensionRepository;
//    }

    /* 확장자명 추가 */
    @Transactional
    public Long insert(FileExtension fileExtension){
        validateDuplicateFileExtension(fileExtension);//중복 확장자명 검증
        fileExtensionRepository.save(fileExtension);
        return fileExtension.getId();
    }

    @Transactional
    public void delete(Long fileExtenstionId){
        FileExtension fileExtension = fileExtensionRepository.findOne(fileExtenstionId);
        fileExtension.removeFixed(fileExtension.getExtensionName());
        fileExtension.removeCustomed(fileExtension.getExtensionName());
    }

    private void validateDuplicateFileExtension(FileExtension fileExtension) {
        fileExtensionRepository.findByName(fileExtension.getExtensionName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 확장자명입니다.");
                });
    }
    /* 전체 확장자명 조회 */
    public List<FileExtension> findFileExtensions() {
        return fileExtensionRepository.findAll();
    }
    public Optional<FileExtension> findOne(Long memberId) {
        return fileExtensionRepository.findById(memberId);
    }
}
