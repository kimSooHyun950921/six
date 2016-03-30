package artifact_id;

import java.util.Scanner;

public class Calculator {
	String[] raw_type;
	int grade, time, line;

	public double money() {
		if (grade == 1) {// gold
			return cal_line() + cal_minute();
		} else if (grade == 2) {// silver
			return cal_line() + cal_minute();
		}
		return 0;
	}

	public int add_minute() {
		if (grade == 1) { // gold
			return (time - 1000 >= 0 ? time - 1000 : -1);
		} else if (grade == 2) { // silver
			return (time - 500 >= 0 ? time - 500 : -1);
		} else {
			return -100;
		}
	}

	public double cal_minute() {
		if (add_minute() == -1 && grade == 1) // gold, �ʰ����� ����
			return 49.95;
		else if (add_minute() == -1 && grade == 2) // silver, �ʰ����� ����
			return 29.95;
		else if (grade == 1) { // gold
			return 49.95 + add_minute() * 0.45;
		} else if (grade == 2) {
			return 29.95 + add_minute() * 0.54;
		} else {
			return -1;
		}
	}

	public int add_line() {
		if (line - 3 < 0) {
			return -1;
		} else {
			return line - 3;
		}
	}

	public double cal_line() {
		if (line == 1) {
			return 0;
		} else if (add_line() < 0 && grade == 1) { // gold �׳� �߰����
			return 14.5 * (line - 1);
		} else if (add_line() < 0 && grade == 2) { // silver �׳� �߰����
			return 21.5 * (line - 1);
		}
		if (add_line() >= 0 && grade == 1) { // gold & �������� 0
			return 14.5 * 2 + add_line() * 5;
		}
		if (add_line() >= 0 && grade == 2) { // silver & �������� 0
			return 21.5 * 2 + add_line() * 5;
		} else {
			return -1;
		}
	}

	public String result() {
		if (money() == 0)
			return "�߸��� ���� �Է��ϼ̽��ϴ�.";
		else {
			String str = String.format("%.2f", money());
			return "�ݾ��� $" + str + " �Դϴ�.";
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		while (true) {
			Calculator cal = new Calculator();
			Scanner gradesc = new Scanner(System.in);
			Scanner timesc = new Scanner(System.in);
			Scanner linesc = new Scanner(System.in);
			Scanner yn = new Scanner(System.in);
			String question;
			System.out.print("����� �Է��ϼ��� : Gold(1), Silver(2) : ");
			cal.grade = gradesc.nextInt();
			System.out.print("��ȭ �ð��� �����ּ���(��) : ");
			cal.time = timesc.nextInt();
			System.out.print("ȸ�� ������ �����ּ��� : ");
			cal.line = linesc.nextInt();
			System.out.println(cal.result());
			System.out.print("��� �����Ͻðڽ��ϱ�?(y/n) : ");
			question = yn.next();
			if (question.equals("n")) {
				break;
			} else {
				System.out.println();
				continue;
			}
		}
	}
}
