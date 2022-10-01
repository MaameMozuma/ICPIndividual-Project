
import java.util.Objects;


public class Node implements Comparable<Node> {
    private Airport state;
    private Node Parent;
    private Route Action;
    private int Path_cost;

    public Node(Airport state, Route action, int path_cost) {
        this.state = state;
        this.Action = action;
        this.Path_cost = path_cost;
    }

    public Node(Airport state, Node parent, Route action, int path_cost) {
        this.state = state;
        this.Parent = parent;
        this.Action = action;
        this.Path_cost = path_cost;
    }

    /**
     * The function takes in a node and returns a string representation of the node
     *
     * @return The state, action, and path cost of the node.
     */
    public String toString() {
        return "Node{state=" + this.state + ", Action=" + this.Action + ", Path_cost=" + this.Path_cost + "}";
    }

    /**
     * If the state of the current node is equal to the state of the node passed in, return 1, else return 0
     *
     * @param n The node to compare to
     * @return 1 if the states are equal, 0 otherwise
     */
    public int compareTo( Node n) {
        if (n == null) {
            return 0;
        }

        return this.getState().equals(n.getState()) ? 1 : 0;
    }

    /**
     * If the object is not null and the state is not null, then return true if the state is equal to the state of the
     * object
     *
     * @param obj The object to compare to.
     * @return The hashcode of the state.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Node)) {
            return false;
        } else {
            Node node = (Node)obj;
            return obj != null && this.state != null ? this.state.equals(node.state) : false;
        }
    }

    /**
     * > The hashCode() function returns a hash code value for the object
     *
     * @return The hashCode of the state.
     */

    /**
     * > The hashCode() function returns a hash code value for the object
     *
     * @return The hashCode of the state.
     */
    public int hashCode() {
        return Objects.hash(new Object[]{this.state});
    }

    /**
     * This function returns the parent of the current node.
     *
     * @return The parent of the node.
     */

    // Returning the parent of the current node.
    public Node getParent() {
        return this.Parent;
    }

    public Airport getState() {
        return this.state;
    }

    /**
     * This function returns the value of the Action variable
     *
     * @return The action of the route.
     */
    public Route getAction() {
        return this.Action;
    }

    /**
     * This function returns the path cost of the node
     *
     * @return The path cost of the node.
     */
    public int getPath_cost() {
        return this.Path_cost;
    }

    // Setting the state of the node.
    public void setState(Airport state) {
        this.state = state;
    }
}
