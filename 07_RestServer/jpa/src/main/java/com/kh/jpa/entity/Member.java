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
    private String user_id;

    @Column(length = 100, nullable = false)
    private String user_pwd;

    @Column(length = 15, nullable = false)
    private String user_name;

    @Column(length = 254)
    private String email;

    @Column(columnDefinition = "CHAR(1)")
    private String gender;

    @Column
    private int age;

    @Column(length = 13)
    private String phone;

    @Column(length = 100)
    private String address;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'Y'")
    private String status = "Y";
}
