package flow.FileExtensionBlock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class FileExtensionServiceTest {

    @Autowired FileExtensionService fileExtensionService;
    @Autowired FileExtensionRepository fileExtensionRepository;

//    @BeforeEach
//    public void beforeEach(){
//        fileExtensionRepository = new FileExtensionRepository();
//        fileExtensionService = new FileExtensionService(fileExtensionRepository);
//    }

//    @AfterEach
//    public void afterEach(){
//        fileExtensionRepository.clearAll();
//    }
    @Test
    public void 확장자명_저장() throws Exception{
        //Given
        FileExtension f1 = new FileExtension();
        f1.setExtensionName("hello");

        //When
        Long saveId = fileExtensionService.insert(f1);

        //Then
//        FileExtension foundFE = fileExtensionRepository.findById(saveId).get();
//        assertEquals(f1.getExtensionName(),foundFE.getExtensionName());
        assertEquals(f1,fileExtensionRepository.findOne(saveId));
    }

    @Test
    public void 중복_확장자명_예외() throws Exception {
        //Given
        FileExtension fe1 = new FileExtension();
        fe1.setExtensionName("abc");

        FileExtension fe2 = new FileExtension();
        fe2.setExtensionName("abc");

        //When
        fileExtensionService.insert(fe1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> fileExtensionService.insert(fe2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 확장자명입니다.");
    }

    @Test
    public void 확장자명_취소() throws Exception{
        //Given
        FileExtension fe1 = new FileExtension();

        //When
        fileExtensionService.delete(fe1.getId());

        //Then : 취소 확인
        String name = fe1.getExtensionName();
        if(!fe1.getFixedList().contains(name) && !fe1.getCustomedList().contains(name)){
            System.out.println("삭제되었습니다!");
        } else{//오류가 발생한 것임!
            System.out.println("이 확장자는 삭제되어아하는데 삭제되지 않았습니다!");
        }
    }
}