package example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by h on 2018/4/16.
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index(){
        return "welcome";
    }

}
