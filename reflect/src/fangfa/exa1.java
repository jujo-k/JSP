package fangfa;

import java.lang.reflect.Method;

public class exa1 {
	public static void main(String[] args) {
		
		try {
			//获取一个方法 首先获取类的信心就是类类型
			A a1 = new A();
			Class c = a1.getClass();
			
			//2.获取方法
			Method m =c.getDeclaredMethod("print", int.class,int.class);
			//方法的反射操作
			//a1.print(10.20);
			//方法如果没有返回值返回null,如果有就是具体的返回值
			Object o = m.invoke(a1,10,20);
			System.out.println("=================");
			//1.获取类对象的类类型
			
			//2.获取方法
			Method m1 = c.getMethod("print", String.class,String.class);
			//进行反射操作
			//a1.print("hello","world")
			o = m1.invoke(a1, "SDF","adsf");
			
			
			//1.获取方法对象的类类型
			//2.获取方法
			Method m2 = c.getMethod("print");
			//3.方法操作对象
			Object o2 = m2.invoke(a1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class A{
	public void print() {
		System.out.println("helloworld");
	}
	public void print(int a , int b) {
		System.out.println(a+b);
	}
	public void print(String a , String b) {
		System.out.println(a.toLowerCase()+" "+b.toUpperCase());
	}
	
}