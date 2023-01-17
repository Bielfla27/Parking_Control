package com.example.parkingcontrol.config.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.parkingcontrol.model.UserModel;
import com.example.parkingcontrol.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	final UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Não foi encontrado usuario com o nome: " + username));
		return userModel;
	}

}
