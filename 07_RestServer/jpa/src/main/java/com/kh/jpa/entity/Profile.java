package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "PROFILE")
public class Profile {
//    PROFILE_ID IDENTITY PRIMARY KEY,
//    USER_ID VARCHAR(30) UNIQUE,
//    PROFILE_IMAGE VARCHAR(100),
//    INTRO VARCHAR(300),
//    FOREIGN KEY (USER_ID) REFERENCES MEMBER(USER_ID) ON DELETE CASCADE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long profileId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false, unique = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Column(length = 100)
    private String profileImage;

    @Column(length = 300)
    private String intro;

}
