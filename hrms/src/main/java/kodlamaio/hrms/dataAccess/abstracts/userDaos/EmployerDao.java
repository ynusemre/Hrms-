package kodlamaio.hrms.dataAccess.abstracts.userDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.users.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
