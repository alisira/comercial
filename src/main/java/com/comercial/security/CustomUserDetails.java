package com.comercial.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.comercial.domain.User;

public class CustomUserDetails extends com.comercial.domain.User implements UserDetails {	
	
	private static final long serialVersionUID = 1L;
	private List<String> userRoles;
	

	public CustomUserDetails(User user,List<String> userRoles){
		super(user);
		this.userRoles=userRoles;
	}
	
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		String roles=StringUtils.collectionToCommaDelimitedString(userRoles);			
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isAccountNonLocked() {
		return true;
	}
	
	
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	public boolean isEnabled() {
		return true;
	}


	
	public String getUsername() {
		return super.getUserName();
	}


}
