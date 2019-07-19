public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName; 
	public static double G = 6.67e-11;

	public Body(double xP,double yP,double xV,
		double yV,double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		double item1 = Math.pow((this.xxPos-b.xxPos),2);
		double item2 = Math.pow((this.yyPos-b.yyPos),2);
		return Math.sqrt(item1+item2);
	}

	public double calcForceExertedBy(Body b) {
		return Body.G*b.mass*this.mass/(Math.pow(this.calcDistance(b),2));
	}

	public double calcForceExertedByX(Body b) {
		double distance = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);

		return force*(b.xxPos-this.xxPos)/distance; 
	}

	public double calcForceExertedByY(Body b) {
		double distance = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);

		return force*(b.yyPos-this.yyPos)/distance; 
	}

	public double calcNetForceExertedByX(Body[] allBodys) {
		double sum_dis=0;
		for(Body b : allBodys) {
			if (this.equals(b)) continue;
			else {
				sum_dis+=this.calcForceExertedByX(b);
			}
		}
		return sum_dis;
	}

	public double calcNetForceExertedByY(Body[] allBodys) {
		double sum_dis=0;
		for(Body b : allBodys) {
			if (this.equals(b)) continue;
			else {
				sum_dis+=this.calcForceExertedByY(b);
			}
		}
		return sum_dis;
	}

	public void update(double dt,double fX,double fY) {
		double xxa = fX/this.mass;
		double yya = fY/this.mass;

		this.xxVel+=xxa*dt;
		this.yyVel+=yya*dt;

		this.xxPos+=xxVel*dt;
		this.yyPos+=yyVel*dt;
	}

	public void draw() {
		String location = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, location);
	}
}