
package io.elpoeta.bitfeather.service;

import io.elpoeta.bitfeather.domain.Role;
import java.util.List;
import java.util.Set;

/**
 *
 * @author elpoeta
 */
public interface RoleService {
    Role buscarPorRol(String rol);
    List<Role> buscarTodos();
}
