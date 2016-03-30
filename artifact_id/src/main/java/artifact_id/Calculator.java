package team01.week04;
import java.util.Scanner;
import java.util.logging.*;


public class Calculator {
	String[] raw_type;
	private int grade, time, line;
	private final int SILVERGRADE = 2;
	private final int GOLDGRADE = 1;
	private final int GOLDOVERTIME = 1000;
	private final int SILEVEROVERTIME = 500;
	private final double GOLDORIGINALFEE = 49.95;
	private final double SILVERORIGIALFEE = 29.95;
	private	final int FAMILYDISCOUNT = 3;
	

	public double money() {
		if (grade == 1) {// gold
			return calLine() + calMinute();
		} else if (grade == 2) {// silver
			return calLine() + calMinute();
		}
		return 0;
	}

	public int addMinute() {
		int addMinute=0;
		if (grade == 1) { // gold
			addMinute= (time - this.GOLDOVERTIME >= 0 ? time - this.GOLDOVERTIME : -1);
		} else if (grade == 2) { // silver
			addMinute =(time - this.SILEVEROVERTIME >= 0 ? time - this.SILEVEROVERTIME : -1);
		} 
		return addMinute;
	}

	public double calMinute() {
		if (addMinute() == -1 && grade == this.GOLDGRADE) // gold, 珥덇낵�븯吏� �븡�쓬
			return this.GOLDORIGINALFEE;
		else if (addMinute() == -1 && grade == this.SILVERGRADE) // silver, 珥덇낵�븯吏� �븡�쓬
			return this.SILVERORIGIALFEE;
		else if (grade == this.GOLDGRADE) { // gold
			return this.GOLDORIGINALFEE + addMinute() * 0.45;
		} else if (grade == this.SILVERGRADE) {
			return this.SILVERORIGIALFEE + addMinute() * 0.54;
		} else {
			return -1;
		}
	}

	public int addLine() {
		if (line - this.FAMILYDISCOUNT < 0) {
			return -1;
		} else {
			return line - this.FAMILYDISCOUNT;
		}
	}

	public double calLine() {
		if (line == 1) {
			return 0;
		} else if (addLine() < 0 && grade == this.GOLDGRADE) { // gold 洹몃깷 異붽��슂湲�
			return 14.5 * (line - 1);
		} else if (addLine() < 0 && grade == this.SILVERGRADE) { // silver 洹몃깷 異붽��슂湲�
			return 21.5 * (line - 1);
		}
		if (addLine() >= 0 && grade == this.GOLDGRADE) { // gold & 媛�議깊븷�씤 0
			return 14.5 * 2 + addLine() * 5;
		}
		if (addLine() >= 0 && grade == this.SILVERGRADE) { // silver & 媛�議깊븷�씤 0
			return 21.5 * 2 + addLine() * 5;
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
