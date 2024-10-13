package strategies_queues;

import WaterSortSearch.Node;

public interface StrategyQueue {

    boolean isEmpty() ;
    Node poll();

    void add(Node node);

}
