package Ch12.sec09;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
	public static void main(String[] args) {
		Date now = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(now)); //2023-02-20

		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf.format(now)); //2023년 02월 20일

		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println(sdf.format(now)); //2023.02.20 오후 15:12:38

		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println(sdf.format(now)); //오늘은 월요일

		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println(sdf.format(now)); //올해의 51번째 날

		sdf = new SimpleDateFormat("이달의 d번째 날");
		System.out.println(sdf.format(now)); //이달의 20번째 날
	}
}
