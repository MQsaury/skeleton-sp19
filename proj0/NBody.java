public class NBody {
	public static double readRadius(String file_location) {
		In in = new In(file_location);

		int first_item = in.readInt();
		double second_item = in.readDouble();
		return second_item;
	}

	public static Body[] readBodies(String file_location) {
		In in = new In(file_location);
		int Num_planets = in.readInt();
		double radius = in.readDouble();
		Body[] Body_list = new Body[Num_planets];
		double Planet_property[] = new double[5];
		String last_prop="";

		for (int count = 0; count<Num_planets;count++) {
			for (int i =0;i<6;i++) {
				if (i!=5) {
					Planet_property[i] = in.readDouble();
				} else {
					last_prop = in.readString();
				}
			}
			Body_list[count] = new Body(Planet_property[0],Planet_property[1],Planet_property[2],Planet_property[3],Planet_property[4],last_prop);
		}
		return Body_list;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String file_name = args[2];

		Body[] bodies = NBody.readBodies(file_name);
		int Num_planets = bodies.length;
		double radius = NBody.readRadius(file_name);
		

		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		for (double time_discrete=0;time_discrete<=T;time_discrete+=dt) {
			StdDraw.enableDoubleBuffering();
			double xForces[] = new double[Num_planets];
			double yForces[] = new double[Num_planets];

			for(int i=0;i<Num_planets;i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
				bodies[i].update(dt,xForces[i],yForces[i]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(int i=0;i<bodies.length;i++) {
				bodies[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
	}
}