package com.smartIq.vehicledealership.vehicledealership.User.entity;

import com.smartIq.vehicledealership.vehicledealership.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private final static LocalDateTime expiration = LocalDateTime.now().plusHours(8);

    @OneToOne(
            mappedBy = "token",
            fetch = FetchType.LAZY
    )
    private User user;


}
