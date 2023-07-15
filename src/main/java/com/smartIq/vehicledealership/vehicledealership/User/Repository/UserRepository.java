package com.smartIq.vehicledealership.vehicledealership.User.Repository;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
