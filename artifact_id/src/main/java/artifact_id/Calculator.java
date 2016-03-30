package team01.week04;
import java.util.Scanner;
import java.util.logging.*;


public class Calculator {
	String[] raw_type;
	private int grade, time, line;
	private final int silverGrade = 2;
	private final int goldGrade = 1;
	private final int goldOverTime = 1000;
	private final int silverOverTime = 500;
	private final double goldOriginalFee = 49.95;
	private final double silverOriginalFee = 29.95;
	private	final int familyDiscount = 3;
	

	public double money() {
		if (grade == 1) {// gold
			return cal_line() + cal_minute();
		} else if (grade == 2) {// silver
			return cal_line() + cal_minute();
		}
		return 0;
	}

	public int add_minute() {
		int addMinute=0;
		if (grade == 1) { // gold
			addMinute= (time - this.goldOverTime >= 0 ? time - this.goldOverTime : -1);
		} else if (grade == 2) { // silver
			addMinute =(time - this.silverOverTime >= 0 ? time - this.silverOverTime : -1);
		} 
		return addMinute;
	}

	public double cal_minute() {
		if (add_minute() == -1 && grade == goldGrade) // gold, 珥덇낵�븯吏� �븡�쓬
			return this.goldOriginalFee;
		else if (add_minute() == -1 && grade == silverGrade) // silver, 珥덇낵�븯吏� �븡�쓬
			return this.silverOriginalFee;
		else if (grade == goldGrade) { // gold
			return this.goldOriginalFee + add_minute() * 0.45;
		} else if (grade == silverGrade) {
			return this.silverOriginalFee + add_minute() * 0.54;
		} else {
			return -1;
		}
	}

	public int add_line() {
		if (line - this.familyDiscount < 0) {
			return -1;
		} else {
			return line - this.familyDiscount;
		}
	}

	public double cal_line() {
		if (line == 1) {
			return 0;
		} else if (add_line() < 0 && grade == this.goldGrade) { // gold 洹몃깷 異붽��슂湲�
			return 14.5 * (line - 1);
		} else if (add_line() < 0 && grade == this.silverGrade) { // silver 洹몃깷 異붽��슂湲�
			return 21.5 * (line - 1);
		}
		if (add_line() >= 0 && grade == this.goldGrade) { // gold & 媛�議깊븷�씤 0
			return 14.5 * 2 + add_line() * 5;
		}
		if (add_line() >= 0 && grade == this.silverGrade) { // silver & 媛�議깊븷�씤 0
			return 21.5 * 2 + add_line() * 5;
		} else {
			return -1;
		}
	}

	public String result() {
		if (money() == 0)
			return "�옒紐삳맂 媛믪쓣 �엯�젰�븯�뀲�뒿�땲�떎.";
		else {
			String str = String.format("%.2f", money());
			return "湲덉븸�� $" + str + " �엯�땲�떎.";
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
			System.out.print("등급을 입력하세요: Gold(1), Silver(2) : ");
			cal.grade = gradesc.nextInt();
			System.out.print("통화시간을 적어주세요(분) : ");
			cal.time = timesc.nextInt();
			System.out.print("회선 개수를 적어주세요 : ");
			cal.line = linesc.nextInt();
			System.out.println(cal.result());
			System.out.print("계속 진행하시겠습니까?(y/n) : ");
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
