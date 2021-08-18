package com.ronghuan.loginregistrationdemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    
    // MEMBER VARIABELS (BACK-END VALIDATION)

    @Email(message = "Must have valid email format")
    private String email;
    
    @NotEmpty(message = "Must have password")
    private String password;
    
	// dummy variable(not store in db)
    @Transient
    private String passwordConfirmation;
    
//    @Transient
//    private String duplicate;
    
    // RELATIONSHIPS
    
    // CONSTRUCTORS
    // EMPTY
    public User() {
    	
    }
    // FULL
    public User(String email, String password, String passwordConfirmation) {
    	this.email = email;
    	this.password = password;
    	this.passwordConfirmation = passwordConfirmation;
    }
    
    // GETTERS/SETTERS
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

//	public String getDuplicate() {
//		return duplicate;
//	}
//	public void setDuplicate(String duplicate) {
//		this.duplicate = duplicate;
//	}


	@Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
