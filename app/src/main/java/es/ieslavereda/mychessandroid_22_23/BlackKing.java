package es.ieslavereda.mychessandroid_22_23;



public final class BlackKing extends King{
    public BlackKing(Cell cell) {
        super(PieceType.BLACK_KING, cell);
    }

    @Override
    public Lista getNextMovements() {
        return new Lista();
    }
}
