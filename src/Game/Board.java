package Game;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Board extends Pane {

    private final int width = 400;
    private final int height = 400;
    private final int TILE_SIZE = 100;

    private final Tile[][] grid = new Tile[4][4];

    public Board() {
        this.setPrefSize(width,height);
        prepareGame();

    }



    // we choose random two position to start a game, and initialize grid
    public void prepareGame() {
        Random random = new Random();
        int x1 = random.nextInt(4), y1 = random.nextInt(4);
        int x2 = random.nextInt(4), y2 = random.nextInt(4);

        grid[x1][y1] = new Tile(x1,y1,2);
        grid[x2][y2] = new Tile(x2,y2,2);

        this.getChildren().addAll(grid[x1][y1],grid[x2][y2]);

        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < 4; y++) {

                if( grid[x][y] == null ) {
                    grid[x][y] = new Tile(x, y, 0);
                    this.getChildren().add(grid[x][y]);
                }
            }
        }
    }

    public void generateTile() {
        Random random = new Random();
        int x = random.nextInt(4), y = random.nextInt(4);

        while(grid[x][y].getValue() != 0) {
            x = random.nextInt(4);
            y = random.nextInt(4);
        }

        grid[x][y].setValue(2);

        //TODO set different value, not only two
    }

    private boolean gameOver() {

        boolean canMove = false;

        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < 4; y++) {

                if(grid[x][y].getValue() != 0 || canMove(x,y))
                    return false;

            }
        }
        return true;
    }

    private boolean canMove(int x, int y) {
        int[] points = new int[]{
                0,-1,
                1,0,
                0,1,
                -1,0
        };

        for(int i = 0;i < points.length; i++) {
            int newX = points[i] + x;
            int newY= points[++i] + y;

            if(newX >= 0 && newX < 4 && newY >= 0 && newY < 4) {
                if(grid[x][y].getValue() == grid[newX][newY].getValue())
                    return true;
            }
        }
        return false;
    }

    public Tile[][] getGrid() {
        return grid;
    }
}
