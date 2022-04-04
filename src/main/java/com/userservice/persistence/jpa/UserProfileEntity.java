package com.userservice.persistence.jpa;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "user_profile")
@RequiredArgsConstructor
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String nickname;

    private String email;

    private Date birthDate;

    private Integer gender;

    private String profilePhoto;

    private Boolean isUserNameConfirmed;

    private Date createdDate;

    private Date lastModifiedDate;
}
