package kodlamaio.hrms.core.confirms.concretes;

import java.sql.Date;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.confirms.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.employeeConfirmDaos.EmployeeConfirmEmployerDao;
import kodlamaio.hrms.entities.concretes.employeeConfirms.EmployeeConfirmEmployer;
import kodlamaio.hrms.entities.concretes.users.Employee;
import kodlamaio.hrms.entities.concretes.users.Employer;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService {

	private EmployeeConfirmEmployerDao employeeConfirmEmployerDao;
	EmployeeConfirmEmployer employeeConfirmEmployer = new EmployeeConfirmEmployer();

	public EmployeeConfirmEmployerManager(EmployeeConfirmEmployerDao employeeConfirmEmployerDao) {
		this.employeeConfirmEmployerDao = employeeConfirmEmployerDao;
	}

	@Override
	public Result employeeWhoConfirmed(Employee employee) {
		employeeConfirmEmployer.setEmployeeId(employee.getId());
		employeeConfirmEmployer.setConfirm(true);
		employeeConfirmEmployer.setConfirmDate(new Date(2022));

		return new SuccessResult();

	}

	@Override
	public Result confirmedEmployer(Employer employer) {
		employeeConfirmEmployer.setEmployerId(employer.getId());

		return new SuccessResult();
	}

	@Override
	public Result confirm() {
		employeeConfirmEmployerDao.save(employeeConfirmEmployer);
		return new SuccessResult();
	}

}
