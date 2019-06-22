package com.employee.source;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try 
		{
		  session.beginTransaction();
		  Employee emp=new Employee("Sonam","Gadekari","sonam.gadekari@gmail.com");
		  session.save(emp);
		  session.getTransaction().commit();
		  emp.getId();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			factory.close();			
		}
									
	}
}
