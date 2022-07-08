package gamePieces;

public record Coordinates( int row, int col )
        implements Comparable< Coordinates > {


    public Coordinates( String rowStr, String colStr ) {
        this( Integer.parseInt( rowStr ), Integer.parseInt( colStr ) );
    }

    @Override
    public String toString() {
        return "(" + this.row + ',' + this.col + ')';
    }


    @Override
    public int compareTo( Coordinates o ) {
        int result = this.row - o.row;
        if ( result == 0 ) result = this.col - o.col;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Coordinates) {
            return ((Coordinates) o).col == this.col && ((Coordinates) o).row == this.row;
        }
        return false;
    }
}
