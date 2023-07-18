package com.smartIq.vehicledealership.vehicledealership.User.Repository;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findUserByEmail(String email);


    boolean existsByEmail(String email);

}
