
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
        public static void main(String[]args){
            String grid0 = "3;" +
                    "4;" +
                    "r,y,r,y;" +
                    "y,r,y,r;" +
                    "e,e,e,e;";
            String grid1 = "5;" +
                    "4;" +
                    "b,y,r,b;" +
                    "b,y,r,r;" +
                    "y,r,b,y;" +
                    "e,e,e,e;" +
                    "e,e,e,e;";
            String grid2 = "5;" +
                    "4;" +
                    "b,r,o,b;" +
                    "b,r,o,o;" +
                    "r,o,b,r;" +
                    "e,e,e,e;" +
                    "e,e,e,e;";
            String grid3 = "6;" +
                    "4;" +
                    "g,g,g,r;" +
                    "g,y,r,o;" +
                    "o,r,o,y;" +
                    "y,o,y,b;" +
                    "r,b,b,b;" +
                    "e,e,e,e;";
            String grid4 = "6;" +
                    "3;" +
                    "r,r,y;" +
                    "b,y,r;" +
                    "y,b,g;" +
                    "g,g,b;" +
                    "e,e,e;" +
                    "e,e,e;";
           System.out.println( WaterSortSearch.solve(grid0, "UC", false));
            System.out.println(   WaterSortSearch.solve(grid1, "UC", false));
            System.out.println(  WaterSortSearch.solve(grid2, "UC", false));
            System.out.println(  WaterSortSearch.solve(grid3, "UC", false));
            System.out.println(   WaterSortSearch.solve(grid4, "UC", false));
        }
    }


