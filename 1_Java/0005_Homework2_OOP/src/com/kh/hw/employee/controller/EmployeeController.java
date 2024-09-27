package com.kh.hw.employee.controller;

import com.kh.hw.employee.model.vo.Employee;

public class EmployeeController {

	private Employee[] e = new Employee[10000]; 	// 10000���� ����������� ���� ����
													// �߰����� �ʿ�� ���Ƿ� ����

	public void add(int empNo, String name, char gender, String phone) {
		
		e[empNo] = new Employee(empNo, name, gender, phone);
		// �޾ƿ� �Ű������� �̿��Ͽ� �ش� ���� ����
		
	}

	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {

		e[empNo] = new Employee(empNo, name, gender, phone, dept, salary, bonus);
		// �޾ƿ� �Ű������� �̿��Ͽ� �ش� ���� ����

	}

	public void modify(int empNo, String phone) {
		e[empNo].setPhone(phone);
	}

	public void modify(int empNo, int salary) {
		e[empNo].setSalary(salary);
	}

	public void modify(int empNo, double bonus) {
		e[empNo].setBonus(bonus);
	}

	public Employee remove(int empNo) {

		e[empNo] = null;
		// ��ü e�� null�� �����Ͽ� ��ü ����

		return e[empNo];
	}

	public String inform(int empNo) { // ������� ���

		if (e[empNo] == null) {
			return null;
		}

		return e[empNo].printEmployee();

	}

	public Employee[] getE() {
		return e;
	}

	public void setE(Employee[] e) {
		this.e = e;
	}

}
