package kodlamaio.hrms.business.abstracts.userServices;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.users.Candidate;

public interface CandidateService {
	public DataResult<List<Candidate>> getAll();

	public Result save(Candidate candidate) throws Exception;

}
