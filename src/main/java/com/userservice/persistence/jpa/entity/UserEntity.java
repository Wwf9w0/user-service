package com.userservice.persistence.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "user", indexes = {@Index(name = "IDX_USER_ID", columnList = "id")})
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private Long id;
    @Column
    private String password;
    @Column
    private Integer status;

    @Column
    private String userId;
    @Column
    private Integer failingCount;
    @Column
    private Date registerDate;
    @OneToOne(cascade = CascadeType.ALL)
    private UserPreferencesEntity userPreferences;
    @OneToOne(cascade = CascadeType.ALL)
    private UserProfileEntity userProfile;
    @OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
    private List<Token> tokens;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

}
