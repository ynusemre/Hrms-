package kodlamaio.hrms.dataAccess.abstracts.userDaos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.users.User;

public interface UserDao extends JpaRepository<User, Integer> {
	public List<User> findByEmailEquals(String email);
}
