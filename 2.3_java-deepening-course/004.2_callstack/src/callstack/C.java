package callstack;

public class C  {

	public C(int x) throws Exc1,  Exc2 , Exc3{
		try {
			if(x==1){
				throw new  Exc1("F.");
			} else if(x==2) {
				throw new Exc2();
			} else if(x==3) {
				throw new Exc3();
			} else {
				throw new Exc4();
			}
		} catch(Exc4 e) {
			System.out.println("C");
		}
	}

}
