package kodlamaio.hrms.dataAccess.abstracts.userDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.users.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
