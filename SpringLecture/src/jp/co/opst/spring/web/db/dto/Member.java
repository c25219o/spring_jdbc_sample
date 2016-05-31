package jp.co.opst.spring.web.db.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Member {


	private String memNum;
	private String fstName;
	private String lstName;
	private String sex;
	private String mailAddr;
	private String addr1;
	private String addr2;
	private String addr3;
	private Date regDate;
	private Date lstUpdateTime;
	private String phoneNum;
	private int age;

	/**
	 * @return the memNum
	 */
	public String getMemNum() {
		return memNum;
	}
	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	/**
	 * @return the fstName
	 */
	public String getFstName() {
		return fstName;
	}
	/**
	 * @param fstName the fstName to set
	 */
	public void setFstName(String fstName) {
		this.fstName = fstName;
	}
	/**
	 * @return the lstName
	 */
	public String getLstName() {
		return lstName;
	}
	/**
	 * @param lstName the lstName to set
	 */
	public void setLstName(String lstName) {
		this.lstName = lstName;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the mailAddr
	 */
	public String getMailAddr() {
		return mailAddr;
	}
	/**
	 * @param mailAddr the mailAddr to set
	 */
	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}
	/**
	 * @return the addr1
	 */
	public String getAddr1() {
		return addr1;
	}
	/**
	 * @param addr1 the addr1 to set
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	/**
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}
	/**
	 * @param addr2 the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	/**
	 * @return the addr3
	 */
	public String getAddr3() {
		return addr3;
	}
	/**
	 * @param addr3 the addr3 to set
	 */
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	/**
	 * @return the lstUpdateTime
	 */
	public Date getLstUpdateTime() {
		return lstUpdateTime;
	}
	/**
	 * @param lstUpdateTime the lstUpdateTime to set
	 */
	public void setLstUpdateTime(Date lstUpdateTime) {
		this.lstUpdateTime = lstUpdateTime;
	}
	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
