package it.unitn.disi.tree;

import java.util.Iterator;

public class Util {
    public static void printTree(Node n){
        pT(n, 0);
    }

    private static void pT( Node n, int deep ){
        for( int i=0; i<deep; i++ )
            System.out.print("---");
        System.out.println(n.toString());

        int finalDeep = deep+1;
        n.getChildren().forEach(node -> pT(node, finalDeep));
    }

    public static boolean searchForData(Node tree, Object data){
        if( tree.getData().equals(data) ) {
            return true;
        }else {
            boolean found = false;
            Iterator<Node> iterator = tree.getChildren().iterator();
            while( !found ){
                if( !iterator.hasNext() ) break;
                found = searchForData( iterator.next(), data );
            }
            return found;
        }
    }
}
