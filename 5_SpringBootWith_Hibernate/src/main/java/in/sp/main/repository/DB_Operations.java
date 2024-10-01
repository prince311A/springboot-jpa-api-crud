package in.sp.main.repository;

import in.sp.main.entity.User;

public interface DB_Operations {
	public int registerUser(User user);
	public User getUserDetails(int id);

}
