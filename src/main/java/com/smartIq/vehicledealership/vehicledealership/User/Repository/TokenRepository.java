package com.smartIq.vehicledealership.vehicledealership.User.Repository;

import com.smartIq.vehicledealership.vehicledealership.User.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    Optional<Token> findTokenByTokenCode(String tokenCode);

}
