package Heuristic;

import WaterSortSearch.Node;

public class HeuristicOne implements AdmisibleHeuristic {
    @Override
    public int calc(Node n) {
        int heuristicCost1 = 0;
        boolean filled = true;
        for (char[] bottle : n.getBottles()) {
            for (int i = 0; i < bottle.length - 1; i++)
                if (bottle[i] != bottle[i + 1]&&bottle[i]!='e')//check if not equal because the above layer is empty
                    filled = false;
            if (!filled)
                heuristicCost1++;
        }
        return heuristicCost1;
    }
}
