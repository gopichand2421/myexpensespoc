package com.expenses.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profile")
@Data
@NoArgsConstructor
public class Profile extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;


    public Profile(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    public  static ProfileBuilder builder(){
        return new ProfileBuilder();
    }

    public static class ProfileBuilder {

        private String firstName;
        private String lastName;
        private String phoneNumber;

        public ProfileBuilder setFirstName(final String firstName){
            this.firstName = firstName;
            return this;
        }

        public ProfileBuilder setLastName(final String lastName){
            this.lastName = lastName;
            return this;
        }

        public ProfileBuilder setPhoneNumber(final String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Profile build(){
            return new Profile(firstName, lastName,phoneNumber);
        }
    }
}
