package com.smartIq.vehicledealership.vehicledealership.Company.entity;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.common.entity.BaseEntity;
import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "company")
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    private Status companyStatus;

    @OneToMany(
            mappedBy = "company",
            fetch = FetchType.LAZY
    )
    private List<User> users;

    /**
     * Making them related.
     *
     * @param user
     */
    public void addUser( User user){
        this.users.add(user);
        user.setCompany(this);
    }



}
