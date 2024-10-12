
package WaterSortSearch;


import Heuristic.HeuristicOne;
import Heuristic.HeuriticTwo;
import strategies_queues.*;

public class WaterSortSearch extends GenericSearch{

    public static String solve(String initialState, String strategy, boolean visualize) {
            StrategyQueue queue;
             int stoplevel=-1;
            // Select the appropriate strategy queue based on the strategy argument
            switch (strategy) {
                case "BF":
                    queue = new BFSQ(); // Queue for BFS
                    break;
                case "DF":
                    queue = new DFSQ(); // Stack for DFS
                    break;
                case "ID":
                    return iterativeDeepeningSearch(initialState, visualize);
                case "UC":
                    queue = new USCQ(); // Queue for UCS
                    break;
                case "GR1":
                    queue = new GreedyQ(new HeuristicOne());
                    break;
                case "GR2":
                    queue = new GreedyQ(new HeuriticTwo());
                    break;
                case "AS1":
                    queue = new AStarQ(new HeuristicOne());
                    break;
                case "AS2":
                    queue = new AStarQ(new HeuriticTwo());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid strategy");
            }

            return generalSearch(initialState, queue,stoplevel);
        }

        private static String iterativeDeepeningSearch(String initialState, boolean visualize) {
            String sol="";
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sol= generalSearch(initialState, new DFSQ(),i);
                if (!sol.equals("STOPEDLEVEL"))
                    return sol;
            }
            return "NOSOLUTION";

        }
    }


