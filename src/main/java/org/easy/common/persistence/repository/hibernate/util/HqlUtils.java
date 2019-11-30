package org.easy.common.persistence.repository.hibernate.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class HqlUtils {
	
	private HqlUtils(){
		
	}
	
	public static List<?> hqlSelect(Session session, String hqlStatement) {
		Query query = session.createQuery( hqlStatement );
		// Query query = session.createQuery( "from Stock where stockCode = :code " );
		// query.setParameter( "code", "7277" );
		List<?> list = query.list();
		return list;

	}
	
	public static List<?> hqlNamedQuery(Session session, String namedQuery) {
		Query query = session.getNamedQuery( namedQuery );
		// Query query = session.createQuery( "from Stock where stockCode = :code " );
		// query.setParameter( "code", "7277" );
		List<?> list = query.list();
		return list;
	}

	public static void hqlUpdate(Session session, String hqlStatement) {
		Query query = session.createQuery( hqlStatement );
		/*
		 * Query query = session.createQuery( "update Stock set stockName = :stockName" +
		 * " where stockCode = :stockCode" );
		 * query.setParameter( "stockName", "DIALOG1" );
		 * query.setParameter( "stockCode", "7277" );
		 */
		int result = query.executeUpdate();
	}

	public static void hqlDelete(Session session, String hqlStatement) {
		Query query = session.createQuery( hqlStatement );
		/*
		 * Query query = session.createQuery("delete Stock where stockCode = :stockCode");
		 * query.setParameter("stockCode", "7277");
		 */
		int result = query.executeUpdate();
	}

	public static void hqlInsert(Session session, String hqlStatement) {
		Query query = session.createQuery( hqlStatement);
		/*Query query = session.createQuery( "insert into Stock(stock_code, stock_name)"
				+ "select stock_code, stock_name from backup_stock" );*/
		int result = query.executeUpdate();
	}
	
	public static List<?> sqlQuery(Session session,String sqlQry){
		Query query = session.createSQLQuery(
				sqlQry);
				
		/*Query query = session.createSQLQuery(
				"select s.stock_code from stock s where s.stock_code = :stockCode")
				.setParameter("stockCode", "7277");*/
				 List<?> result = query.list();
				return  result;
	}

}
