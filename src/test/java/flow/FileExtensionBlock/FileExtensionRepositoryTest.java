package flow.FileExtensionBlock;

import org.assertj.core.api.Assertions;
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
    public void testFE() throws Exception{
        //given
        FileExtension fe = new FileExtension();
        fe.setExtensionName("fe1");
        
        //when
        //Long savedId = fileExtensionRepository.save(fe);
        //FileExtension foundFileExtension = fileExtensionRepository.findOne(savedId);

        //then
        //Assertions.assertThat(foundFileExtension.getId()).isEqualTo(fe.getId());

//        Assertions.assertThat(foundFileExtension.getExtensionName()).isEqualTo(fe.getExtensionName());
//        Assertions.assertThat(foundFileExtension).isEqualTo(fe); //JPA 엔티티 동일성 보장
    }

    

}