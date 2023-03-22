package es.ieslavereda.mychessandroid_22_23;

public interface IDeletePieceManager {
    void addPiece(Piece piece);
    int count(Piece.PieceType pieceType);
    Piece removeLast();
}
