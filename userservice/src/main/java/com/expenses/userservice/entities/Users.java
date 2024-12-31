package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class Users extends BaseEntity implements UserDetails{

    private String email;
    private String username;
    private String password;


    @OneToMany(mappedBy = "users")
    private Set<UserRoleMapping> userRoleMappings;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Profile userProfile;

    public Users(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public static class UserBuilder{

        private String email;
        private String username;
        private String password;

        public UserBuilder setEmail(final String email){
            this.email = email;
            return  this;
        }

        public UserBuilder setUserName(final String username){
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(final String password){
            this.password = password;
            return this;
        }

        public Users build(){
            return new Users(email, username, password);
        }
    }
}
