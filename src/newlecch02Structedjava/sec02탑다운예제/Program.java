package newlecch02Structedjava.sec02탑다운예제;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		int[][] lottos = null;
		int menu;
		boolean running = true;
		
		menu = inputMenu();
		while (running) {
			switch (menu) {
			case 1:
				lottos = createLottotsAuto();
				break;
			case 2:
				lottos = createLottotsManual();
				break;
			case 3:
				printLottos(lottos);
				break;
			case 4:
				running = false;
				break;
			default:
				break;
			}	
		}
	

	}

	private static int inputMenu() {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│         메인메뉴          │");
		System.out.println("└───────────────────────────┘");
		
		return 0;
	}

	private static int[][] createLottotsAuto() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[][] createLottotsManual() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void printLottos(int[][] lottos) {
		// TODO Auto-generated method stub
		
	}

}