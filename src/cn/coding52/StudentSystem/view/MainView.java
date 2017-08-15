package cn.coding52.StudentSystem.view;

import java.util.List;
import java.util.Scanner;

import cn.coding52.StudentSystem.dao.StuDao;
import cn.coding52.StudentSystem.domain.Stuinfo;

/*
 * ��ͼ��
 * ���ݴ��ݸ�controller��
 */
public class MainView {
	private StuDao dao = new StuDao();

	/*
	 * ʵ�ֽ���Ч�� ����ʵʱ����
	 */
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("---------------ѧ����Ϣ����ϵͳ---------------");
			System.out.println("1.���ѧ����Ϣ��2.�༭ѧ����Ϣ��3.ɾ��ѧ����Ϣ��4.��ѯѧ����Ϣ��5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			// ����ѡ��Ĳ˵�
			int choose = sc.nextInt();

			switch (choose) {
			case 1:
				// �����Ϣ
				addInfo();
				break;
			case 2:
				// �༭��Ϣ�����ñ༭��Ϣ�ķ���
				editInfo();
				break;
			case 3:
				// ɾ����Ϣ
				delInfo();
				break;
			case 4:
				// ��ѯ��Ϣ
				selectStu();
				break;
			case 5:
				System.exit(0);
			}

		}
	}

	/*
	 * ɾ��ѧ����Ϣ
	 */
	private void delInfo() {
		selectAll();
		System.out.println("������Ҫɾ����ѧ��ѧ��");
		Scanner sc=new Scanner(System.in);
		int sid=sc.nextInt();
		dao.delInfo(sid);
		System.out.println("ɾ���ɹ���");

	}

	/*
	 * �༭ѧ����Ϣ
	 */
	public void editInfo() {
		selectAll();
		System.out.println("��ѡ��Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		int sid = sc.nextInt();
		System.out.println("������ѧ������:");
		String name = sc.next();
		System.out.println("������ѧ���Ա�");
		String sex = sc.next();
		System.out.println("������ѧ��Ժϵ��");
		String xy = sc.next();
		System.out.println("������ѧ��רҵ��");
		String zhuangye = sc.next();
		System.out.println("������ѧ�����᣺");
		String jiguang = sc.next();
		System.out.println("������ѧ�����ã�");
		String aihao = sc.next();
		System.out.println("������ѧ����ϵ��ʽ��");
		String phonenum = sc.next();
		System.out.println("��������ѧ���ڣ�");
		String date = sc.next();
		// �������û����������
		Stuinfo si = new Stuinfo(sid, name, sex, xy, zhuangye, jiguang, aihao,
				phonenum, date);
		// ���÷���
		dao.editInfo(si);
		System.out.println("�޸ĳɹ�");
	}

	/*
	 * ���ѧ����Ϣ �����û���������ݣ�8�� ��ȥ������
	 */
	public void addInfo() {
		System.out.println("��ѡ��������ѧ����Ϣ�Ĺ���");
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ������:");
		String name = sc.next();
		System.out.println("������ѧ���Ա�");
		String sex = sc.next();
		System.out.println("������ѧ��Ժϵ��");
		String xy = sc.next();
		System.out.println("������ѧ��רҵ��");
		String zhuangye = sc.next();
		System.out.println("������ѧ�����᣺");
		String jiguang = sc.next();
		System.out.println("������ѧ�����ã�");
		String aihao = sc.next();
		System.out.println("������ѧ����ϵ��ʽ��");
		String phonenum = sc.next();
		System.out.println("��������ѧ���ڣ�");
		String date = sc.next();
		Stuinfo si = new Stuinfo(0, name, sex, xy, zhuangye, jiguang, aihao,
				phonenum, date);
		dao.addInfo(si);
		System.out.println("��ӳɹ���");

	}

	/*
	 * ��ʾ��ѯ��ʽ
	 */
	public void selectStu() {
		System.out.println("1.��ѯ����  2.������ѯ");
		Scanner sc = new Scanner(System.in);
		int selectChoose = sc.nextInt();
		// �ж��û���ѡ�񣬵��ò�ͬ�Ĺ���
		switch (selectChoose) {
		case 1:
			// ��ѯ����
			selectAll();
			break;

		case 2:
			// ������ѯ
			selectMenu();
			break;
		}
	}

	/*
	 * ������ѯ ����ѧ�Ų�ѯ
	 */
	public void select2() {
		System.out.println("������ѧ��ѧ��");
		Scanner sc=new Scanner(System.in);
		int sid=sc.nextInt();
		List<Stuinfo> list=dao.selset2(sid);
		if (list.size() != 0) {
			print(list);
		} else {
			System.out.println("�޸�ѧ��");
		}
		
	}

	/*
	 * ������ѯ ����������ѯ
	 */
	public void select3() {
		System.out.println("������ѧ������");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		List<Stuinfo> list=dao.selset3(name);
		if (list.size() != 0) {
			print(list);
		} else {
			System.out.println("�޸�ѧ��");
		}
		
	}

	/*
	 * ������ѯ ������ѧ���ڲ�ѯ
	 */

	public void select1() {
		// System.out.println("ѡ�����ڲ�ѯ");
		Scanner sc = new Scanner(System.in);
		System.out.print("�����뿪ʼ���ڣ�");
		String startDate = sc.nextLine();
		System.out.print("������������ڣ�");
		String endDate = sc.nextLine();
		List<Stuinfo> list = dao.select1(startDate, endDate);
		if (list.size() != 0) {
			print(list);
		} else {
			System.out.println("��ʱ��������ݣ�");
		}
	}

	/*
	 * ʵ�ֲ�ѯ���е���������
	 */
	public void selectAll() {
		// ���ÿ��Ʋ��еķ�������ѯ���е�����
		List<Stuinfo> list = dao.selectAll();
		print(list);
	}

	/*
	 * ������ѯ�˵�
	 */
	public void selectMenu() {
		System.out.println("��ѡ���ѯ������1.������ѧ���ڲ�ѯ   2.����ѧ�Ų�ѯ   3.����������ѯ");
		Scanner sc = new Scanner(System.in);
		int selectChoose = sc.nextInt();
		switch (selectChoose) {
		case 1:
			// ��ѧ���ڲ�ѯ
			select1();
			break;
		case 2:
			// ѧ�Ų�ѯ
			select2();
			break;
		case 3:
			// ������ѯ
			select3();
			break;
		}
	}

	/*
	 * ��ӡ
	 */
	private void print(List<Stuinfo> list) {
		// �����ͷ
		System.out.println("ѧ��\t����\t�Ա�\tѧԺ\t\tרҵ\t����\t����\t��ϵ��ʽ\t\t��ѧ����");
		for (Stuinfo stuinfo : list) {
			System.out.println(stuinfo.getSid() + "\t" + stuinfo.getName()
					+ "\t" + stuinfo.getSex() + "\t" + stuinfo.getXy() + "\t"
					+ stuinfo.getZhuangye() + "\t" + stuinfo.getJiguang()
					+ "\t" + stuinfo.getAihao() + "\t" + stuinfo.getPhonenum()
					+ "\t\t" + stuinfo.getDate());
		}
	}
}
