package com.example.users.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.users.model.Role;
import com.example.users.model.User;
import com.example.users.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userRepository.findByUserName(username);
			if (user == null) {
				throw new UsernameNotFoundException("No user found with the username: " + username);
			}
			return new org.springframework.security.core.userdetails.User(
					username, user.getPassword(), user.isEnabled()
					, true, true, true, getAuthorities(user.getRole()));
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}


	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> role) {
		return getGrantedGrantedAuthorities(getPrivileges(role));
	}


	private List<String> getPrivileges(final Collection<Role> roles) {
		final List<String> privileges = new ArrayList<>();
		for (final Role role : roles) {
			privileges.add(role.getRoleName());
		}
		
		return privileges;
	}
	
	private List<GrantedAuthority> getGrantedGrantedAuthorities(final List <String> privileges) {
		final List<GrantedAuthority> authorities = new ArrayList<>();
		for (final String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		
		return authorities;
	}

}