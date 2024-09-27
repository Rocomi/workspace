package com.kh.wonPick.model;

public class Member {
	
	private String userId;
	private String userPw;
	private String userName;
	private String nickName;
	private String email;
	private String phone;
	private String gender;
	private String birth;
	private String introduce;
	private String pImg;
	
	public Member() {
		super();
	}
	
	public Member(String userId, String userPw, String userName, String nickName, String email, String phone,
			String gender, String birth, String introduce, String pImg) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.birth = birth;
		this.introduce = introduce;
		this.pImg = pImg;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", nickName=" + nickName
				+ ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", birth=" + birth + ", introduce="
				+ introduce + ", pImg=" + pImg + "]";
	}

}
