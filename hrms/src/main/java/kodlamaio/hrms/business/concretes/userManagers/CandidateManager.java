package kodlamaio.hrms.business.concretes.userManagers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.userServices.CandidateService;
import kodlamaio.hrms.core.adapters.abstracts.CandidateCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validations.abstracts.ValidationService;
import kodlamaio.hrms.core.verifications.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.dataAccess.abstracts.userDaos.CandidateDao;
import kodlamaio.hrms.entities.concretes.users.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private ValidationService validationService;
	private VerificationCodeCandidateService verificationCodeCandidateService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService,
			ValidationService validationService, VerificationCodeCandidateService verificationCodeCandidateService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
		this.validationService = validationService;
		this.verificationCodeCandidateService = verificationCodeCandidateService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Adaylar Listelendi");
	}

	@Override
	public Result save(Candidate candidate) throws Exception {
		if (candidateCheckService.CheckIfRealCandidate(candidate) && validationService.isIdentityNumberUsed(candidate)
				&& validationService.isEmailUsed(candidate) && validationService.isAllFullCandidate(candidate)
				&& validationService.isPasswordEqualRepeat(candidate)) {
			candidateDao.save(candidate);

			verificationCodeCandidateService.sendCode(candidate.getEmail());

			if (verificationCodeCandidateService.ısVerified(true, new Date(2022), candidate).isSuccess()) {
				return new SuccessResult(verificationCodeCandidateService.sendCode(candidate.getEmail()).getMessage()
						+ "--> Onaylandı " + "--> Aday sisteme eklendi");
			}

		} else if (!validationService.isAllFullCandidate(candidate)) {
			return new ErrorResult("Lütfen boş alan bırakmayınız.");
		} else if (!validationService.isPasswordEqualRepeat(candidate)) {
			return new ErrorResult("şifre tekrarı ve şifre eşit değildir.");
		} else if (!candidateCheckService.CheckIfRealCandidate(candidate)) {
			return new ErrorResult("Mernis doğrulaması gerçekleşmedi.");
		} else if (!validationService.isIdentityNumberUsed(candidate)) {
			return new ErrorResult("Kimlik numarası daha önceden kullanılmış.");
		} else if (!validationService.isEmailUsed(candidate)) {
			return new ErrorResult("Emil daha önceden kullanılmış.");
		}
		return new ErrorResult();

	}

}
