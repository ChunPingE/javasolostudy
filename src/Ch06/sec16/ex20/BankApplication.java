package Ch06.sec16.ex20;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];

	public static void main(String[] args) {

		while (true) {

			int menu = mainmenu();

			switch (menu) {
			case 1:
				createAccount();
				break;
			case 2:
				AccountList();
				break;
			case 3:
				depoist();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				quit();
				break;
			}
		}
	}

	public static int mainmenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("--------------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
		System.out.println("--------------------------------------------------");
		System.out.print("선택> ");
		int menu = Integer.parseInt(sc.nextLine());

		return menu;
	}

	public static void createAccount() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");
		
		System.out.print("계좌번호: ");
		String ano = sc.nextLine();
		
		System.out.print("계좌주: ");
		String owner = sc.nextLine();
		
		System.out.print("초기입금액: ");
		int balance = Integer.parseInt(sc.nextLine());
		
		Account newAccount = new Account(ano, owner, balance);
		for (int i = 0; i < accountArray.length ; i++) {
			if(accountArray[i] == null) {
				 accountArray[i] = newAccount;
				 System.out.println("결과: 계좌가 생성되었습니다.");
				 break;
			}
		}
	}

	public static void AccountList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");
		for (int i = 0; i < accountArray.length; i++) {
			Account account = accountArray[i];
			if (account != null) {
				String ano = account.getAno();
				String owner = account.getOwner();
				int balance = account.getBalance();
				System.out.printf("%s     %s     %d\n", ano, owner, balance);
			}
		}
	}

	public static void depoist() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------");
		System.out.println("예금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String ano = sc.nextLine();
		System.out.print("예금액: ");
		int balance = Integer.parseInt(sc.nextLine());
		
		Account account = findAno(ano);
		if (account == null) {
			System.out.println("계좌가 없습니다.");
			return;
		} else {
			account.setBalance(account.getBalance() + balance);
			System.out.println("예금되었습니다.");
		}
	}
	
	public static void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String ano = sc.nextLine();
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = findAno(ano);
		if (account == null) {
			System.out.println("계좌가 없습니다.");
			return;
		} else {
			int balance = account.getBalance() - money;
			if( balance < 0) {
				System.out.println("잔액이 부족합니다.");
				return;
			} else {
				account.setBalance(balance);
				System.out.println("출금되었습니다.");
			}
		}
	}
	public static void quit() {
		System.out.println("프로그램 종료");
		System.exit(0);
	}
	
	public static Account findAno(String ano) {
		Account account = null;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				String dbAno = accountArray[i].getAno();
				if (dbAno.equals(ano)) {
					account = accountArray[i];
					break;
				}
			}
		}
		return account;
	}
}
