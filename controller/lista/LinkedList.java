package com.practica1.nole.base.domain.controller.lista;

public class LinkedList<E> {
    private Node<E> header;
    private Node<E> last;
    private Integer size;// pa que no ocupe memoria al ser llamada en otra clase

    public LinkedList(){
        header = null;
        last = null;
        size = 0;
    }

    public Boolean isEmpty(){
        return header == null || size == 0;
    }

    public void deleteFirst(){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        }
        Node<E> aux = header.getNext();
        header = aux;
        size--;
        if (header == null) {
            last = null;
        }
    }

    public void deleteLast(){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        }else if (size == 1) {
            deleteFirst();
        }
        
        Node<E> aux = getNode(size-2);
        last = aux;
        last.setNext(null);
        size--;
    }

    public void delete(Integer pos){
        if (pos == 0){
            deleteFirst();
        } else if (size.intValue() == pos.intValue()){
            deleteLast();
        } else if (pos < 0 || pos >= size){
            System.out.println("Fuera de rango");
        } else{
            Node<E> previo = getNode(pos-1);
            previo.setNext(getNode(pos).getNext());
            size--;
        }
    }

    private Node<E> getNode(Integer pos){
        if(isEmpty()){

            /// no hay excepcions porque
            /// talvez nos haga hacer una listExcepcion jadsjsa
    
            System.out.println("La lista esta vacia");
            return null;
        } else if ( pos < 0 || pos >= size){
            System.out.println("Fuera de rango");
            return null;
        } else if (pos == 0){
            return header;
        } else if(size.intValue() == pos.intValue()){
            return last;
        }
        else {
            Node<E> search = header;
            Integer cont = 0 ;
            while(cont < pos){
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    private void addFirst(E data){
        if(isEmpty()){
            Node<E> aux = new Node<E>(data);
            header = aux;
            last = aux;
        } else{
            Node<E> head_old = header;
            Node<E> aux = new Node<>(data, head_old);
            header = aux;
        }
        size++;
    }

    private void addLast(E data){
        if (isEmpty()) {
            addFirst(data);
        }else {
            Node<E> aux = new Node<>(data);
            last.setNext(aux);
            last = aux;
            size++;
        }
    }

    public void add(E data, Integer pos) throws Exception{
        if (pos == 0 ){
            addFirst(data);
        } else if(size.intValue() == pos.intValue()){
            addLast(data);
        }else if(pos > size || pos < 0){
            System.out.println("Fuera de rango");
        }else{
            Node<E> serach_preview = getNode(pos-1);
            Node<E> search = getNode(pos);
            Node<E> aux = new Node<>(data, search);
            serach_preview.setNext(aux);
            size++;
        }
    }

    public void add(E data){
        addLast(data);
    }

    public E getData(Integer pos){
        return getNode(pos).getData();
    }

    public void update(E data, Integer pos){
        getNode(pos).setData(data);
    }

    public void clear (){
        header = null;
        last = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedList<String> text = new LinkedList<>();
        try {
            text.add("pepito");
            text.addFirst("primero");
            text.addLast("ultimo");
            text.add("perro");
            text.add("xd");
            text.add("sss");
            text.add("2222",6);
            System.out.println(text.print());
            text.deleteLast();
            System.out.println(text.print());
            text.delete(4);
            System.out.println(text.print());
            text.update("sssssssssss", 1);
            System.out.println(text.print());
        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }

    }

    public String print(){
        if (isEmpty()) {
            return "Ta vacia tu vaina Soe"; 
        }else{
            StringBuilder txt = new StringBuilder();
            Node<E> help = header;
            while (help != null) {
                txt.append(help.getData()).append(" -- ");
                help = help.getNext();
            }
            txt.append("\n");
            return txt.toString();
        }
    }    
    
    public Node<E> getHeader() {
        return this.header;
    }

    public void setHeader(Node<E> header) {
        this.header = header;
    }

    public Node<E> getLast() {
        return this.last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

///home/debian2025/EStrucutra de datos/
}
