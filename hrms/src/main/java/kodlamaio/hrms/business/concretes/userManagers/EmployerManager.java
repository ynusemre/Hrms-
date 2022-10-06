package kodlamaio.hrms.business.concretes.userManagers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.userServices.EmployerService;
import kodlamaio.hrms.core.confirms.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validations.abstracts.ValidationService;
import kodlamaio.hrms.core.verifications.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.dataAccess.abstracts.userDaos.EmployerDao;
import kodlamaio.hrms.entities.concretes.users.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private ValidationService validationService;
	private VerificationCodeEmployerService verificationCodeEmployerService;
	private EmployeeConfirmEmployerService employeeConfirmEmployerService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ValidationService validationService,
			VerificationCodeEmployerService verificationCodeEmployerService,
			EmployeeConfirmEmployerService employeeConfirmEmployerService) {
		super();
		this.employerDao = employerDao;
		this.validationService = validationService;
		this.verificationCodeEmployerService = verificationCodeEmployerService;
		this.employeeConfirmEmployerService = employeeConfirmEmployerService;

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "İş verenler listelendi");
	}

	@Override
	public Result save(Employer employer) {
		if (validationService.isEmailUsed(employer) && validationService.isAllFullEmployer(employer)
				&& validationService.isDomainEqualEmail(employer)
				&& validationService.isPasswordEqualRepeat(employer)) {
			employerDao.save(employer);

			verificationCodeEmployerService.sendCode(employer.getEmail());

			if (verificationCodeEmployerService.ısVerified(true, new Date(2022), employer).isSuccess()
					&& employeeConfirmEmployerService.confirmedEmployer(employer).isSuccess()) {
				return new SuccessResult(verificationCodeEmployerService.sendCode(employer.getEmail()).getMessage()
						+ "--> Onaylandı " + "--> İş veren sisteme eklendi");
			}

		} else if (!validationService.isAllFullEmployer(employer)) {
			return new ErrorResult("Lütfen boş alan bırakmayınız.");
		} else if (!validationService.isPasswordEqualRepeat(employer)) {
			return new ErrorResult("şifre tekrarı ve şifre eşit değildir.");
		} else if (!validationService.isEmailUsed(employer)) {
			return new ErrorResult("Emil daha önceden kullanılmış.");
		} else if (!validationService.isDomainEqualEmail(employer)) {
			return new ErrorResult("Web domain'i ve Email eşit olmalıdır.");
		}
		return new ErrorResult();

	}

}
