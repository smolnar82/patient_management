package hu.kuncystem.patient.webapp.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserGroup;
import hu.kuncystem.patient.servicelayer.user.UserGroupManager;
import hu.kuncystem.patient.servicelayer.user.UserManager;

/**
 * this for comment of classes
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 22.
 * 
 * @version 1.0
 */
@Service
public class LoginService implements UserDetailsService {    
    private UserManager userManager;

    private UserGroupManager userGroupManager;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Autowired
    public void setUserGroupManager(UserGroupManager userGroupManager) {
        this.userGroupManager = userGroupManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //get user by name
        User user = userManager.getUser(username);
        
        if(user == null){   //bad username
            throw new UsernameNotFoundException("username was not found in the database! (" + username + ")");
        }
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        
        //Get user group. These groups will define that the user can login or not.
        List<UserGroup> listGroup = userGroupManager.getGroupOfUser(user.getId());
        for(UserGroup group: listGroup){
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + group.getName().toUpperCase());
            grantList.add(authority);
        }
        
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantList);
        return userDetails;
    }
}
