package in.sp.main.repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import in.sp.main.config.HibernateConfig;
import in.sp.main.entity.User;
@Repository
public class DB_OperationsImpl implements DB_Operations {
	@Override
	public int registerUser(User user) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction	transaction = session.beginTransaction();
		int i = 0;
		try { 
	        i = (Integer)session.save(user);
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public User getUserDetails(int id) {
		User user = null;
		try 
		(Session session = HibernateConfig.getSessionFactory().openSession();
				)
		{
			
		user = session.get(User.class, 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	

}
