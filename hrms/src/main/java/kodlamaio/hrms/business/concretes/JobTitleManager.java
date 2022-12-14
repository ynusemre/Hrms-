package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(), "Ünvanlar Listelendi");

	}

	public boolean isPositionSavedBefore(JobTitle jobTitle) {
		if (jobTitleDao.findByTitleContaining(jobTitle.getTitle()).size() != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if (isPositionSavedBefore(jobTitle)) {
			jobTitleDao.save(jobTitle);
			return new SuccessResult("İş Pozisyonu sisteme eklendi");

		} else {
			return new ErrorResult("Lütfen kayıtlı olmayan bir iş pozisyonu giriniz");
		}

	}

}
