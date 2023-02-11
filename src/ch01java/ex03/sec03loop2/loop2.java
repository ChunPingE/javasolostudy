package ch01java.ex03.sec03loop2;

public class loop2 {

	public static void main(String[] args) {

		/*
		for (int i = 1; i <= 5; i++) {
			if(i%2 ==0) {
				System.out.printf("%c,", ' ');
			} else if(i==5) {
				System.out.printf("%c", 'A'+i-1);
			} else {
				System.out.printf("%c,", 'A'+i-1);
			}	
			

		}
		
		for (int i = 0; i < 5; i++) {
			if(i%2 ==1) {
				System.out.printf("%c,", ' ');
			} else if(i==4) {
				System.out.printf("%c", 'A'+i);
			} else {
				System.out.printf("%c,", 'A'+i);
			}	
		}
		*/
		
		for (int i = 0; i < 5; i++) {
			if (i==4) {
				System.out.printf("%c", 'A'+i);
			} else if(i % 2 == 0) {
				System.out.printf("%c", ' ');
			} else {
				System.out.printf("%c,", 'A'+i);
			}	
		}

	}

}
