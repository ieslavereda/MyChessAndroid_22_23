package es.ieslavereda.mychessandroid_22_23;

public abstract class Queen extends Piece {

    public Queen(PieceType pieceType,Cell cell){
        super(pieceType,cell);
    }

    @Override
    public Lista getNextMovements() {
       return Rook.getNextMovementsAsRook(this).
               addAll(Bishop.getNextMovementsAsBishop(this));
    }
}
