package kodlamaio.hrms.core.validations.abstracts;

import kodlamaio.hrms.entities.concretes.users.Candidate;
import kodlamaio.hrms.entities.concretes.users.Employer;
import kodlamaio.hrms.entities.concretes.users.User;

public interface ValidationService {
	public boolean isIdentityNumberUsed(Candidate candidate);

	public boolean isEmailUsed(User user);

	public boolean isAllFullCandidate(Candidate candidate);

	public boolean isAllFullEmployer(Employer employer);

	public boolean isDomainEqualEmail(Employer employer);

	public boolean isPasswordEqualRepeat(User user);
}
