package hu.kuncystem.patient.dao.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.kuncystem.patient.dao.ConfigH2;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
//import static org.hamcrest.Matchers.is;

/**
 * this for comment of classes
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 12.
 *  
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigH2.class})
public class JDBCUserDaoTest {
	
	@Autowired
	UserDao userDao;
	
	private User user;
	
	@Before
	public void setup(){
		UserFactory userFactory = new UserFactory();
		
		user = userFactory.getUser(UserFactory.DOCTOR);
		user.setUserName("teszt");
		user.setPassword("abcd12345");
		user.setEmail("test@domain.com");
		user.setFullname("Teszt Elek");
	}
	
	@Test
	public void test(){
		
		assertThat(userDao, instanceOf(JDBCUserDao.class));
		
		//new user
		user = userDao.saveUser(user);
		assertNotNull(user);
		assertTrue("UserTest:58 > new user create failed", user.getId() > 0);
		long id = user.getId();

		//update user
		user.setEmail("test1@domain.com");
		assertTrue("UserTest:62 > user update failed", userDao.updateUser(user));
		
		//get user by id
		user = userDao.getUser(id);
		assertEquals("test1@domain.com", user.getEmail());
		
		//get user by name,password
		user = userDao.getUser("teszt", "abcd12345");
		assertEquals("test1@domain.com", user.getEmail());
		
		//delete user
		assertTrue(userDao.deleteUser(user));
	}
}
