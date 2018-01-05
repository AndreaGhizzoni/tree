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

    public static String printTreeInDOT( String name, Node tree ){
        StringBuffer buffer = new StringBuffer();
        buffer.append("digraph ").append(name).append(" {\n");
        pT_DOT( buffer, tree );
        buffer.append("}");
        return buffer.toString();
    }

    private static void pT_DOT( StringBuffer buf, Node n ){
        n.getChildren().forEach( child -> {
            buf.append("\t\"").append(n.getName()).append("\"");
            buf.append(" -> ");
            buf.append("\"").append(child.getName()).append("\"\n");
            pT_DOT( buf, child );
        });
    }

    public static boolean searchForData( Node tree, Object data ){
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
