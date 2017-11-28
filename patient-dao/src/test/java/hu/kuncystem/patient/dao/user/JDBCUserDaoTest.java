package hu.kuncystem.patient.dao.user;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.kuncystem.patient.dao.ConfigH2;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserFactory;
import hu.kuncystem.patient.pojo.user.UserGroup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

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
	@Qualifier(value = "JDBCUserDao")
	private UserDao userDao;
	
	@Autowired
	@Qualifier(value = "JDBCUserGroupDao")
	private UserGroupDao userGroupDao;
	
	private User user;
	
	private UserGroup group;
	
	@Before
	public void setup(){
		UserFactory userFactory = new UserFactory();
		
		if(user == null){
			user = userFactory.getUser(UserFactory.DOCTOR);
			user.setUserName("teszt");
			user.setPassword("abcd12345");
			user.setEmail("test@domain.com");
			user.setFullname("Teszt Elek");
		}
		
		if(group == null){
			group = new UserGroup("Admin");
			group.setNote("admin group");
		}
	}
	
	/**
	 * Create new user in the database
	 * */
	private void createNewUser(){
		user = userDao.saveUser(user);
		assertNotNull(user);
		assertTrue("createNewUser:58 > new user create failed", user.getId() > 0);
	}
	
	@Test
	public void testUser(){
		
		assertThat(userDao, instanceOf(JDBCUserDao.class));
		
		//new user
		createNewUser();
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
	
	@Test
	public void testUserGroup(){
		assertThat(userGroupDao, instanceOf(JDBCUserGroupDao.class));
		
		//add new user into database
		createNewUser();
		
		//new group
		group = userGroupDao.saveUserGroup(group);
		assertNotNull(group);
		assertTrue("testUserGroup:94 > new user group create failed", group.getId() > 0);
		long id = group.getId();
		
		//get group by id 
		group = userGroupDao.getUserGroup(id);
		assertEquals("Admin", group.getName());
		
		//new group relation
		assertTrue(userGroupDao.saveUserGroupRelation(group, user));
		
		//user list from group
		List<User> userLIst = userGroupDao.getAllUserFromGroup(group);
		assertTrue("testUserGroup:121 > test user list from group", userLIst.size() > 0);
		
		//user group list by user
		List<UserGroup> groupList = userGroupDao.getAllUserGroupByUser(user);
		assertTrue("testUserGroup:125 > test group list by user", groupList.size() > 0);
		
	}
}
