package es.ieslavereda.mychessandroid_22_23;


import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {

    private PieceType shape;
    protected Cell cell;

    public Piece(PieceType shape,Cell cell){
        this.shape = shape;
        this.cell=cell;
        putInYourPlace();
    }

    public void moveTo(Coordinate c){

        Board b = getCell().getBoard();
        // Check if the cell exists
        if(b.getCell(c)!=null) {
            getCell().setPiece(null);
            Cell cell = b.getCell(c);
            cell.setPiece(this);
            this.cell = cell;
        }
    }
    public Cell getCell() {
        return cell;
    }
    public Color getColor(){
        return shape.color;
    }

    public PieceType getPieceType() {
        return shape;
    }

    public void putInYourPlace(){
        cell.setPiece(this);
    }

//    @Override
//    public String toString(){
//        return colorize(shape.toString(),shape.color.getAttribute(),cell.getColor().getAttribute());
//    }

    public abstract Lista getNextMovements();

    public enum PieceType {

        BLACK_KING(R.mipmap.ic_n_king_foreground,Color.BLACK),
        BLACK_QUEEN(R.mipmap.ic_n_queen_foreground,Color.BLACK),
        BLACK_ROOK(R.mipmap.ic_n_rook_foreground,Color.BLACK),
        BLACK_BISHOP(R.mipmap.ic_n_bishop_foreground,Color.BLACK),
        BLACK_KNIGHT(R.mipmap.ic_n_king_foreground,Color.BLACK),
        BLACK_PAWN(R.mipmap.ic_n_pawn_foreground,Color.BLACK),
        WHITE_KING(R.mipmap.ic_b_king_foreground,Color.WHITE),
        WHITE_QUEEN(R.mipmap.ic_b_queen_foreground,Color.WHITE),
        WHITE_ROOK(R.mipmap.ic_b_rook_foreground,Color.WHITE),
        WHITE_BISHOP(R.mipmap.ic_b_bishoop_foreground,Color.WHITE),
        WHITE_KNIGHT(R.mipmap.ic_b_knight_foreground,Color.WHITE),
        WHITE_PAWN(R.mipmap.ic_b_pawn_foreground,Color.WHITE);
        private int shape;
        private Color color;
        PieceType(int shape,Color color){
            this.shape = shape;
            this.color = color;
        }

        public int getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return  String.valueOf(shape);
        }
    }
}