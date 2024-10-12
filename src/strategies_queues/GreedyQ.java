package strategies_queues;

import Heuristic.AdmisibleHeuristic;
import WaterSortSearch.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GreedyQ implements StrategyQueue {
    PriorityQueue<Node> queue;
    public GreedyQ(AdmisibleHeuristic h) {
        this.queue = new PriorityQueue<>(Comparator.comparing(h::calc));
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
