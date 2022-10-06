package kodlamaio.hrms.dataAccess.abstracts.userDaos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.users.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	public List<Candidate> findByIdentityNumberEquals(String identityNumber);

}
