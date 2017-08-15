package cn.coding52.StudentSystem.view;

import java.util.List;
import java.util.Scanner;

import cn.coding52.StudentSystem.dao.StuDao;
import cn.coding52.StudentSystem.domain.Stuinfo;

/*
 * 视图层
 * 数据传递给controller层
 */
public class MainView {
	private StuDao dao = new StuDao();

	/*
	 * 实现界面效果 接收实时输入
	 */
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("---------------学生信息管理系统---------------");
			System.out.println("1.添加学生信息　2.编辑学生信息　3.删除学生信息　4.查询学生信息　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			// 输入选择的菜单
			int choose = sc.nextInt();

			switch (choose) {
			case 1:
				// 添加信息
				addInfo();
				break;
			case 2:
				// 编辑信息，调用编辑信息的方法
				editInfo();
				break;
			case 3:
				// 删除信息
				delInfo();
				break;
			case 4:
				// 查询信息
				selectStu();
				break;
			case 5:
				System.exit(0);
			}

		}
	}

	/*
	 * 删除学生信息
	 */
	private void delInfo() {
		selectAll();
		System.out.println("请输入要删除的学生学号");
		Scanner sc=new Scanner(System.in);
		int sid=sc.nextInt();
		dao.delInfo(sid);
		System.out.println("删除成功！");

	}

	/*
	 * 编辑学生信息
	 */
	public void editInfo() {
		selectAll();
		System.out.println("请选择要修改的学生学号：");
		Scanner sc = new Scanner(System.in);
		int sid = sc.nextInt();
		System.out.println("请输入学生姓名:");
		String name = sc.next();
		System.out.println("请输入学生性别：");
		String sex = sc.next();
		System.out.println("请输入学生院系：");
		String xy = sc.next();
		System.out.println("请输入学生专业：");
		String zhuangye = sc.next();
		System.out.println("请输入学生籍贯：");
		String jiguang = sc.next();
		System.out.println("请输入学生爱好：");
		String aihao = sc.next();
		System.out.println("请输入学生联系方式：");
		String phonenum = sc.next();
		System.out.println("请输入入学日期：");
		String date = sc.next();
		// 将所有用户输入的数据
		Stuinfo si = new Stuinfo(sid, name, sex, xy, zhuangye, jiguang, aihao,
				phonenum, date);
		// 调用方法
		dao.editInfo(si);
		System.out.println("修改成功");
	}

	/*
	 * 添加学生信息 接收用户输入的数据（8项 除去主键）
	 */
	public void addInfo() {
		System.out.println("您选择的是添加学生信息的功能");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生姓名:");
		String name = sc.next();
		System.out.println("请输入学生性别：");
		String sex = sc.next();
		System.out.println("请输入学生院系：");
		String xy = sc.next();
		System.out.println("请输入学生专业：");
		String zhuangye = sc.next();
		System.out.println("请输入学生籍贯：");
		String jiguang = sc.next();
		System.out.println("请输入学生爱好：");
		String aihao = sc.next();
		System.out.println("请输入学生联系方式：");
		String phonenum = sc.next();
		System.out.println("请输入入学日期：");
		String date = sc.next();
		Stuinfo si = new Stuinfo(0, name, sex, xy, zhuangye, jiguang, aihao,
				phonenum, date);
		dao.addInfo(si);
		System.out.println("添加成功！");

	}

	/*
	 * 显示查询方式
	 */
	public void selectStu() {
		System.out.println("1.查询所有  2.条件查询");
		Scanner sc = new Scanner(System.in);
		int selectChoose = sc.nextInt();
		// 判断用户的选择，调用不同的功能
		switch (selectChoose) {
		case 1:
			// 查询所有
			selectAll();
			break;

		case 2:
			// 条件查询
			selectMenu();
			break;
		}
	}

	/*
	 * 条件查询 根据学号查询
	 */
	public void select2() {
		System.out.println("请输入学生学号");
		Scanner sc=new Scanner(System.in);
		int sid=sc.nextInt();
		List<Stuinfo> list=dao.selset2(sid);
		if (list.size() != 0) {
			print(list);
		} else {
			System.out.println("无该学生");
		}
		
	}

	/*
	 * 条件查询 根据姓名查询
	 */
	public void select3() {
		System.out.println("请输入学生姓名");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		List<Stuinfo> list=dao.selset3(name);
		if (list.size() != 0) {
			print(list);
		} else {
			System.out.println("无该学生");
		}
		
	}

	/*
	 * 条件查询 根据入学日期查询
	 */

	public void select1() {
		// System.out.println("选择日期查询");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入开始日期：");
		String startDate = sc.nextLine();
		System.out.print("请输入结束日期：");
		String endDate = sc.nextLine();
		List<Stuinfo> list = dao.select1(startDate, endDate);
		if (list.size() != 0) {
			print(list);
		} else {
			System.out.println("该时间段无数据！");
		}
	}

	/*
	 * 实现查询所有的账务数据
	 */
	public void selectAll() {
		// 调用控制层中的方法，查询所有的数据
		List<Stuinfo> list = dao.selectAll();
		print(list);
	}

	/*
	 * 条件查询菜单
	 */
	public void selectMenu() {
		System.out.println("请选择查询条件：1.按照入学日期查询   2.按照学号查询   3.按照姓名查询");
		Scanner sc = new Scanner(System.in);
		int selectChoose = sc.nextInt();
		switch (selectChoose) {
		case 1:
			// 入学日期查询
			select1();
			break;
		case 2:
			// 学号查询
			select2();
			break;
		case 3:
			// 姓名查询
			select3();
			break;
		}
	}

	/*
	 * 打印
	 */
	private void print(List<Stuinfo> list) {
		// 输出表头
		System.out.println("学号\t姓名\t性别\t学院\t\t专业\t籍贯\t爱好\t联系方式\t\t入学日期");
		for (Stuinfo stuinfo : list) {
			System.out.println(stuinfo.getSid() + "\t" + stuinfo.getName()
					+ "\t" + stuinfo.getSex() + "\t" + stuinfo.getXy() + "\t"
					+ stuinfo.getZhuangye() + "\t" + stuinfo.getJiguang()
					+ "\t" + stuinfo.getAihao() + "\t" + stuinfo.getPhonenum()
					+ "\t\t" + stuinfo.getDate());
		}
	}
}
