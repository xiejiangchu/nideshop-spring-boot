package com.xie.auth;

import com.xie.bean.Permissions;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @Author xie
 * @Date 17/1/19 下午5:06.
 */
@Component
public class MyPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getDetails();
        List<Permissions> permissionList = myUserDetails.getPermissionList();
        for (int i = 0; i < permissionList.size(); i++) {
            if (permissionList.get(i).getName().equals(permission.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getDetails();
        List<Permissions> permissionList = myUserDetails.getPermissionList();
        for (int i = 0; i < permissionList.size(); i++) {
            if (permissionList.get(i).getName().equals(permission.toString())) {
                return true;
            }
        }
        return false;
    }
}
