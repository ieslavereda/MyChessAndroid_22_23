package es.ieslavereda.mychessandroid_22_23;

import com.diogonunes.jcolor.Attribute;

public enum Color {
    BLACK(Attribute.TEXT_COLOR(71, 60, 51)),
    WHITE(Attribute.TEXT_COLOR(254, 200, 104));

    private Attribute attribute;

    Color(Attribute attribute){
        this.attribute = attribute;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public Color next(){
        if(this.equals(WHITE))
            return BLACK;
        return WHITE;
        //return values()[(ordinal()+1)% values().length];
    }
}