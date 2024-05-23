package com.smart.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="Users")
@Entity(name="user")
public class User {
	
	@Id
	private String userId;
	@Column(name="user_name",nullable=false)
	private String name;
	@Column(unique=true,nullable=false)
	private String email;
	private String password;
	@Column(length = 1000)
	private String about;
	@Column(length = 1000)
	private String profilePic;
	private String phoneNumber;
	
	
	//INFORMATION
	@Builder.Default
	private boolean enabled=false;
	@Builder.Default
	private boolean emailVerified=false;
	@Builder.Default
	private boolean phoneVerified=false;
	
	//SELF,GOOGLE,GITHUB
	@Builder.Default
	@Enumerated(value = EnumType.STRING)
	private Providers provider = Providers.SELF;
	private String providerUserId;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@Builder.Default
	private List<Contact> contacts= new ArrayList<>();

	
}
