package kodlamaio.hrms.business.concretes.userManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.userServices.UserService;
import kodlamaio.hrms.dataAccess.abstracts.userDaos.UserDao;
import kodlamaio.hrms.entities.concretes.users.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {

		return userDao.findAll();
	}

}
