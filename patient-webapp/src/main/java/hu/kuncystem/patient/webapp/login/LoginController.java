package hu.kuncystem.patient.webapp.login;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class control the process of login.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 16.
 * 
 * @version 1.0
 */
@Controller
public class LoginController {
    @Autowired
    private MessageSource messageSource;
    
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
            @RequestParam(value = "logout", required = false) String logout, ModelMap model,
            final Principal principal) {

        if (principal != null) {
            return "redirect:/";
        } else {
            String text;
            if (error != null) {
                text = messageSource.getMessage("message.bad_auth_data", null, LocaleContextHolder.getLocale());
                model.put("error", text);
            }

            if (logout != null) {
                text = messageSource.getMessage("message.login_success", null, LocaleContextHolder.getLocale());
                model.put("error", text);
            }

            return "login";
        }
    }
}
