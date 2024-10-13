package Heuristic;

import WaterSortSearch.Node;

public class HeuriticTwo implements AdmisibleHeuristic {

    @Override
    public int calc(Node n) {
        //no of layers
            int heuristicCost2 = 0;
            for (char[] bottle : n.getBottles()) {
                for (int i = 0; i < bottle.length - 1; i++)
                    if (bottle[i] != bottle[i + 1]&&bottle[i]!='e')//check if not equal because the above layer is empty
                        heuristicCost2++;
            }
            return heuristicCost2;
        }


}
