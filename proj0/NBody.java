public class NBody {

    public static double readRadius(String f) {
        In in = new In(f);
        int x = in.readInt();
        double Radius = in.readDouble();
        return Radius;
    }

    public static Planet[] readPlanets(String f) {
        In in = new In(f);
        int x = in.readInt();
        double Radius = in.readDouble();
        Planet[] ps = new Planet[x];
        for (int i = 0; i < x; i += 1) {
            Planet p = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
            ps[i] = p;
        }
        return ps;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double universeRadius = readRadius(filename);

        String starfield = "images/starfield.jpg";
        StdDraw.setScale(-universeRadius / 1e+11, universeRadius / 1e+11);

        StdDraw.clear();
        StdDraw.picture(0, 0, starfield);

        for (Planet p : planets) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();

        double currentTime = 0;
        while (currentTime < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i += 1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i += 1) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, starfield);
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            currentTime += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", universeRadius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
