package flow.FileExtensionBlock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileExtensionRepositoryTest {
    @Autowired FileExtensionRepository fileExtensionRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testFBE() throws Exception{
        //given
        FileExtension fe = new FileExtension();
        fe.setExtensionName("fe1");
        
        //when
        Long savedId = fileExtensionRepository.save(fe);
        FileExtension foundFileExtension = fileExtensionRepository.find(savedId);

        //then
    }

    

}