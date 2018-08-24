
package io.elpoeta.bitfeather.service.impl;

import io.elpoeta.bitfeather.domain.User;
import io.elpoeta.bitfeather.repository.UserRepository;
import io.elpoeta.bitfeather.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author elpoeta
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{
    
	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
        
    @Override
    public User buscarPorEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = buscarPorEmail(email);
		if( user == null ){
			throw new UsernameNotFoundException(email);
		}
		
		return new UserDetailsImpl(user);
    }

    @Override
    public User insertarUser(User user) {
        return this.userRepository.save(user);
    }
    
}
