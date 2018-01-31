package hu.kuncystem.patient.webapp.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handle the user and usergroup process(request and response).
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 31.
 *  
 * @version 1.0
 */
@Controller
public class UserAndGroupController {
    
    @RequestMapping(value = "/usermanager", method = RequestMethod.GET)
    public String usermanager(){
        return "usermanager";
    }
    
    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
    public String account(){
        return "myaccount";
    }
}
