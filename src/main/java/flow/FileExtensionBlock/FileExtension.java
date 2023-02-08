package flow.FileExtensionBlock;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class FileExtension {

    @Id @GeneratedValue
    private Long id;
    private String extensionName;
    private boolean isFixed;

//    @OrderColumn(name = "fixed_idx")
//    @Column(name = "fixed")
//    private List<String> fixedList = new ArrayList<>();
//
//    @OrderColumn(name = "customed_idx")
//    @Column(name = "customed")
//    private List<String> customedList = new ArrayList<>();
//
//    /* 비즈니스 로직 */
//    public void addFixed(String extensionName){
//        fixedList.add(extensionName);
//    }
//    public void removeFixed(String extensionName){
//        fixedList.remove(extensionName);
//    }
//    public void addCustomed(String extensionName){
//        customedList.add(extensionName);
//    }
//    public void removeCustomed(String extensionName){
//        customedList.remove(extensionName);
//    }
}
