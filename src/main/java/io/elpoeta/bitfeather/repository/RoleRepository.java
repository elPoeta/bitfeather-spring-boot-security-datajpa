
package io.elpoeta.bitfeather.repository;

import io.elpoeta.bitfeather.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elpoeta
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRol(String rol);
}
