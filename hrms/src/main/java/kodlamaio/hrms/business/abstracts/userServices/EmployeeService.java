package kodlamaio.hrms.business.abstracts.userServices;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.users.Employee;

public interface EmployeeService {
	public DataResult<List<Employee>> getAll();

	public Result confirm();

	public Result add(Employee employee);
}
