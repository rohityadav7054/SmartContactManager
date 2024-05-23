package com.smart.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Data
@Builder
@Entity
public class Contact {

	@Id
	private String id;
	private String name;
	private String email;
	private String PhoneNumber;
	private String address;
	private String pictures;
	@Column(length = 1000)
	private String description;
	@Builder.Default
	private boolean favorite = false;
	private String websiteLink;
	private String LinkedLink;
	//private List<String> sociallink=new ArrayList<>();
	
	@ManyToOne
	private User user;

	@OneToMany(mappedBy ="contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@Builder.Default
	private List<SocialLink> links = new ArrayList<>();

	
}
