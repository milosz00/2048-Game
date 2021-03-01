package Game;


import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class MoveScene extends Scene {

    Board board;
    Tile[][] grid;


    public MoveScene(Board root) {
        super(root);
        this.board = root;
        this.grid = this.board.getGrid();
        this.setOnKeyPressed(event -> keyPressed(event)); // we set up action on key pressed
    }

    private void keyPressed(KeyEvent event) {

        if(this.board.gameOver()) {
            System.out.println("Game Over");
            return;
        }

        KeyCode pressedKey = event.getCode();
        boolean change = false;

        switch(pressedKey) {
            case UP:
                if(moveTilesUp())
                    change = true;
                break;
            case DOWN:
                if(moveTilesDown())
                    change = true;
                break;
            case RIGHT:
                if(moveTilesRight())
                    change = true;
                break;
            case LEFT:
                if(moveTilesLeft())
                    change = true;
                break;
        }

        if(change)
            this.board.generateTile();
        printArray(grid);
    }

    // tmp function
    private void printArray(Tile[][] grid) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + "   ");
            }
            System.out.println();
        }
    }

    private boolean moveTilesLeft() {


        Tile[][] gridBeforeChanges = createCopyOfTileArray(grid);
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

        if(isGridsDifferent(gridBeforeChanges))
            return true;

        return false;
    }

    private boolean moveTilesRight() {

        Tile[][] gridBeforeChanges = createCopyOfTileArray(grid);

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

        if(isGridsDifferent(gridBeforeChanges))
            return true;

        return false;
    }

    private boolean moveTilesDown() {

        Tile[][] gridBeforeChanges = createCopyOfTileArray(grid);

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

        if(isGridsDifferent(gridBeforeChanges))
            return true;

        return false;

    }

    private boolean moveTilesUp() {

        Tile[][] gridBeforeChanges = createCopyOfTileArray(grid);

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

        if(isGridsDifferent(gridBeforeChanges))
            return true;

        return false;
    }

    private boolean isGridsDifferent(Tile[][] gridBeforeChanges) {

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if( !grid[i][j].equals(gridBeforeChanges[i][j]) )
                    return true;
            }
        }
        return false;
    }

    private Tile[][] createCopyOfTileArray(Tile[][] grid) {

        Tile[][] tiles = new Tile[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tiles[i][j] = new Tile(i,j,grid[i][j].getValue());
            }
        }
        return tiles;
    }
}
