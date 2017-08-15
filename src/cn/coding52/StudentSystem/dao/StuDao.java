package cn.coding52.StudentSystem.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.coding52.StudentSystem.domain.Stuinfo;
import cn.coding52.StudentSystem.tools.JDBCUtils;

/*
 * �����ݱ�ѧ����Ϣ��������ɾ�Ĳ����
 * 
 */
public class StuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	
	/*
	 * ʵ��ɾ������
	 */
	
	public void delInfo(int sid) {
		String sql="DELETE FROM `ѧ����Ϣ��` WHERE sid=?";
		try {
			qr.update(sql, sid);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("ɾ��ʧ�ܣ�");
		}
		
	}
	/*
	 * ʵ����ӹ���
	 */
	public void addInfo(Stuinfo si) {
		String sql = "INSERT INTO `ѧ����Ϣ��` (name,sex,xy,zhuangye,jiguang,aihao,phonenum,date) VALUES (?,?,?,?,?,?,?,?)";
		Object[] params = { si.getName(), si.getSex(), si.getXy(),
				si.getZhuangye(), si.getJiguang(), si.getAihao(),
				si.getPhonenum(), si.getDate() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("��Ϣ���ʧ��");
		}
	}

	/*
	 * �������ڲ�ѯ���ݿ����ɸѡ
	 */
	public List<Stuinfo> select1(String startDate, String endDate) {
		String sql = "SELECT* FROM `ѧ����Ϣ��` WHERE date BETWEEN ? AND ?";
		Object[] params = { startDate, endDate };
		try {
			List<Stuinfo> list = qr.query(sql, new BeanListHandler<>(
					Stuinfo.class), params);
			return list;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("������ѯʧ��");
		}
	}

	/*
	 * ���巽������ѯ���ݣ���ȡ���е�ѧ������
	 */
	public List<Stuinfo> selectAll() {
		// ��ѯ��Ϣ��sql���
		String sql = "SELECT * FROM `ѧ����Ϣ��`";
		// ����qr����ķ�����query����
		List<Stuinfo> list;
		try {
			list = qr.query(sql, new BeanListHandler<>(Stuinfo.class));
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("��ѯʧ��");
		}
		return list;

	}
	/*
	 * �������� ����ѧ��ѧ�Ų���
	 */
	public List<Stuinfo> selset2(int sid) {
		String sql="SELECT *FROM `ѧ����Ϣ��` WHERE sid=?";
		List<Stuinfo> list;
		try {
			list=qr.query(sql, new BeanListHandler<>(Stuinfo.class), sid);
			return list;
		} catch (SQLException e) {
			System.out.println("e");
			throw new RuntimeException("��ѯʧ�ܣ�");
		}
		
	}
	
	/*
	 * �������� ����ѧ����������
	 */
	public List<Stuinfo> selset3(String name) {
		String sql="SELECT *FROM `ѧ����Ϣ��` WHERE name=?";
		List<Stuinfo> list;
		try {
			list=qr.query(sql, new BeanListHandler<>(Stuinfo.class), name);
			return list;
		} catch (SQLException e) {
			System.out.println("e");
			throw new RuntimeException("��ѯʧ�ܣ�");
		}
		
	}

	public void editInfo(Stuinfo si) {
		String sql = "UPDATE `ѧ����Ϣ��` SET name=?,sex=?,xy=?,zhuangye=?,jiguang=?,aihao=?,phonenum=?,date=? WHERE sid=?";
		Object[] params = { si.getName(), si.getSex(), si.getXy(),
				si.getZhuangye(), si.getJiguang(), si.getAihao(),
				si.getPhonenum(),si.getDate(), si.getSid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("�޸�ʧ��");
		}

	}
	
}
