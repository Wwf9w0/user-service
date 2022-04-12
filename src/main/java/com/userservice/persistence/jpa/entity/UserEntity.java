package com.userservice.persistence.jpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user", indexes = {@Index(name = "IDX_USER_ID", columnList = "id")})
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long extarnalNo;

    @Column
    private String password;

    @Column
    private String userName;

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

   /* @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntiy> roles = new HashSet<>();*/
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

}
