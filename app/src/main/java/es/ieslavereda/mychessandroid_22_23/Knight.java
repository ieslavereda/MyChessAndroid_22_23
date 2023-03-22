package es.ieslavereda.mychessandroid_22_23;

public abstract class Knight extends Piece{

    private Lista coordinates;

    public Knight(PieceType pieceType,Cell cell){
        super(pieceType,cell);
    }

    @Override
    public Lista getNextMovements() {
        coordinates = new Lista();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;
        // Up
        c = position.up().up().left();
        check(c);
        c = position.up().up().right();
        check(c);

        // Down
        c = position.down().down().right();
        check(c);
        c = position.down().down().left();
        check(c);

        // Left
        c = position.left().left().up();
        check(c);
        c = position.left().left().down();
        check(c);

        // Right
        c = position.right().right().up();
        check(c);
        c = position.right().right().down();
        check(c);

        return coordinates;
    }

    private void check(Coordinate c){
        Board board = getCell().getBoard();

        if(board.getCell(c)!=null){
            if(board.getCell(c).isEmpty())
                coordinates.add(c);
            else if(board.getCell(c).getPiece().getColor()!=getColor())
                coordinates.add(c);
        }
    }
}
