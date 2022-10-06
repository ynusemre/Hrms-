package kodlamaio.hrms.business.concretes.userManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.userServices.EmployeeService;
import kodlamaio.hrms.core.confirms.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.userDaos.EmployeeDao;
import kodlamaio.hrms.entities.concretes.users.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private EmployeeConfirmEmployerService employeeConfirmEmployerService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, EmployeeConfirmEmployerService employeeConfirmEmployerService) {
		super();
		this.employeeDao = employeeDao;
		this.employeeConfirmEmployerService = employeeConfirmEmployerService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(), "Çalışanlar listelendi.");

	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		employeeConfirmEmployerService.employeeWhoConfirmed(employee);
		return new SuccessResult("Çalışan sisteme eklendi.");
	}

	@Override
	public Result confirm() {
		employeeConfirmEmployerService.confirm();
		return new SuccessResult("Çalışan, iş vereni onayladı.");
	}

}
