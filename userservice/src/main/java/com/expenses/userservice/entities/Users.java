package com.expenses.userservice.entities;

import com.expenses.userservice.util.ApplicationConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Column(name = "account_expired")
    private boolean accountNonExpired ;

    @Column(name = "account_locked ")
    private boolean accountNonLocked;

    @Column(name = "credentials_expired")
    private boolean credentialsNonExpired;

    @Column(name = "account_enabled")
    private boolean enabled;

    //flags
//    @Column(name = "account_expired")
//    private char accountExpired;
//    @Column(name = "account_locked ")
//    private char accountLocked;
//    @Column(name = "credentials_expired")
//    private char credentialsExpired;
//    @Column(name = "account_enabled")
//    private char accountEnabled;


    @OneToMany(mappedBy = "users")
    private Set<UserRoleMapping> userRoleMappings;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Profile userProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserTokens> tokens;

    public Users(String email, String username, String password, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled){
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public static class UserBuilder{

        private String email;
        private String username;
        private String password;
        private boolean accountNonExpired ;
        private boolean accountNonLocked;
        private boolean credentialsNonExpired;
        private boolean enabled;

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

        public UserBuilder setAccountExpired(final boolean accountNonExpired){
            this.accountNonExpired = accountNonExpired;
            return this;
        }

        public UserBuilder setAccountNonLocked(final boolean accountNonLocked){
            this.accountNonLocked = accountNonLocked;

            return this;
        }

        public UserBuilder setCredentialsNonExpired(final boolean credentialsNonExpired){
            this.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public UserBuilder setEnable(final boolean enabled){
            this.enabled = enabled;
            return this;
        }

        public Users build(){
            return new Users(email, username, password,
                    accountNonExpired,accountNonLocked,
                    credentialsNonExpired,enabled);
        }

    }


}
