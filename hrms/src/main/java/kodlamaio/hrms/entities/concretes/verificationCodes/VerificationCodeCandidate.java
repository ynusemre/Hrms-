package kodlamaio.hrms.entities.concretes.verificationCodes;

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
@Table(name = "verification_code_candidates")
public class VerificationCodeCandidate extends VerificationCode {

	@Id
	@GeneratedValue()
	@Column(name = "id")
	private int id;

	@Column(name = "candidate_id")
	private int candidateId;
}
