package com.smartIq.vehicledealership.vehicledealership.User.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "users")
@Data
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;

  public void setCompany(Company company){
        this.company=company;

           // company.addUser(this);


    }


}
