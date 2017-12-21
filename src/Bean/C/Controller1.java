package Bean.C;

import Bean.B.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller1 {

    @Autowired
    public UserBean userBean;
    @RequestMapping("/")
    @ResponseBody
    String home() {
//        this.userBean.setUsername("Hello");
//        this.userBean.setPassword("World");
        return this.userBean.getUsername()+this.userBean.getPassword();
    }
}
