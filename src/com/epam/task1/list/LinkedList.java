package com.epam.task1.list;

public class LinkedList<E> {
	private int size = 0;
	private Node<E> first;
	private Node<E> last;
	
	
	
	public LinkedList() {
        super();
    }

    public void addFirst(E e) {
		Node<E> f = first;
		first = new Node<>(e, null, f);
		if (f == null) {
            last = first;
        } else {
            f.prev = first;
        }
		size++;
	}
	
	public void addLast(E e) {		
		Node<E> l = last;
		last = new Node<>(e, l, null);
		if (l == null) {
			first = last;
		} else {
			l.next = last;
		}
		size++;
	}

	public void addAfter(int index, E e){
	    verifyIndex(index);
	    if (index == size) {
            addLast(e);
        } else {
            linkAfter(e, getNode(index));
        }
	}
	
	public E get(int index){
	    verifyIndex(index);
	    return getNode(index).element;
	}
	    
	public E set(int index, E e) {
	    verifyIndex(index);
	    Node<E> node = getNode(index);
	    E oldVal = node.element;
	    node.element = e;
	    return oldVal;
	}
	    	
	public boolean remove(Object o) {
	    boolean isRemoved = false;
        if (o == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.element == null) {
                    unlink(node);
                    isRemoved = true;
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (o.equals(node.element)) {
                    unlink(node);
                    isRemoved = true;
                }
            }
        }
        return isRemoved;
	}

	public void remove(int index) {
        verifyIndex(index);
        unlink(getNode(index));
    }
	
	public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (o.equals(node.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
	
	public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
	
    private void verifyIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private void linkAfter(E e, Node<E> node){
        Node<E> prev = node.prev;
        node.prev = new Node<>(e, prev, node);
        if (prev == null) {
            first = node.prev;
        } else {
            prev.next = node.prev;
        }
        size++;
    }
        
    private Node<E> getNode(int index) {
        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;   
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }
    
    private void unlink(Node<E> node) {
        Node<E> next = node.next;
        Node<E> prev = node.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.element = null;
        size--;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        
        public Node(E element, Node<E> prev, Node<E> next) {
            super();
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

