package Game;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class Tile extends StackPane {

    private int x,y;
    private int value;
    private final int TILE_SIZE = 100;

    Text textValue;
    Rectangle border;

    public Tile(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;

        textValue = new Text();
        border = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);

        border.setStroke(Color.ROSYBROWN);
        if(value != 0)
            textValue.setText(String.valueOf(value));
        else
            textValue.setText("");

        textValue.setFill(Color.WHITE);
        textValue.setFont(Font.font(36));
        getChildren().addAll(border,textValue);
        setTranslateX( y * TILE_SIZE);
        setTranslateY( x * TILE_SIZE);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")" + ", value: " + value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        if(value != 0)
            textValue.setText(String.valueOf(value));
        else
            textValue.setText("");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return value == tile.value;
    }


}
