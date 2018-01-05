package it.unitn.disi.tree;

import java.util.UUID;

public class Launcher {
    public static Node buildDEMOTree(int height){
        return bT( height-1, 0 );
    }

    private static Node bT( int maxHeight, int currentDeep ){
        Node localRoot = new Node();
        localRoot.setData( UUID.randomUUID().toString() );
        localRoot.setProperties(Node.LEVEL, currentDeep);

        if( currentDeep == maxHeight ) return localRoot;

        int finalCurrentDeep = currentDeep+1;
        for( int i=0; i<3; i++ )
            localRoot.addChild( bT(maxHeight, finalCurrentDeep) );
        return localRoot;
    }

    private static Node buildTreeManual(){
        Node root = new Node();
        root.setName("Root").setData(45).setProperties(Node.LEVEL, 0);

        Node c1 = new Node();
        c1.setName("c1").setData(245).setProperties(Node.LEVEL, 1);
        Node c11 = new Node();
        c11.setName("c11").setData(8868).setProperties(Node.LEVEL, 2);
        Node c12 = new Node();
        c12.setName("c12").setData(42).setProperties(Node.LEVEL, 2);
        Node c121 = new Node();
        c121.setName("c121").setData(1993).setProperties(Node.LEVEL, 3);
        c12.addChild(c121);
        c1.addChild(c11).addChild(c12);

        Node c2 = new Node();
        c2.setName("c2").setData(9766).setProperties(Node.LEVEL, 1);
        root.addChild(c1).addChild(c2);

        return root;
    }

    public static void main(String...args){
//        Node tree = buildDEMOTree( 3 );
        Node tree = buildTreeManual();

        System.out.println("Custom print =============");
        Util.printTree(tree);
        System.out.println("==========================\n");

        System.out.println("Searching Data ===========");
        Object toSearch = 42;
        boolean found = Util.searchForData(tree, toSearch);
        System.out.printf("data %s is save on the tree ? %b\n", toSearch, found);
        System.out.println("==========================\n");

        System.out.println("DOT print ================");
        System.out.println( Util.printTreeInDOT("Tree", tree) );
        System.out.println("==========================\n");
    }
}
