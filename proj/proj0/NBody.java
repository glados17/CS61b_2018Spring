
public class NBody {
   
    public static double readRadius(String  file) {
        In in = new In(file);
        in.readDouble();
        double universe_r = in.readDouble();
        return universe_r;
    }
    
    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int count_planets = in.readInt();
        in.readDouble();
        Planet[] planets_array = new Planet[count_planets];
        for (int i =0; i < count_planets; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets_array[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return planets_array;
    }
    public static void main(String[] args) {

        // Collecting All Needed Input
        double T = Double.valueOf(args[0].toString());
        double dt = Double.valueOf(args[1].toString());
        String filename = args[2];
        double universe_r = readRadius(filename);
        String universe_pic = "./images/starfield.jpg";

        // Drawing the Background
        StdDraw.setScale(-1 * universe_r, universe_r);
        StdDraw.picture(0, 0, universe_pic, 2 * universe_r, 2 * universe_r);
        Planet[] planets = readPlanets(filename);
        for (Planet planet : planets) {
            planet.draw();
        }


        StdDraw.enableDoubleBuffering();

        // For each time through the loop, do the following:
        for (double running_time = 0; running_time < T; running_time += dt) {

            // Calculate the net x and y forces for each planet, storing these in the xForces and yForces arrays respectively.
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            // Create an xForces array and yForces array.
            for (int i = 0; i <planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            // Call update on each of the planets. This will update each planet’s position, velocity, and acceleration.
            for (int i = 0; i <planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            // Draw the background image.
            StdDraw.picture(0, 0, universe_pic, 2 * universe_r, 2 * universe_r);
            // Draw all of the planets.
            for (Planet planet : planets) {
                planet.draw();
            }
            // Show the offscreen buffer.
            StdDraw.show();
            // Pause the animation for 10 milliseconds
            StdDraw.pause(10);
        }
        //  print out the final state of the universe in the same format as the input
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", universe_r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
        
    }

}
