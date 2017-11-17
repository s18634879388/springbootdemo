package com.demo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Administrator on 2016/11/24.
 */
public class JWTUser implements UserDetails{
    private int userId;
    private String userName;
    private String passWord;
    private final Collection<? extends GrantedAuthority> authorities;

    public JWTUser(Collection<? extends GrantedAuthority> authorities){
        this.authorities = authorities;
    }
    public JWTUser(String userName, String passWord, int userId, Collection<? extends GrantedAuthority> authorities){
        this.userId = userId;
        this.passWord = passWord;
        this.userName = userName;
        this.authorities = authorities;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }
    //账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //密码是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //账户是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
