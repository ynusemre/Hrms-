package kodlamaio.hrms.business.abstracts.userServices;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.users.Employer;

public interface EmployerService {
	public DataResult<List<Employer>> getAll();

	public Result save(Employer employer);
}
