package it.unitn.disi.tree;

import java.util.*;

public class Node {
    public static final String LEVEL ="level";

    private String name;
    private ArrayList<Node> children = new ArrayList<>();
    private HashMap<String, Object> properties = new HashMap<>();
    private Object data;

    public Node(){
        setName( UUID.randomUUID().toString() );
    }

    public Node setName(String name){
        this.name = name;
        return this;
    }

    public Node addChild( Node n ){
        children.add( n );
        return this;
    }

    public Node setData( Object newData ){
        data = newData;
        return this;
    }

    public Object setProperties( String name, Object value ){
        return properties.put(name, value);
    }

    public Object getProperties( String key ) {
        return properties.getOrDefault(key, new Object() );
    }

    public String getName(){
        return this.name;
    }

    public Object getData() {
        return data;
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList( children );
    }

    public boolean isLeaf(){
        return children.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("{\"Name\": \"" ).append(getName()).append("\", ");
        s.append("\"children\": ").append(children.size()).append(", ");
        s.append("\"data\": \"").append(getData().toString()).append("\", ");
        s.append("\"properties\": {");
        properties.forEach((key, value) -> {
            s.append("\"").append(key).append("\" : ");
            s.append("").append(value).append(",");
        });
        s.replace(s.length()-1,s.length(),"");
        s.append("}");
        s.append("}");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) &&
                Objects.equals(children, node.children) &&
                Objects.equals(properties, node.properties) &&
                Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, properties, data);
    }
}
