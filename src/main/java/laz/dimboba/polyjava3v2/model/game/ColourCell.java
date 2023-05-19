package laz.dimboba.polyjava3v2.model.game;

import java.util.function.Consumer;

public class ColourCell extends CellImpl{
    private String colour;
    public ColourCell(int row, int col){
        super(row, col);
    }

    @Override
    public void onClick(Consumer<String> function) {
        function.accept(colour);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}

