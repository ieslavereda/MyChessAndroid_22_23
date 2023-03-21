package es.ieslavereda.mychessandroid_22_23;


public class Lista {

    private int size;
    private Node head;

    public Lista(){
    }
    public Lista(Lista l){
        addAll(l);
    }
    public void add(Coordinate coordinate){
        Node node = new Node(coordinate);

        if(head==null) {
            head = node;
        }else {
            node.setNext(head);
            head=node;
        }
        size++;
    }

    public Lista addAll(Lista lista){
        Node aux = lista.head;
        while (aux!=null){
            add(aux.getInfo());
            aux=aux.getNext();
        }

        return this;
    }
    public Coordinate remove(int index){
        if(index>=size || index<0)
            return null;

        Coordinate value = null;

        if(index == 0) {
            value = head.getInfo();
            head = head.getNext();
        } else{
            Node aux1 = head;
            Node aux2 = head.getNext();

            while(index>1){
                aux1=aux2;
                aux2=aux2.getNext();
                index--;
            }
            value = aux2.getInfo();
            aux1.setNext(aux2.getNext());

        }

        size--;
        return value;
    }
    public boolean contains(Coordinate coordinate){
        boolean encontrado = false;

        Node aux = head;

        while(aux!=null && !encontrado)
            if(aux.getInfo().equals(coordinate))
                encontrado = true;
            else
                aux = aux.getNext();

        return encontrado;
    }


    @Override
    public String toString() {
        return "{ size: "+size +", Values: " +((head==null)?"}":head.toString());
    }

    private class Node{
        private Coordinate info;
        private Node next;

        public Node(Coordinate info) {
            this.info = info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Coordinate getInfo() {
            return info;
        }

        @Override
        public String toString() {
            return info.toString() + ((next!=null)?", "+next:" }");
        }
    }
}