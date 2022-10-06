package kodlamaio.hrms.entities.concretes.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@Table(name = "employers")
public class Employer extends User {

	@Id
	@GeneratedValue()
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	private String CompanyName;

	@Column(name = "web_address")
	private String webAdress;

	@Column(name = "phone_number")
	private String phoneNumber;

}
