package cn.coding52.StudentSystem.domain;

public class Stuinfo {
	 private int sid;
	 private String name;
	 private String sex;
	 private String xy;
	 private String zhuangye;
	 private String jiguang;
	 private String aihao;
	 private String phonenum;
	 private String date;
	 
	public Stuinfo(int sid, String name, String sex, String xy,
			String zhuangye, String jiguang, String aihao, String phonenum,
			String date) {
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.xy = xy;
		this.zhuangye = zhuangye;
		this.jiguang = jiguang;
		this.aihao = aihao;
		this.phonenum = phonenum;
		this.date = date;
	}
	
	public Stuinfo() {
	
	}

	@Override
	public String toString() {
		return "Stuinfo [sid=" + sid + ", name=" + name + ", sex=" + sex
				+ ", xy=" + xy + ", zhuangye=" + zhuangye + ", jiguang="
				+ jiguang + ", aihao=" + aihao + ", phonenum=" + phonenum
				+ ", date=" + date + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getXy() {
		return xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public String getZhuangye() {
		return zhuangye;
	}

	public void setZhuangye(String zhuangye) {
		this.zhuangye = zhuangye;
	}

	public String getJiguang() {
		return jiguang;
	}

	public void setJiguang(String jiguang) {
		this.jiguang = jiguang;
	}

	public String getAihao() {
		return aihao;
	}

	public void setAihao(String aihao) {
		this.aihao = aihao;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	} 
}
