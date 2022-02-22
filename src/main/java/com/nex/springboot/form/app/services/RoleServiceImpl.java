package com.nex.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nex.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {

	private List<Role> roles;

	public RoleServiceImpl() {
		this.roles = new ArrayList<>();
		this.roles.add(new Role(1, "Administrator", "ROLE_ADMIN"));
		this.roles.add(new Role(2, "User", "ROLE_USER"));
		this.roles.add(new Role(3, "Moderator", "ROLE_MODERATOR"));
	}

	@Override
	public List<Role> list() {
		return roles;
	}

	@Override
	public Role getById(Integer id) {
		Role result = null;
		for (Role role : roles) {
			if (id == role.getId()) {
				result = role;
				break;
			}
		}
		return result;
	}

}
