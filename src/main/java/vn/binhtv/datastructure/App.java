package vn.binhtv.datastructure;

import vn.binhtv.datastructure.list.single.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(1);
        list.append(5);
        list.append(2);
        list.append(3);
        
        list.traverse();
        System.out.println();
        list.remove();
        list.traverse();
        list.append(4);
        System.out.println();
        list.traverse();
        System.out.println();
        System.out.println(list.search(5));
        System.out.println(list.search(3));
        list.append(100, 0);
        list.traverse();
        list.append(200, 4);
        System.out.println();
        list.traverse();
    }
}
