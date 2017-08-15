package cn.coding52.StudentSystem.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * ��ȡ���ݿ����ӵĹ�����
 * ʵ�����ӳأ�dbcp���ӳ�
 */
public class JDBCUtils {
	private static BasicDataSource datasource = new BasicDataSource();
	// ʵ�ֱ�Ҫ�Ĳ�������
	static {
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/student");
		datasource.setUsername("root");
		datasource.setPassword("123");
		datasource.setMaxActive(10);
		datasource.setMaxIdle(5);
		datasource.setMinIdle(2);
		datasource.setInitialSize(10);
	}

	public static DataSource getDataSource() {
		return datasource;
	}
}
