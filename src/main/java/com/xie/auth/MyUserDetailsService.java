package com.xie.auth;

import com.xie.bean.Permissions;
import com.xie.bean.Roles;
import com.xie.bean.User;
import com.xie.service.PermissionService;
import com.xie.service.RoleService;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xie
 * @Date 17/1/19 下午5:07.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    private ConcurrentHashMap<String, UserDetails> users = new ConcurrentHashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (users.containsKey(username)) {
            return users.get(username);
        }
        User user = userService.getByOpenId(username);
        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Roles> roles = roleService.getRolesByUid(user.getId());
        List<Permissions> permissions = permissionService.getByUid(user.getId());
        UserDetails userDetails = new MyUserDetails(user, roles, permissions);
        users.put(username, userDetails);
        return userDetails;
    }
}
