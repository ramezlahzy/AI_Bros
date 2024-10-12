package strategies_queues;

import WaterSortSearch.Node;

import java.util.Stack;

public class DFSQ implements StrategyQueue {
    private final Stack<Node> stack;

    public DFSQ() {
        this.stack = new Stack<>();
    }
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    @Override
    public Node poll() {
      return stack.pop();
    }

    @Override
    public void add(Node node) {
        stack.add(node);
    }
}
