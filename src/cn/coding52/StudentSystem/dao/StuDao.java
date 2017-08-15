package cn.coding52.StudentSystem.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.coding52.StudentSystem.domain.Stuinfo;
import cn.coding52.StudentSystem.tools.JDBCUtils;

/*
 * 对数据表“学生信息表”进行增删改查操作
 * 
 */
public class StuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	
	/*
	 * 实现删除功能
	 */
	
	public void delInfo(int sid) {
		String sql="DELETE FROM `学生信息表` WHERE sid=?";
		try {
			qr.update(sql, sid);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("删除失败！");
		}
		
	}
	/*
	 * 实现添加功能
	 */
	public void addInfo(Stuinfo si) {
		String sql = "INSERT INTO `学生信息表` (name,sex,xy,zhuangye,jiguang,aihao,phonenum,date) VALUES (?,?,?,?,?,?,?,?)";
		Object[] params = { si.getName(), si.getSex(), si.getXy(),
				si.getZhuangye(), si.getJiguang(), si.getAihao(),
				si.getPhonenum(), si.getDate() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("信息添加失败");
		}
	}

	/*
	 * 根据日期查询数据库进行筛选
	 */
	public List<Stuinfo> select1(String startDate, String endDate) {
		String sql = "SELECT* FROM `学生信息表` WHERE date BETWEEN ? AND ?";
		Object[] params = { startDate, endDate };
		try {
			List<Stuinfo> list = qr.query(sql, new BeanListHandler<>(
					Stuinfo.class), params);
			return list;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("条件查询失败");
		}
	}

	/*
	 * 定义方法，查询数据，获取所有的学生数据
	 */
	public List<Stuinfo> selectAll() {
		// 查询信息的sql语句
		String sql = "SELECT * FROM `学生信息表`";
		// 调用qr对象的方法，query方法
		List<Stuinfo> list;
		try {
			list = qr.query(sql, new BeanListHandler<>(Stuinfo.class));
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("查询失败");
		}
		return list;

	}
	/*
	 * 条件查找 根据学生学号查找
	 */
	public List<Stuinfo> selset2(int sid) {
		String sql="SELECT *FROM `学生信息表` WHERE sid=?";
		List<Stuinfo> list;
		try {
			list=qr.query(sql, new BeanListHandler<>(Stuinfo.class), sid);
			return list;
		} catch (SQLException e) {
			System.out.println("e");
			throw new RuntimeException("查询失败！");
		}
		
	}
	
	/*
	 * 条件查找 根据学生姓名查找
	 */
	public List<Stuinfo> selset3(String name) {
		String sql="SELECT *FROM `学生信息表` WHERE name=?";
		List<Stuinfo> list;
		try {
			list=qr.query(sql, new BeanListHandler<>(Stuinfo.class), name);
			return list;
		} catch (SQLException e) {
			System.out.println("e");
			throw new RuntimeException("查询失败！");
		}
		
	}

	public void editInfo(Stuinfo si) {
		String sql = "UPDATE `学生信息表` SET name=?,sex=?,xy=?,zhuangye=?,jiguang=?,aihao=?,phonenum=?,date=? WHERE sid=?";
		Object[] params = { si.getName(), si.getSex(), si.getXy(),
				si.getZhuangye(), si.getJiguang(), si.getAihao(),
				si.getPhonenum(),si.getDate(), si.getSid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("修改失败");
		}

	}
	
}
