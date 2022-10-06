package kodlamaio.hrms.core.adapters.abstracts;

import java.rmi.RemoteException;

import kodlamaio.hrms.entities.concretes.users.Candidate;

public interface CandidateCheckService {
	public boolean CheckIfRealCandidate(Candidate candidate) throws NumberFormatException, RemoteException;
}
