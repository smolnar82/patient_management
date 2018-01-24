package hu.kuncystem.patient.webapp.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * this for comment of classes
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 16.
 * 
 * @version 1.0
 */
@Controller
public class LoginController {
    private final static Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/403")
    public String accesssDenied() {
        return "403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, ModelMap model) {

        logger.info("this is logger test");
        if (error != null) {
            model.put("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.put("error", "You've been logged out successfully.");
        }
        //model.setViewName("login");

        return "login";
    }
}
