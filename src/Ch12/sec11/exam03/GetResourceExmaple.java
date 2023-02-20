package Ch12.sec11.exam03;

public class GetResourceExmaple {
	public static void main(String[] args) {
		Class clazz = Car.class;
		
		String photo1Path = clazz.getResource("photo1.jpg").getPath();
		String photo2Path = clazz.getResource("images/photo2.jpg").getPath();
	
		System.out.println(photo1Path); ///F:/study/workspace/JavaPrj/bin/Ch12/sec11/exam03/photo1.jpg
		System.out.println(photo2Path); ///F:/study/workspace/JavaPrj/bin/Ch12/sec11/exam03/images/photo2.jpg

	}
}
