package com.ticket.entites;

import java.io.Serializable;

/**
 * �û���Ϣ��
 * 
 * @author Administrator
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// �û�id
	private Integer user_id;
	// �û���
	private String user_name;
	// �û�����
	private String user_pwd;
	// �绰
	private String user_phone;
	// ����
	private String user_email;
	// ��ַ
	private String user_address;

	private Integer admin_flag;

	public User() {
		super();
	}

	public User(String user_name, String user_pwd, String user_phone,
			String user_email, String user_address, Integer admin_flag) {
		super();
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_address = user_address;
		this.admin_flag = admin_flag;
	}

	public User(Integer user_id, String user_name, String user_pwd,
			String user_phone, String user_email, String user_address,
			Integer admin_flag) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_address = user_address;
		this.admin_flag = admin_flag;
	}

	public Integer getAdmin_flag() {
		return admin_flag;
	}

	public void setAdmin_flag(Integer admin_flag) {
		this.admin_flag = admin_flag;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name
				+ ", user_pwd=" + user_pwd + ", user_phone=" + user_phone
				+ ", user_email=" + user_email + ", user_address="
				+ user_address + "]";
	}

}
