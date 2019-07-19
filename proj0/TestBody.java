public class TestBody{
	public static void main(String[] args) {
		Body body1 = new Body(1,1,0,0,13,"body1");
		Body body2 = new Body(6,13,0,0,17,"body2");
		System.out.println(body1.calcDistance(body2));
		System.out.println(body1.calcForceExertedBy(body2));
	}
}