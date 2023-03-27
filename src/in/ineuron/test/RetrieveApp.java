package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class RetrieveApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		boolean flag = false;
		Integer row = 0;
		Employee employee = null;

		try {

			session = HibernateUtil.getSession();
			if (session != null) {

				employee = session.get(Employee.class, 1);

				if (employee != null)
					System.out.println(employee);
				else
					System.out.println("Record Not Found");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
