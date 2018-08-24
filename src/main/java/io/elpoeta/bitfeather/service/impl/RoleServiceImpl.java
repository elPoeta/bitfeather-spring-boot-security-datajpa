
package io.elpoeta.bitfeather.service.impl;

import io.elpoeta.bitfeather.domain.Role;
import io.elpoeta.bitfeather.repository.RoleRepository;
import io.elpoeta.bitfeather.service.RoleService;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author elpoeta
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
  private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
  
    @Override
    public List<Role> buscarTodos() {
        return  this.roleRepository.findAll();
    }

    @Override
    public Role buscarPorRol(String rol) {
        return this.roleRepository.findByRol(rol);
    }
    
}
