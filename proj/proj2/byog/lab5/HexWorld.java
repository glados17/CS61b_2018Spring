package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    public static TETile[][] initializeWorld(){
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        return world;
    }

    public static void singleHex(int n, int x, int y, TETile tileStyle, TETile[][] world){
        /** draw a single Hex with n*n size on the left down corner on (x,y) */
        assert n > 1 : "n must be greater than 1";

        for (int i = 0; i < n; i++){
            for (int j = n - 1 - i; j < 2 * n + i - 1; j++){
                world[j + x][i + y] = tileStyle;
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = i; j < 3 * n - i - 2; j++){
                world[j + x][i + y + n] = tileStyle;
            }
        }
    }

    /** definition of Point */
    private static class Point{
        public int x;
        public int y;

        public Point(int a, int b){
            x = a;
            y = b;
        }
    }

    /**    return if the point is valid on the canvas. */
    public static boolean validPoint(Point myPoint, int hexSize){
        if (myPoint.x >= 0 && myPoint.y >= 0 &&
            myPoint.x + 3 * hexSize - 2 <= WIDTH &&
            myPoint.y + 2 * hexSize <= HEIGHT
            ) {
            return true;
        } return false;
    }

    /**given a point, retrun the most left and down point in the possible array of Hexs */
    public static Point realStartPoint(Point startPoint, int hexSize){
        int realX = startPoint.x % (hexSize * 4 - 2);
        int realY = startPoint.y % (hexSize *2);
        return new Point(realX, realY);
    }

    /** find the grid for the hexs to fill the world, there are 2 separate grid arrays*/
    public static class GridWorld{
        public int lenX;
        public int lenY;
        public Point[][] grid;

        public GridWorld(Point startPoint, int w, int h, int hexSize) {
            Point starter = realStartPoint(startPoint, hexSize);
            lenX = (WIDTH - starter.x) / (hexSize * 4 - 2) ;
            lenY = (HEIGHT - starter.y) / (hexSize * 2);
            grid = setGrid(starter, hexSize);
        }
            /**store the grid in a 2 dimensions array, be careful because it is a hex,
             *  so there are 2 separated grids*/
          public Point[][] setGrid(Point startPoint, int hexSize){
            Point[][] grid = new Point[lenX][lenY];
            for (int i = 0; i < lenX; i++) {
                int x = startPoint.x + i * (hexSize * 4 - 2);
                for (int j = 0; j < lenY; j++) {
                    int y = startPoint.y + j * (hexSize * 2);
                    grid[i][j] = new Point(x, y);
                }
            }
            return grid;
        }
    }

    /** give a point, find another start point in another grid */
    public static Point anotherStarter(Point p,int hexSize){
        Point realOne = realStartPoint(p, hexSize);
        Point maybeTwo = new Point(realOne.x + 2*hexSize-1, realOne.y + hexSize);
        return realStartPoint(maybeTwo, hexSize);
    }

    /** randomtile copied from the given demo*/
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.SAND;
            case 3: return Tileset.WATER;
            case 4: return Tileset.TREE;
            default: return Tileset.NOTHING;
        }
    }

    /**return the 6 adjoined valid start points next to the given point, unfinished, maybe useful later*/
    public List <Point> adjoinedPoints(Point myPoint, int hexSize){
        List <Point> adjoined = new ArrayList();
        Point[] points = new Point[6];
        points[0] = new Point(myPoint.x, myPoint.y + 2 * hexSize);
        points[1] = new Point(myPoint.x, myPoint.y - 2 * hexSize);
        points[2] = new Point(myPoint.x - 3 * hexSize + 4, myPoint.y - hexSize);
        points[3] = new Point(myPoint.x + hexSize + 2, myPoint.y - hexSize);
        points[4] = new Point(myPoint.x - 3 * hexSize + 4, myPoint.y + hexSize);
        points[5] = new Point(myPoint.x + hexSize + 2, myPoint.y + hexSize);
        for (Point p:points){
            if (validPoint(p,hexSize)){
                adjoined.add(p);
            }
        }

        return adjoined;
    }

    public static void drawWorld(Point starter, int hexSize, TETile[][] world){
        GridWorld myGrids = new GridWorld(starter, WIDTH, HEIGHT, hexSize);
        for (int i = 0; i <myGrids.lenX; i++){
            for (int j = 0; j <myGrids.lenY; j ++){
                Point pointNow = myGrids.grid[i][j];
                singleHex(hexSize,pointNow.x,pointNow.y, randomTile(), world);
                System.out.println("i:" + i + " j:" + j +"  (x,y): " + pointNow.x + ","+pointNow.y);
            }
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = initializeWorld();
        Point starter = new Point(0,0);
        int hexSize = 6;

        /** draw the two separated girds of hex*/
        drawWorld(starter, hexSize, world);
        drawWorld(anotherStarter(starter, hexSize), hexSize, world);
        ter.renderFrame(world);
    }

}
