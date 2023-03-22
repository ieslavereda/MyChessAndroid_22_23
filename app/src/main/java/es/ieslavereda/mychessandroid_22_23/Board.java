package es.ieslavereda.mychessandroid_22_23;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Board extends TableLayout {

    private Cell[][] cells;

   // private IDeletePieceManager deletePieceManager;

    public Board(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        cells = new Cell[8][8];
        // this.deletePieceManager = new DeletePieceManager();

        // Fila superior
        addTextViews();

        // Parte media
        TableRow row ;
        for (int r = 1; r <= 8; r++) {
            row = new TableRow(getContext());
            row.addView(getTextView("" + r));

            for (int c = 'A'; c <= 'H'; c++) {
                Cell cell = new Cell(getContext(), new Coordinate((char) c, r), this);

                cells[r-1][c-'A']=cell;
                row.addView(cell);
            }

            row.addView(getTextView("" + r));
            addView(row);
        }


        // Fila inferior
        addTextViews();

        placePieces();

    }
    private void addTextViews() {
        TableRow row;

        row = new TableRow(getContext());
        row.addView(getTextView(""));

        for (int i = 0; i < 8; i++)
            row.addView(getTextView(String.valueOf((char) ('A' + i))));

        row.addView(getTextView(""));

        addView(row);
    }
    private TextView getTextView(String text) {

        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int widh = displayMetrics.widthPixels;

        TextView txtView = new TextView(getContext());

        txtView.setText(text);
        txtView.setTextColor(getResources().getColor(R.color.white, getContext().getTheme()));
        txtView.setBackgroundColor(getResources().getColor(R.color.black, getContext().getTheme()));
        txtView.setWidth(widh / 10);
        txtView.setHeight(widh / 10);
        txtView.setGravity(Gravity.CENTER);

        return txtView;
    }

    public void placePieces() {
        new WhiteRook(getCell(new Coordinate('A',8)));
        new WhiteRook(getCell(new Coordinate('H',8)));
        new WhiteKnight(getCell(new Coordinate('B', 8)));
        new WhiteKnight(getCell(new Coordinate('G', 8)));
        new WhiteBishop(getCell(new Coordinate('C',8)));
        new WhiteBishop(getCell(new Coordinate('F',8)));
        new WhiteQueen(getCell(new Coordinate('D',8)));
        new WhiteKing(getCell(new Coordinate('E',8)));

        new BlackRook(getCell(new Coordinate('A',1)));
        new BlackRook(getCell(new Coordinate('H',1)));
        new BlackKnight(getCell(new Coordinate('B', 1)));
        new BlackKnight(getCell(new Coordinate('G', 1)));
        new BlackKnight(getCell(new Coordinate('C',1)));
        new BlackKnight(getCell(new Coordinate('F',1)));
        new BlackQueen(getCell(new Coordinate('D',1)));
        new BlackKing(getCell(new Coordinate('E',1)));

        for(int i='A';i<='H';i++)
            new WhitePawn(getCell(new Coordinate((char)i,7)));

        for(int i='A';i<='H';i++)
            new BlackPawn(getCell(new Coordinate((char)i,2)));


    }

    public Cell getCell(Coordinate coordinate) {

        if (coordinate.getRow() < 1 || coordinate.getRow() > 8)
            return null;
        if (coordinate.getColumn() < 'A' || coordinate.getColumn() > 'H')
            return null;

        return cells[coordinate.getRow() - 1][coordinate.getColumn() - 'A'];
    }

    public void highlight(Lista coordinates) {
        Coordinate c;
        while((c=coordinates.remove(0))!=null)
            getCell(c).highlight();
    }

    public void resetColors() {
        for (Cell[] row : cells)
            for (Cell c : row)
                c.resetColor();
    }

    public void setCellListener(View.OnClickListener viewOnClickListener){
        for(Cell[] cellsRow : cells)
            for(Cell c : cellsRow)
                c.setOnClickListener(viewOnClickListener);
    }

    @Override
    public String toString() {
        String output = "       A  B  C  D  E  F  G  H\n";
        for (int row = 0; row <= 7; row++) {
            output += "    " + (row + 1) + " ";
            for (int col = 0; col <= 7; col++)
                output += cells[row][col];
            output += " " + (row + 1) + "\n";
        }
        output += "        A  B  C  D  E  F  G  H\n";
       // output += "\n\n"+deletePieceManager.toString();
        return output;
    }
}