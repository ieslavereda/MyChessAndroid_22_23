package es.ieslavereda.mychessandroid_22_23;

public class ListaDE {

    private int size;
    private Node head;
    private Node tail;

    public void addHead(Piece piece){
        Node node = new Node(piece);
        // Solo una condicion es necesaria
        if(size==0 || head==null || tail==null){
            head = node;
            tail = node;
        }else{
            node.setNext(head);
            head.setPrevious(node);
            head=node;
        }
        size++;
    }

    public void addTail(Piece piece){
        Node node = new Node(piece);

        if(head==null){
            head = node;
            tail = node;
        }else{
            node.setPrevious(tail);
            tail.setNext(node);
            tail=node;
        }
        size++;
    }

    public Piece removeHead(){

        if(tail==null)
            return null;

        Piece piece = head.info;
        if(size==1){
            head = null;
            tail = null;
        }else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
        return piece;
    }
    public Piece removeTail(){
        if(tail==null)
            return null;

        Piece piece = head.info;
        if(size==1){
            head = null;
            tail = null;
        }else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return piece;
    }
    public int count(Piece.PieceType pieceType){

        Node aux = head;
        int count = 0;

        while(aux!=null){
            if(aux.getInfo().getPieceType()==pieceType)
                count++;
            aux=aux.getNext();
        }

        return count;
    }

    @Override
    public String toString() {
        String output = "ListaDE { Size: "+ size + ", Values: ";
        Node aux = head;
        while (aux!=null){
            output+= aux + " ";
            aux = aux.getNext();
        }

        return output +"}";
    }

    public String toStringReverse() {
        String output = "ListaDE { Size: "+ size + ", Values: ";
        Node aux = tail;
        while (aux!=null){
            output+= aux + " ";
            aux = aux.getPrevious();
        }

        return output +"}";
    }

    private class Node {
        private Piece info;
        private Node next;
        private Node previous;

        public Node(Piece info) {
            this.info = info;
        }

        public Piece getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return String.valueOf(info);
        }
    }
}
