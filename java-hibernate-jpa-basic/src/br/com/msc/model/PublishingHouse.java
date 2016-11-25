package br.com.msc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "email", name = "publishinghouse_email_unique") })
public class PublishingHouse implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@CreationTimestamp	
	private Timestamp createAt;

	@UpdateTimestamp	
	private Timestamp updateAt;

	public Long getId() {
		return id;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "id: " + getId() + ", name: " + getName() + ", email: " + getEmail() + " ;";
	}

}
