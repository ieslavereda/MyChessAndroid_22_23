package es.ieslavereda.mychessandroid_22_23;

public abstract class Pawn extends Piece{

    public Pawn(PieceType pieceType, Cell cell) {
        super(pieceType, cell);
    }

    @Override
    public void moveTo(Coordinate c){
        super.moveTo(c);
        if(getCell().getCoordinate().getRow()==8 ||
        getCell().getCoordinate().getRow()==1){
            transform();
        }
    }

    public abstract void transform();

}
