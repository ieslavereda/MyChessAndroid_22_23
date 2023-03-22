package es.ieslavereda.mychessandroid_22_23;


public class WhitePawn extends Pawn{

    public WhitePawn(Cell cell) {
        super(PieceType.WHITE_PAWN, cell);
    }

    @Override
    public void transform() {
        new WhiteQueen(getCell());
        cell=null;
    }

    @Override
    public Lista getNextMovements() {
        return new Lista();
    }
}
