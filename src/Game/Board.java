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

        this.setFocusTraversable(true); // set up possibility  expectations to key pressed or sth else
        //this.setOnKeyPressed(event -> keyPressed(event)); // we set up action on key pressed
    }

//    private void keyPressed(KeyEvent event) {
//        System.out.println("hahs");
//        KeyCode pressedKey = event.getCode();
//
//        switch(pressedKey) {
//            case UP:
//                moveTilesUp();
//                break;
//            case DOWN:
//                moveTilesDown();
//                break;
//            case RIGHT:
//                moveTilesRight();
//                break;
//            case LEFT:
//                moveTilesLeft();
//                break;
//        }
//
//    }
//
//    private void moveTilesLeft() {
//
//        for(int i = 0; i < 4; i++) {
//            for(int j = 1; j < 4; j++) {
//
//                if( grid[i][j].getValue() == grid[i][j-1].getValue() ) {
//                    int value = grid[i][j].getValue();
//                    grid[i][j-1].setValue(value * 2);
//                    grid[i][j].setValue(0);
//
//                    int index = j;
//                    while( index < 3 ) {
//                        value = grid[i][index+1].getValue();
//                        grid[i][index].setValue(value);
//                        grid[i][index+1].setValue(0);
//                        index++;
//                    }
//                }
//
//            }
//        }
//
//    }
//
//    private void moveTilesRight() {
//
//        for(int i = 3; i >= 0; i--) {
//            for(int j = 2; j >= 0; j--) {
//
//                if( grid[i][j].getValue() == grid[i][j+1].getValue() ) {
//                    int value = grid[i][j].getValue();
//                    grid[i][j+1].setValue(value * 2);
//                    grid[i][j].setValue(0);
//
//                    int index = j;
//                    while( index > 0 ) {
//                        value = grid[i][index-1].getValue();
//                        grid[i][index].setValue(value);
//                        grid[i][index-1].setValue(0);
//                        index--;
//                    }
//                }
//
//            }
//        }
//
//    }
//
//    private void moveTilesDown() {
//
//        for(int i = 3; i >= 0; i--) {
//            for(int j = 2; j >= 0; j--) {
//
//                if( grid[j][i].getValue() == grid[j+1][i].getValue() ) {
//                    int value = grid[j][i].getValue();
//                    grid[j+1][i].setValue(value * 2);
//                    grid[j][i].setValue(0);
//
//                    int index = j;
//                    while( index > 0 ) {
//                        value = grid[index-1][i].getValue();
//                        grid[index][i].setValue(value);
//                        grid[index-1][i].setValue(0);
//                        index--;
//                    }
//                }
//
//            }
//        }
//
//    }
//
//    private void moveTilesUp() {
//
//        for(int i = 0; i < 4; i++) {
//            for(int j = 1; j < 4; j++) {
//
//                if( grid[j][i].getValue() == grid[j-1][i].getValue() ) {
//                    int value = grid[j][i].getValue();
//                    grid[j-1][i].setValue(value * 2);
//                    grid[j][i].setValue(0);
//
//                    int index = j;
//                    while( index < 3 ) {
//                        value = grid[index+1][i].getValue();
//                        grid[index][i].setValue(value);
//                        grid[index+1][i].setValue(0);
//                        index++;
//                    }
//                }
//
//            }
//        }
//
//    }


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

    public Tile[][] getGrid() {
        return grid;
    }
}
