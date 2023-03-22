package es.ieslavereda.mychessandroid_22_23;

public class Tool {
    public static Coordinate[] add(Coordinate[] coordinates, Coordinate coordinate){
        Coordinate[] aux = new Coordinate[coordinates.length+1];
        for(int i=0;i< coordinates.length;i++)
            aux[i]=coordinates[i];

        aux[aux.length-1]=coordinate;
        return aux;
    }

    public static Coordinate[]  merge(Coordinate[] c1,Coordinate[] c2){
        Coordinate[] aux = new Coordinate[c1.length+c2.length];
        for(int i=0;i<c1.length;i++)
            aux[i]=c1[i];
        for(int i=0;i<c2.length;i++)
            aux[c1.length+i]=c2[i];
        return aux;
    }
}
