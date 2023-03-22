package es.ieslavereda.mychessandroid_22_23;



public abstract class Bishop extends Piece{

    public Bishop(PieceType pieceType,Cell cell){
        super(pieceType,cell);
    }

    public static Lista getNextMovementsAsBishop(Piece p) {
        Lista coordinates = new Lista();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Color color = p.getColor();

        Coordinate original = cell.getCoordinate();
        Coordinate c;

        // UP-LEFT
        c=original.upLeft();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c=c.upLeft();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        // UP-RIGHT
        c=original.upRight();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c=c.upRight();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        // DOWN-RIGHT
        c=original.downRight();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c=c.downRight();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        // DOWN-LEFT
        c=original.downLeft();
        while (board.getCell(c)!=null && board.getCell(c).isEmpty()) {
            coordinates.add( c);
            c=c.downLeft();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        return coordinates;
    }

    @Override
    public Lista getNextMovements() {
        return getNextMovementsAsBishop(this);
    }
}
