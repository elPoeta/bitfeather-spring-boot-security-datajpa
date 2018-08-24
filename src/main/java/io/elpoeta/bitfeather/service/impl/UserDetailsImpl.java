
package io.elpoeta.bitfeather.service.impl;

import io.elpoeta.bitfeather.domain.Role;
import io.elpoeta.bitfeather.domain.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author elpoeta
 */
public class UserDetailsImpl implements UserDetails{
    	private User user;
	
	public UserDetailsImpl(User user){
		this.user = user;
	}
        
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Collection<GrantedAuthority> autoridades = new HashSet();
		List<Role> roles = user.getRoles();
		for( Role role : roles ) {
			autoridades.add( new SimpleGrantedAuthority(role.getRol())); 
		}
		return autoridades;	
    }

    @Override
    public String getPassword() {
      return  this.user.getPassword();
    }

    @Override
    public String getUsername() {
      return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
     return true;
    }

    @Override
    public boolean isAccountNonLocked() {
     return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isActivo();
    }
    
}
