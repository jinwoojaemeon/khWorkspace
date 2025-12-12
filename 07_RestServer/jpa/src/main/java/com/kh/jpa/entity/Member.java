package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "MEMBER")
@Check(constraints = "gender IN ('M','F') AND status IN ('Y','N')")
public class Member {

    @Id
    @Column(length = 30)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userPwd;

    @Column(length = 15, nullable = false)
    private String userName;

    @Column(length = 254)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private Integer age;

    @Column(length = 13)
    private String phone;

    @Column(length = 100)
    private String address;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime enrollDate;

    @UpdateTimestamp
    private LocalDateTime modifyDate;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'Y'")
    private Status status = Status.Y;

    public enum Gender {
        M, F;
    }

    public enum Status {
        Y, N;
    }
}
