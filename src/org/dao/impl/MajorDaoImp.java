package org.dao.impl;
import java.util.*;
import org.dao1.MajorDao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Major;
public class MajorDaoImp implements MajorDao{
	//��ѯĳ��רҵ����Ϣ
	public Major getOneMajor(Integer mid) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from Major where mid=?0");
			query.setParameter(0, mid);
			query.setMaxResults(1);
			Major major=(Major) query.uniqueResult();				//ִ�в�ѯ�����ؽ��
			ts.commit();
			return major;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//��ȡ����רҵ����Ϣ
	public List getAll() {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			List list=Hsession.createQuery("from Major").list();		//��ȡ������б�
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
