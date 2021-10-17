package com.thanhdinh.rest.dao;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.thanhdinh.rest.entity.MyCustomer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	//@Transactional//(thay the cho open,commit,close)session
	private SessionFactory sessionFactory;
//tim kiem sessionFactory ben rool.xml de thuc hien cac cau truy van DB
	//ssfactory quan ly cac ss
	//ss tao ket noi vat ly den csdl
	//ssfactory la doi tuong chua cac thong tin de thuc hien tao ket noi den db:mapping,data source
	//setter for sessionFactory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MyCustomer findById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();//tao doi tuong moi
		MyCustomer customer = new MyCustomer();
		try {
			customer = (MyCustomer) session.get(MyCustomer.class, id);
			transaction.commit();// thuc hien thanh cong goi cmmit de cap nhat su thay doi CSDL
			session.close();
		} catch (Exception e) {
			transaction.rollback();//gap loi thi huy ket qua thuc hien cong viec(xay ra loi)
			session.close();
		}
		return customer;
	}

	public MyCustomer findByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		String hql = "from com.thanhdinh.rest.entity.MyCustomer where name = ?";
		try {
			Query query = session.createQuery(hql);//tao doi tuong query
			query.setParameter(0, name);
			customer = (MyCustomer) query.uniqueResult();//thuc hien truy van
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return customer;
	}

	public void saveCustomer(MyCustomer Customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (Customer != null) {
			try {
				session.save(Customer);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}

		}

	}

	public void updateCustomer(MyCustomer Customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (Customer != null) {
			try {
				session.update(Customer);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}

		}

	}

	public void deleteCustomerById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		try {
			customer = (MyCustomer) session.get(MyCustomer.class, id);
			session.delete(customer);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<MyCustomer> findAllCustomers() {
		List<MyCustomer> customer = new ArrayList<MyCustomer>();
		Session session = sessionFactory.openSession();
		customer = session.createQuery("From com.thanhdinh.rest.entity.MyCustomer").list();
		return customer;
	}

	
	public void deleteAllCustomers() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.createQuery("delete from MyCustomer").executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}

	}
//
//	public boolean isCustomerExist(MyCustomer Customer) {
//		
//			return findByName(Customer.getName())!=null;
//	}

	public boolean isCustomerExist(MyCustomer Customer) {
		
			return findById(Customer.getId())!=null;
	}

}
