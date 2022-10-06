package kodlamaio.hrms.core.confirms.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.users.Employee;
import kodlamaio.hrms.entities.concretes.users.Employer;

public interface EmployeeConfirmService {
	public Result employeeWhoConfirmed(Employee employe);

	public Result confirmedEmployer(Employer employer);

	public Result confirm();
}
