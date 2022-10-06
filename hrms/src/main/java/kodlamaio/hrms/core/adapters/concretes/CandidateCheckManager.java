package kodlamaio.hrms.core.adapters.concretes;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.adapters.abstracts.CandidateCheckService;
import kodlamaio.hrms.entities.concretes.users.Candidate;

public class CandidateCheckManager implements CandidateCheckService {

	@Override
	public boolean CheckIfRealCandidate(Candidate candidate) throws NumberFormatException, RemoteException {

		return true;
	}

}
