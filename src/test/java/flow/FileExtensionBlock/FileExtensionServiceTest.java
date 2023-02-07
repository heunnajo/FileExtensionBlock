package flow.FileExtensionBlock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileExtensionServiceTest {
    FileExtensionService fileExtensionService;
    FileExtensionRepository fileExtensionRepository;

    @BeforeEach
    public void beforeEach(){
        fileExtensionRepository = new FileExtensionRepository();
        fileExtensionService = new FileExtensionService(fileExtensionRepository);
    }

//    @AfterEach
//    public void afterEach(){
//        fileExtensionRepository.clearStore();
//    }
    @Test
    public void 중복_확장잠명_예외() throws Exception {
        //Given
        FileExtension fe1 = new FileExtension();
        fe1.setExtensionName("abc");

        FileExtension fe2 = new FileExtension();
        fe2.setExtensionName("abc");

        //When
        fileExtensionService.insert(fe1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> fileExtensionService.insert(fe2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 확장자입니다.");
    }
}