package es.ieslavereda.mychessandroid_22_23;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Cell {
    private Piece piece;
    private Color color;
    private Color original;
    private Coordinate coordinate;
    private Board board;

    public Cell(Coordinate coordinate, Board board) {
        this.coordinate = coordinate;
        this.board = board;
        this.piece = null;
        this.original = (
                (coordinate.getRow() - 1 + coordinate.getColumn() - 'A') % 2 == 0)
                ?
                Color.WHITE_CELL
                :
                Color.BLACK_CELL;
        this.color = original;
    }

    public Board getBoard() {
        return board;
    }
    public Piece getPiece(){
        return piece;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Color getColor() {
        return color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void highlight() {
        if (isEmpty()) {

            if (original == Color.WHITE_CELL)
                color = Color.HIGHLIGHT_WHITE;
            else
                color = Color.HIGHLIGHT_BLACK;

        } else {
            color = (original == Color.WHITE_CELL)
                    ?
                    Color.HIGHLIGHT_KILL_WHITE
                    :
                    Color.HIGHLIGHT_KILL_BLACK;
        }
    }

    public void resetColor() {
        color = original;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return colorize("   ", color.getAttribute());
        else
            return colorize(" ", color.getAttribute()) +
                    piece +
                    colorize(" ", color.getAttribute());

    }

    public boolean isEmpty() {
        return piece == null;
    }

    enum Color {
        WHITE_CELL(Attribute.BACK_COLOR(229, 229, 203)),
        BLACK_CELL(Attribute.BACK_COLOR(160, 135, 123)),
        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180, 0, 0)),
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130, 0, 0)),
        HIGHLIGHT_WHITE(Attribute.BACK_COLOR(180, 180, 0)),
        HIGHLIGHT_BLACK(Attribute.BACK_COLOR(130, 130, 0));

        private Attribute attribute;

        Color(Attribute attribute) {
            this.attribute = attribute;
        }

        public Attribute getAttribute() {
            return attribute;
        }
    }
}