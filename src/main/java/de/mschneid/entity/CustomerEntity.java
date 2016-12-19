package de.mschneid.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
	
	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="customer_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pk_sequence")
	private Long id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	
//	public CustomerEntity(Long id, String firstName) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//	}
	
	
	
	
	
	
	
	

}
