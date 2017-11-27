package hu.kuncystem.patient.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.kuncystem.patient.dao.user.UserDao;
import hu.kuncystem.patient.dao.user.UserGroupDao;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserFactory;
import hu.kuncystem.patient.pojo.user.UserGroup;

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
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigH2.class);
		
		UserFactory factory = new UserFactory();
		
		User user = factory.getUser(UserFactory.DOCTOR);
		
		if(factory.isDoctor(user)){
			System.out.println("doctor vagyok");
		}
	}
}
