package etihad;

public class Test1 {
	
	static int s;

	public static void main(String[] args) {
		Test1 product = new Test1();
		product.start();
		System.out.println(s);

	}
	void start(){
		int x=7;
		twice(x);
		System.out.println(x+"");
	}
	void twice(int x){
		x=x*2;
		s=x;
	}
	
	

}
