public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double sqr_r = dx * dx + dy * dy;
        return Math.sqrt(sqr_r);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        double F = G * this.mass * p.mass / distance / distance;
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double distance = calcDistance(p);
        return dx * calcForceExertedBy(p) / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double distance = calcDistance(p);
        return dy * calcForceExertedBy(p) / distance;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double NetForceX = 0.0;
        for (Planet p : ps) {
            if (! equals(p)) {
                NetForceX += calcForceExertedByX(p);
            }
        }
        return NetForceX;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double NetForceY = 0.0;
        for (Planet p : ps) {
            if (! equals(p)) {
                NetForceY += calcForceExertedByY(p);
            }
        }
        return NetForceY;
    }

    public void update(double dt, double FX, double FY) {
        double Ax = FX / mass;
        double Ay = FY / mass;
        xxVel += dt * Ax;
        yyVel += dt * Ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos / 1e+11,yyPos / 1e+11,"images/" + imgFileName);
    }
}
