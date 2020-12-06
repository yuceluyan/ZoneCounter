package yuceluyan;

public class ZoneCounter {

	public static void main(String[] args) throws Exception {
		
		MapBusiness mb=new MapBusiness();
		MapOperations mo = new MapOperations();
		mo.Init(mb);
		System.out.println("Zone Count: "+mo.Solve());
	}

}
