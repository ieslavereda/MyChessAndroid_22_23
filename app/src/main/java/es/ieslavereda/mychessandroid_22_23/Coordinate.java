package es.ieslavereda.mychessandroid_22_23;

public class Coordinate {

    private char column;
    private int row;

    public Coordinate(char column, int row) {
        this.column = Character.toUpperCase(column);
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Coordinate up(){
        return new Coordinate(column,row-1);
    }
    public Coordinate down(){
        return new Coordinate(column,row+1);
    }
    public Coordinate left(){
        return new Coordinate((char)(column-1),row);
    }
    public Coordinate right(){
        return new Coordinate((char)(column+1),row);
    }
    public Coordinate upRight(){
        return up().right();
    }
    public Coordinate upLeft(){
        return up().left();
    }
    public Coordinate downRight(){
        return down().right();
    }
    public Coordinate downLeft(){
        return down().left();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coordinate){
            Coordinate c = (Coordinate) obj;
            return column==c.column && row==c.row;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + column + "," + row + ")";
    }
}