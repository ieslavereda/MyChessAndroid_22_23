package es.ieslavereda.mychessandroid_22_23;



import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletePieceManager implements IDeletePieceManager {

    private ListaDE piezas;

    public DeletePieceManager() {
        piezas = new ListaDE();
    }

    @Override
    public void addPiece(Piece piece) {
        piezas.addHead(piece);
    }

    @Override
    public int count(Piece.PieceType pieceType) {
        return piezas.count(pieceType);
    }

    @Override
    public Piece removeLast() {
        return piezas.removeHead();
    }

    @Override
    public String toString() {
        String output = "";

        for (Piece.PieceType pieceType : Piece.PieceType.values())
            output += colorize(" " + pieceType.getShape() + " ", pieceType.getColor().getAttribute(), Cell.Color.BLACK_CELL.getAttribute());

        output += "\n";

        for (Piece.PieceType pieceType : Piece.PieceType.values())
            output += colorize(" " + piezas.count(pieceType) + " ", pieceType.getColor().getAttribute(), Cell.Color.WHITE_CELL.getAttribute());

        return output;
    }
}
