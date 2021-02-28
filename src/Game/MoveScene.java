package Game;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class MoveScene extends Scene {

    Board board;
    Tile[][] grid;

    //TODO after click arrows generate new tile

    public MoveScene(Board root) {
        super(root);
        this.board = root;
        this.grid = this.board.getGrid();
        this.setOnKeyPressed(event -> keyPressed(event)); // we set up action on key pressed
    }

    private void keyPressed(KeyEvent event) {
        System.out.println("hahs");
        KeyCode pressedKey = event.getCode();

        switch(pressedKey) {
            case UP:
                moveTilesUp();
                break;
            case DOWN:
                moveTilesDown();
                break;
            case RIGHT:
                moveTilesRight();
                break;
            case LEFT:
                moveTilesLeft();
                break;
        }

        printArray();
    }

    // tmp function
    private void printArray() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + "   ");
            }
            System.out.println();
        }
    }

    private void moveTilesLeft() {

        System.out.println("Left");
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                Tile tile = grid[i][j];

                if( tile.getValue() == 0 )
                    continue;

                int value = tile.getValue();
                int index = j + 1;

                while(index < 4 && grid[i][index].getValue() == 0) {
                    index++;
                }

                if(index < 4) {
                    if(value == grid[i][index].getValue()) {
                        tile.setValue(2 * value);
                        grid[i][index].setValue(0);
                    }
                }

                value = tile.getValue();
                index = j - 1;
                while(index >= 0 && grid[i][index].getValue() == 0)
                    index--;

                grid[i][j].setValue(0);
                if(index < 0 ) {
                    grid[i][0].setValue(value);
                }
                else {
                    grid[i][index + 1].setValue(value);
                }

            }
        }

    }

    private void moveTilesRight() {
        System.out.println("Right");

        for(int i = 3; i >= 0; i--) {
            for(int j = 3; j >= 0; j--) {

                Tile tile = grid[i][j];

                if( tile.getValue() == 0 )
                    continue;

                int value = tile.getValue();
                int index = j - 1;

                while(index >= 0 && grid[i][index].getValue() == 0) {
                    index--;
                }

                if(index >= 0) {
                    if(value == grid[i][index].getValue()) {
                        tile.setValue(2 * value);
                        grid[i][index].setValue(0);
                    }
                }

                value = tile.getValue();
                index = j + 1;
                while(index < 4 && grid[i][index].getValue() == 0)
                    index++;

                grid[i][j].setValue(0);
                if(index >= 4 ) {
                    grid[i][3].setValue(value);
                }
                else {
                    grid[i][index - 1].setValue(value);
                }

            }
        }

    }

    private void moveTilesDown() {

        System.out.println("Down");
        for(int i = 3; i >= 0; i--) {
            for(int j = 3; j >= 0; j--) {

                Tile tile = grid[j][i];

                if( tile.getValue() == 0 )
                    continue;

                int value = tile.getValue();
                int index = j - 1;

                while(index >= 0 && grid[index][i].getValue() == 0) {
                    index--;
                }

                if(index >= 0) {
                    if(value == grid[index][i].getValue()) {
                        tile.setValue(2 * value);
                        grid[index][i].setValue(0);
                    }
                }

                value = tile.getValue();
                index = j + 1;
                while(index < 4 && grid[index][i].getValue() == 0)
                    index++;

                grid[j][i].setValue(0);
                if(index >= 4 ) {
                    grid[3][i].setValue(value);
                }
                else {
                    grid[index - 1][i].setValue(value);
                }

            }
        }

    }

    private void moveTilesUp() {
        System.out.println("Up");

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                Tile tile = grid[j][i];

                if( tile.getValue() == 0 )
                    continue;

                int value = tile.getValue();
                int index = j + 1;

                while(index < 4 && grid[index][i].getValue() == 0) {
                    index++;
                }

                if(index < 4) {
                    if(value == grid[index][i].getValue()) {
                        tile.setValue(2 * value);
                        grid[index][i].setValue(0);
                    }
                }

                value = tile.getValue();
                index = j - 1;
                while(index >= 0 && grid[index][i].getValue() == 0)
                    index--;

                grid[j][i].setValue(0);
                if(index < 0 ) {
                    grid[0][i].setValue(value);
                }
                else {
                    grid[index + 1][i].setValue(value);
                }

            }
        }

    }
}
