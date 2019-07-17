package com.hrh.oauth2.server.config.service;

import com.hrh.oauth2.server.domain.TbPermission;
import com.hrh.oauth2.server.domain.TbUser;
import com.hrh.oauth2.server.service.TbPermissionService;
import com.hrh.oauth2.server.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.config.service
 * @ClassName: UserDetailServiceImpl
 * @Author: break
 * @Description:
 * @Date: 2019/7/17 0017 下午 19:27
 * @Version: 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TbUserService  tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {


        TbUser tbUser = tbUserService.getByUserName(userName);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

        if(tbUser != null ){
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
            tbPermissions.forEach(tbPermission -> {
                GrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorities.add(simpleGrantedAuthority);
            });
        }
        return new User(tbUser.getUsername(),tbUser.getPassword(),grantedAuthorities);
    }
}
