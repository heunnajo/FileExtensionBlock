package flow.FileExtensionBlock;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class FileExtension {

    @Id @GeneratedValue
    private Long id;
    private String extensionName;
    private boolean isFixed;

    private List<String> fixedList = new ArrayList<>();
    private List<String> customedList = new ArrayList<>();

    /* 비즈니스 로직 */
    public void addFixed(String extensionName){
        fixedList.add(extensionName);
    }
    public void removeFixed(String extensionName){
        fixedList.remove(extensionName);
    }
    public void addCustomed(String extensionName){
        customedList.add(extensionName);
    }
    public void removeCustomed(String extensionName){
        customedList.remove(extensionName);
    }
}
