package callstack;

public class A {
	
	public A(int x) throws Exc1 {
		
		try{
			new B(x);
			
		} catch(Exc2 e) {
			System.out.println("A");
			
		} finally {
			System.out.println("finA");
		}
	}
}
