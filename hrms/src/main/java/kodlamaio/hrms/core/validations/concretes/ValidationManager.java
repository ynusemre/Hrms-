package kodlamaio.hrms.core.validations.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.validations.abstracts.ValidationService;
import kodlamaio.hrms.dataAccess.abstracts.userDaos.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.userDaos.UserDao;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import kodlamaio.hrms.entities.concretes.users.Employer;
import kodlamaio.hrms.entities.concretes.users.User;

@Service
public class ValidationManager implements ValidationService {

	private CandidateDao candidateDao;
	private UserDao userDao;

	@Autowired
	public ValidationManager(CandidateDao candidateDao, UserDao userDao) {
		this.candidateDao = candidateDao;
		this.userDao = userDao;
	}

	@Override
	public boolean isIdentityNumberUsed(Candidate candidate) {
		if (candidateDao.findByIdentityNumberEquals(candidate.getIdentityNumber()).size() != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isEmailUsed(User user) {
		if (userDao.findByEmailEquals(user.getEmail()).size() != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isAllFullCandidate(Candidate candidate) {
		if ((candidate.getEmail().isEmpty()) || (candidate.getBirthYear() == 0) || (candidate.getFirstName().isEmpty())
				|| (candidate.getLastName().isEmpty()) || (candidate.getPassword().isEmpty())
				|| (candidate.getIdentityNumber().isEmpty())) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean isAllFullEmployer(Employer employer) {
		if ((employer.getEmail().isEmpty()) || (employer.getCompanyName().isEmpty())
				|| (employer.getPhoneNumber().isEmpty()) || (employer.getWebAdress().isEmpty())
				|| (employer.getPassword().isEmpty())) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isDomainEqualEmail(Employer employer) {
		String[] splitEmail = employer.getEmail().split("@");
		String[] splitWebAddress = employer.getWebAdress().split("\\.");

		if (splitEmail[0].equals(splitWebAddress[1])) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isPasswordEqualRepeat(User user) {
		if (user.getPassword().equals(user.getRepeatPassword())) {
			return true;
		} else {
			return false;
		}

	}
}
