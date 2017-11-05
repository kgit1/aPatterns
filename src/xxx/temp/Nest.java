package xxx.temp;

public class Nest {
	
	private String name ="Nest";	
	
	
	public Nest(String name) {
		super();
		System.out.println(this.name);
		this.name = name;
		System.out.println(this.name);
	}


	public class InnerClass{
		
		private String name ="InTheNest";

		public InnerClass(String name) {
			super();
			System.out.println(this.name);
			this.name = name;
			System.out.println(this.name);
		}		
		
	}
	
	static class NestedClass{
		
		private String name = "StaticNest";

		public NestedClass(String name) {
			super();
			System.out.println(this.name);
			this.name = name;
			System.out.println(this.name);
		}		
		
	}

}
