package edu.wpi.cs3733.d20.teamL.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Edge {

    //TODO make private & getters/setters
    private Node source;
    private Node destination;
    private String id;

    public HashMap<String, Object> data = new HashMap<>();


    public Edge(String id, Node source, Node destination) {
        this.id = id;
        setSource(source);
        this.destination = destination;
    }

    public Edge(Node source, Node destination) {
        this.id = source.getID() + "_" + destination.getID();
        setSource(source);
        this.destination = destination;
    }

    public double getLength() {
        return source.getPosition().distance(destination.getPosition());
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for source, the node this edge comes from.
     *
     * @return The Node object that this edge comes from
     */
    public Node getSource() {
        return source;
    }

    /**
     * Setter for source
     *
     * @param newSource The Node that is to be the new source Node for this Edge
     */
    public void setSource(Node newSource) {
        if (source != null) source.getEdges().remove(this);
        if (newSource != null) newSource.getEdges().add(this);
        source = newSource;
    }

    public ArrayList<String> toArrayList() {
        return new ArrayList<>(Arrays.asList(getID(), getSource().getID(), getDestination().getID()));
    }

    /**
     * Checks if all the fields of this edge are the same as the other edge.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge otherEdge = (Edge) obj;

            if (!getID().equals(otherEdge.getID())) return false;
            if (!getSource().equals(otherEdge.getSource())) return false;
            if (!getDestination().equals(otherEdge.getDestination())) return false;
            
            return true;
        } else  {
            throw new IllegalArgumentException("'equals()' must compare this with another Edge.");
        }
    }
}
