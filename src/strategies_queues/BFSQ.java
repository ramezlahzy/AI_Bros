package strategies_queues;

import WaterSortSearch.Node;

import java.util.Queue;
import java.util.LinkedList;

public class BFSQ  implements StrategyQueue{

    private final Queue<Node> queue;
    public BFSQ(){
        this.queue = new LinkedList<>();
    }
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    @Override
    public Node poll() {
        return queue.poll();
    }

    @Override
    public void add(Node node) {
        queue.add(node);
    }


}