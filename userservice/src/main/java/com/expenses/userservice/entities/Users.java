package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
public class Users extends  BaseEntity{

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
