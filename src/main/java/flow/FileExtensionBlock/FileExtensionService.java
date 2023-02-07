package flow.FileExtensionBlock;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class FileExtensionService {
    private final FileExtensionRepository fileExtensionRepository;

    public FileExtensionService(FileExtensionRepository fileExtensionRepository){
        this.fileExtensionRepository = fileExtensionRepository;
    }

    /* 확장자명 추가 */
    public Long insert(FileExtension fileExtension){
        validateDuplicateFileExtension(fileExtension);//중복 확장자명 검증
        fileExtensionRepository.save(fileExtension);
        return fileExtension.getId();
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
