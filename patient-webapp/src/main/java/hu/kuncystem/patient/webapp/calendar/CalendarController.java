package hu.kuncystem.patient.webapp.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handle the calendar process(request and response).
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 31.
 *  
 * @version 1.0
 */
@Controller
public class CalendarController {
    
    @RequestMapping(value = "/mycalendar", method = RequestMethod.GET)
    public String calendar(){
        return "mycalendar";
    }
}
