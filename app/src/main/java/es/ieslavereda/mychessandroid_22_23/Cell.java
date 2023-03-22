package es.ieslavereda.mychessandroid_22_23;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class Cell extends androidx.appcompat.widget.AppCompatImageView {
    private Piece piece;
    private int color;
    private int original;
    private Coordinate coordinate;
    private Board board;


    public Cell(Context context, Coordinate coordinate, Board board) {
        super(context);
        this.coordinate = coordinate;
        this.board = board;
        this.piece = null;

        this.original = (
                (coordinate.getRow() - 1 + coordinate.getColumn() - 'A') % 2 == 0)
                ?
                R.color.cell_white
                :
                R.color.cell_black;

        this.color = original;

        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int widh = displayMetrics.widthPixels;

        setMaxWidth(widh/10);
        setMinimumWidth(widh/10);
        setMaxHeight(widh/10);
        setMinimumHeight(widh/10);

        setPadding(0,0,0,0);
        setScaleType(ScaleType.FIT_CENTER);

        setAdjustViewBounds(true);
        updateCellView();
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

    public int getColor() {
        return color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if(piece!=null) setImageResource(piece.getPieceType().getShape());
        else setImageResource(0);
    }

    public void highlight() {
        if (isEmpty()) {

            if (original == R.color.cell_white)
                color = R.color.HIGHLIGHT_WHITE;
            else
                color = R.color.HIGHLIGHT_BLACK;

        } else {
            color = (original == R.color.cell_white)
                    ?
                    R.color.HIGHLIGHT_KILL_WHITE
                    :
                    R.color.HIGHLIGHT_KILL_BLACK;
        }

        updateCellView();
    }

    public void resetColor() {
        color = original;
        updateCellView();
    }

    private void updateCellView() {
        setBackgroundColor(getResources().getColor(color,getContext().getTheme()));
    }

//    @Override
//    public String toString() {
//        if (isEmpty())
//            return colorize("   ", color.getAttribute());
//        else
//            return colorize(" ", color.getAttribute()) +
//                    piece +
//                    colorize(" ", color.getAttribute());
//
//    }

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