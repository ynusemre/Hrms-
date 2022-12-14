package kodlamaio.hrms.core.verifications.abstracts;

import java.sql.Date;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.users.User;

public interface VerificationCodeService {
	public Result sendCode(String email);

	public Result ─▒sVerified(boolean ─▒sVerified, Date verifiedDate, User user);

	public Result save();
}
