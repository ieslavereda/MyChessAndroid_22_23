package es.ieslavereda.mychessandroid_22_23;


public abstract  class Rook extends Piece {

    private boolean moved;

    public Rook(PieceType pieceType, Cell cell) {
        super(pieceType, cell);
        moved = false;
    }

    public boolean isMoved() {
        return moved;
    }

    @Override
    public void moveTo(Coordinate c) {
        super.moveTo(c);
        moved=true;
    }

    public static Lista getNextMovementsAsRook(Piece p) {
        Lista coordinates = new Lista();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Color color = p.getColor();

        Coordinate original = cell.getCoordinate();
        Coordinate c;

        // UP
        c=original.up();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c=c.up();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        // DOWN
        c=original.down();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add( c);
            c=c.down();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        // LEFT
        c=original.left();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add( c);
            c=c.left();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        // RIGHT
        c=original.right();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c=c.right();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);


        return coordinates;
    }

    @Override
    public Lista getNextMovements() {
        return Rook.getNextMovementsAsRook(this);
    }


}
