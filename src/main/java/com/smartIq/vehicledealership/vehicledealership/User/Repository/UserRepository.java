package com.smartIq.vehicledealership.vehicledealership.User.Repository;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findUserByEmail(String email);

    /**
     * Parametre olarak verilen Company'e ait olan kullanıcıları geriye
     * bir optional içerisinde liste halde dönen metod.
     *
     * @param company
     * @return
     */
    Optional<List<User>> findUsersByCompany(Company company);

    /**
     * Parametre olarak verilen id değeri ve Company değerine sahip olan
     * User entity nesnesini geriye Optional yapıda döndürür.
     *
     * @param id
     * @param company
     * @return
     */
    Optional<User> findUserByIdAndCompany(Long id, Company company);


    boolean existsByEmail(String email);

}
