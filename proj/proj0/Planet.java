
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

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
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) 
        + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67E-011;
        double r = calcDistance(p);
        return G * mass * p.mass / r / r;
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public boolean equals(Planet p) {
        return p.xxPos == xxPos && p.yyPos == yyPos && p.mass == mass;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double xforce = 0;
        for (Planet p : planets) {
            if (! equals(p)) {
                xforce += calcForceExertedByX(p);
            }
        }
        return xforce;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double yforce = 0;
        for (Planet p : planets) {
            if (! equals(p)) {
                yforce += calcForceExertedByY(p);
            }
        }
        return yforce;
    }

    public void update(double dt, double fX, double fY) {
        double acceleration_x = fX / mass;
        double acceleration_y = fY / mass;
        xxVel = acceleration_x * dt + xxVel;
        yyVel = acceleration_y * dt + yyVel;
        xxPos = xxPos + xxVel *dt;
        yyPos = yyPos + yyVel *dt;
    }
    
    public void draw() {
    StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }

}