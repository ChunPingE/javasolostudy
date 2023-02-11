package ch01java.ex02.sec13.continue_break;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int n = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("값을 sp로 구분해서 5개 이상 입력하세요:");

		// 34 5 6 234 이런식으로하면 스페이스를 구분자로해서 하나만 읽음.
		// 입력버퍼가 잇어서 다음것 5가 들어가게 됨.
		while (sc.hasNext()) {
			n = sc.nextInt();
			if (n < 10) {
				continue;
			}
			if (n > 200) {
				break;
			}
			System.out.println(n);

		}

	}

}
