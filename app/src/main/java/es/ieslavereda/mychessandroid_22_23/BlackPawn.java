package es.ieslavereda.mychessandroid_22_23;

public final class BlackPawn extends Pawn{
    public BlackPawn(Cell cell) {
        super(PieceType.BLACK_PAWN, cell);
    }

//    @Override
//    public void moveTo(Coordinate c){
//        super.moveTo(c);
//        if(getCell().getCoordinate().getRow()==8){
//            new BlackQueen(getCell());
//        }
//    }

    @Override
    public Lista getNextMovements() {
        return new Lista();
    }

    @Override
    public void transform() {
        new BlackQueen(getCell());
        cell=null;
    }
}
