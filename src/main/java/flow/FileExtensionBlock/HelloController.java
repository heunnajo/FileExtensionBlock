package flow.FileExtensionBlock;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","I am Heunna Jo!!!");
        return "hello";//the name of view.
    }
}
