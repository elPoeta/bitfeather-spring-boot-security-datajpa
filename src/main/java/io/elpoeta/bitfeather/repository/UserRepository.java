
package io.elpoeta.bitfeather.repository;

import io.elpoeta.bitfeather.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elpoeta
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
}
