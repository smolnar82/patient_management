package hu.kuncystem.patient.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.kuncystem.patient.dao.user.UserDao;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserFactory;

/**
 * this for comment of classes
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 10.
 *  
 * @version 1.0
 */
public class App {

	/**
	 * comment for method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		UserDao dao = ctx.getBean(UserDao.class);
		
		User u1 = UserFactory.getUser(UserFactory.PATIENT);
		u1.setUserName("teszt");
		u1.setPassword("abcd12345");
		u1.setEmail("teszt@domain.com");
		u1.setFullname("Teszt Elek");
		
		long newId = dao.saveUser(u1);
		System.out.println(newId + "");
		
		u1 = dao.getUser(newId);
		System.out.println(u1.getUserName() + " " + u1.getPassword() + " " + u1.getEmail() + " " + u1.getFullname() + " " + u1.isActive());
	}
}
