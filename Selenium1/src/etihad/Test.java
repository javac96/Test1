package etihad;

import java.util.Scanner;

import org.openqa.selenium.interactions.Keyboard;

public class Test {

	public static void main(String[] args) {
		/*
		int a_ = 017; 
		int a =1, b=2;
		// int c= ++a+b+++a++;
		 System.out.println(++a);
		 System.out.println(b++);
		 System.out.println(a++);
		String st = (2016%4)==0 ? "leap year":"year";//ternery operator
		
		//System.out.println(c);
		System.out.println(a_);


		int a=1;
		int b =1;
		if(!(true)&& (a++<5)||(b++<-15))
			a+=1;
		b=a;
		if(!(10>12))
			a+=10;
		b=a;
		if(!(a>1)&&((b*=2)>3))
			a+=200;
		System.out.println("a="+a+"b="+b);
		
		if(!true || !false)
			System.out.println(true);
		else
			System.out.println(false);
		//infinitely
		int s= 5;
		short p = 10;
		long l = 566;
		double d = 3.4;
		float x =  2.03f;
		System.out.println(x/0);
		
		//infinite loop
		int cnt = 1;
		while(cnt<=25){
			System.out.println(cnt);
			cnt--;
		}
		System.out.println("Done");
		
		
		int x = 700;
		double y = 700.1;
		int b = (x=(int) y);
		System.out.println(b);
			*/
		int i=4, j=2;
		int a =leftshift(i,j);
		System.out.println(a);
		
		}
	public static int leftshift(int i, int j){
		return i<<=j;
	}

}
