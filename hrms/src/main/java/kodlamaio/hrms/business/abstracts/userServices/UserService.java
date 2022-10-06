package kodlamaio.hrms.business.abstracts.userServices;

import java.util.List;

import kodlamaio.hrms.entities.concretes.users.User;

public interface UserService {
	public List<User> getAll();
}
