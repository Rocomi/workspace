package com.kh.hw.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.controller.EmployeeController;

public class EmployeeMenu {

	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();

	public EmployeeMenu() {
		System.out.println("������� �ý��� �Դϴ�.");
		System.out.println("");
		
		while(true) {
		
			System.out.println("1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("3. ��� ����");
			System.out.println("4. ��� ���"); // ������ �����ȣ�� �������
			System.out.println("5. ��ü ��� ���"); // ��� ��ȣ������ ��ü ��� ���
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ�� �������� : ");
			int menuNum = sc.nextInt();
			sc.nextLine();
			System.out.println("");
			
			switch(menuNum) {
			case 1 : 
				insertEmp();
				break;
			case 2 : 
				updateEmp();
				break;
			case 3 : 
				deleteEmp();
				break;
			case 4 : 
				System.out.print("����� ��� ��ȣ�� �Է��ϼ��� : "); // ������ �����ȣ�� ���
				int empNo = sc.nextInt();
				sc.nextLine();
				printEmp(empNo);
				break;
			case 5 : 
				printEmp();
				break;
			case 9 : 
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default : 
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("");
				break;
				
			}
		}

	}

	public void insertEmp() {	
		
		System.out.print("��� ��ȣ : ");
		int empNo = sc.nextInt();
		sc.nextLine();
		
		if (ec.inform(empNo) != null ) {
			System.out.print("�����ȣ�� �̹� �����մϴ�. ���� ���ðڽðڽ��ϱ�? (y/n) : ");
			// �ߺ��� �����ȣ �Է½� ������ ����� ���, Ȥ�� ���ο� �����ȣ �Է�
			char yn = sc.nextLine().charAt(0);
			if (yn != 'y' && yn != 'Y') {
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				System.out.println("");
				return;
			}
			else {
				System.out.println("��������� ����ϴ�.");
			}
		}
		//	--> �����Ͱ� �ִ� �����ȣ�� ��� "�����ȣ�� �̹� �����մϴ�. ���� �����͸� ���� ���ðڽ��ϱ�?"  ���
		// ���� ������ ���� �����
		
		System.out.print("��� �̸� : ");
		String name = sc.nextLine();
		System.out.print("��� ���� : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("��ȭ ��ȣ : ");
		String phone = sc.nextLine();
		
		System.out.print("�߰� ������ �� �Է��Ͻðڽ��ϱ�? (y/n) : ");
		char yn = sc.nextLine().charAt(0);
		if (yn == 'y' || yn == 'Y') {
			
			System.out.print("��� �μ� : ");
			String dept = sc.nextLine();
			System.out.print("��� ���� : ");
			int salary = sc.nextInt();
			System.out.print("���ʽ� �� : ");
			double bonus = sc.nextDouble();
			
			ec.add(empNo, name, gender, phone, dept, salary, bonus);
			System.out.println("��� ��� �Ϸ�.");
			System.out.println("");
			
		}
		else {
			ec.add(empNo, name, gender, phone);
			System.out.println("��� ��� �Ϸ�.");
			System.out.println("");
		}

	}

	public void updateEmp() {
		 
		// ������ �����ȣ �Է� --> �ش� �����ȣ�� ������ ����
		System.out.print("������ ��� ��ȣ�� �Է��ϼ��� : ");
		int empNo = sc.nextInt();
		
		System.out.println("�ش� ��� ��ȣ�� ������ �����ϰ� �˴ϴ�.");
		System.out.println("����� � ������ �����Ͻðڽ��ϱ�?");
		System.out.println("1. ��ȭ ��ȣ");
		System.out.println("2. ��� ����");
		System.out.println("3. ���ʽ� ��");
		System.out.println("9. ���ư���");
		System.out.print("�޴� ��ȣ�� �������� : ");
		int menuNum = sc.nextInt(); 
		
		switch (menuNum) {
		case 1 : 
			System.out.print("������ ��ȭ ��ȣ :");
			String phone = sc.nextLine();
			ec.modify(empNo, phone);
			System.out.println("");
			break;
		case 2 : 
			System.out.print("������ ��� ���� :");
			int salary = sc.nextInt();
			sc.nextLine();
			ec.modify(empNo, salary);
			System.out.println("");
			break;
		case 3 : 
			System.out.print("������ ���ʽ� �� :");
			double bonus = sc.nextDouble();
			ec.modify(empNo, bonus);
			System.out.println("");
			break;
		case 9 :
			System.out.println("�������� ���ư��ϴ�.");
			System.out.println("");
			return;
		default : 
			System.out.println("�߸��� �޴���ȣ�Դϴ�. �������� ���ư��ϴ�.");
			System.out.println("");
			return;
				
		}

	

	}

	public void deleteEmp() {
		
		// ������ �����ȣ �Է�
		System.out.print("������ ��� ��ȣ�� �Է��ϼ��� : ");
		int empNo = sc.nextInt();
		sc.nextLine();
		
		System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
		char yn = sc.nextLine().charAt(0);
		if (yn == 'y' || yn =='Y') {
			 if(ec.remove(empNo) == null) {
				 System.out.println("������ ������ �����Ͽ����ϴ�.");
				 System.out.println("");
			 }else {
				 System.out.println("������ ������ �����Ͽ����ϴ�.");
				 System.out.println("");
			 }
			
		}else {
			System.out.println("�������� ���ư��ϴ�.");
			System.out.println("");
			return;
		}
		
	}

	public void printEmp(int empNo) {  // Ư�� ����� ����� �� �ֵ��� �޼ҵ� �����ε� 
		
		if (ec.inform(empNo) == null){
			System.out.println("��� �����Ͱ� �����ϴ�.");
			System.out.println("");
		}else {
			System.out.println(ec.inform(empNo));
			System.out.println("");
		}
		
		// �ش� �����ȣ�� ��������� �ִٸ� ������� ���, ���ٸ� ����� �����Ͱ� �����ϴ١����

	}

	public void printEmp() {
		
		for(int i = 0; i < ec.getE().length; i++) {
			if (ec.inform(i) == null){
				continue;
			}else {
				System.out.println(ec.inform(i));
			}
		}
		//	��ü ��������� ���, �����Ͱ� ���� ��� ������� ����
		System.out.println("");
	}
}
