package com.serhat.web.security;

import com.serhat.web.security.entity.*;
import com.serhat.web.security.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.*;

import javax.annotation.*;
import java.util.*;

@SpringBootApplication
public class SecurityApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
		System.out.println("Hello Spring Security");
	}

	@PostConstruct
	protected void init(){
		List<Authority> authorityList = new ArrayList<>();

		authorityList.add(createAuthority("USER","User Role"));
		authorityList.add(createAuthority("ADMIN","Admin Role"));

		User user = new User();

		user.setUserName("serhat");
		user.setFirstName("Serhat");
		user.setLastName("Köse");
		user.setEmail("serhatkose@gmail.com");
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode("serhat@test123"));
		user.setAuthorities(authorityList);

		userDetailsRepository.save(user);

	}

	private Authority createAuthority(String roleCode,String roleDesc){

		Authority authority = new Authority();

		authority.setRoleCode(roleCode);
		authority.setRoleDesc(roleDesc);

		return authority;
	}

}
