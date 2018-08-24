
package io.elpoeta.bitfeather.controller.rest;

import io.elpoeta.bitfeather.domain.Role;
import io.elpoeta.bitfeather.domain.User;
import io.elpoeta.bitfeather.service.RoleService;
import io.elpoeta.bitfeather.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elpoeta
 */
@RestController
@RequestMapping("api/user")
public class UserRestController {
    private UserService userService;
    private RoleService roleService;
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }
    
    @Autowired
    public void setRoleService(RoleService roleService){
        this.roleService = roleService;
    }
    
    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    	//@PostMapping("/registrar")
        @GetMapping("/registrar")
	public String registrarUser(/*@RequestBody User user*/) {
		//String pass = user.getPassword();
		//String encryptPass = passwordEncoder.encode(pass);
                String encryptPass = passwordEncoder.encode("elpoeta");
                User u = new User();
                List<Role> roles;
                //roles.add(this.roleService.buscarPorRol("USER"));
                roles = this.roleService.buscarTodos();
                u.setNombre("Leonardo");
                u.setEmail("elpoeta@gmail.com");
		u.setPassword(encryptPass);
                u.setIsActivo(true);
                u.setRoles(roles);
                System.out.println("user "+u);
		this.userService.insertarUser(u);
		return "Usuario Agregado..."+u;
	}
        
        @GetMapping("/usuario")
        public User traerUsuario(){
            return this.userService.buscarPorEmail("elpoeta@gmail.com");
        }
}
