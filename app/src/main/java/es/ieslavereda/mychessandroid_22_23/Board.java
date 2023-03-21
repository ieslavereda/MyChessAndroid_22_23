package es.ieslavereda.mychessandroid_22_23;



public class Board {

    private Cell[][] cells;

   // private IDeletePieceManager deletePieceManager;

    public Board() {

       // this.deletePieceManager = new DeletePieceManager();

        cells = new Cell[8][8];

        for (int row = 0; row <= 7; row++)
            for (int col = 0; col <= 7; col++) {
//                cells[row][col] = new Cell(new Coordinate((char) ('A' + col), row + 1), this);
            }

    }

    public void placePieces() {
//        new WhiteRook(getCell(new Coordinate('A',8)));
//        new WhiteRook(getCell(new Coordinate('H',8)));
//        new WhiteKnight(getCell(new Coordinate('B', 8)));
//        new WhiteKnight(getCell(new Coordinate('G', 8)));
//        new WhiteBishop(getCell(new Coordinate('C',8)));
//        new WhiteBishop(getCell(new Coordinate('F',8)));
//        new WhiteQueen(getCell(new Coordinate('D',8)));
//        new WhiteKing(getCell(new Coordinate('E',8)));
//
//        new BlackRook(getCell(new Coordinate('A',1)));
//        new BlackRook(getCell(new Coordinate('H',1)));
//        new BlackKnight(getCell(new Coordinate('B', 1)));
//        new BlackKnight(getCell(new Coordinate('G', 1)));
//        new BlackKnight(getCell(new Coordinate('C',1)));
//        new BlackKnight(getCell(new Coordinate('F',1)));
//        new BlackQueen(getCell(new Coordinate('D',1)));
//        new BlackKing(getCell(new Coordinate('E',1)));
//
//        for(int i='A';i<='H';i++)
//            new WhitePawn(getCell(new Coordinate((char)i,7)));
//
//        for(int i='A';i<='H';i++)
//            new BlackPawn(getCell(new Coordinate((char)i,2)));


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