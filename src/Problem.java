import java.util.List;

public class Problem {

    Node initialState;

    public Problem(String state) {
        this.initialState = new Node(state,null,null,0,0);
    }

    public Node getInitialState() {
        return initialState;
    }

    public boolean goalTest(String state) {
        // Define the goal condition
        return false;  // Change to your goal condition
    }

    public List<Node> expand(Node node) {
        return node.expand();
    }

}