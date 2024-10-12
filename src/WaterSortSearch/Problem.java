//package WaterSortSearch;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Problem {
//    private final char[][] initialState; // Represent the initial state directly
//    private final int numBottles;
//    private final int bottleCapacity;
//
//    public Problem(char[][] initialState) {
//        this.initialState = initialState;
//        this.numBottles = initialState.length;
//        this.bottleCapacity = initialState[0].length;
//    }
//
//    public char[][] getInitialState() {
//        return initialState;
//    }
//
//
//    public ArrayList<Node> expand(char[][] state) {
//        ArrayList<Node> children = new ArrayList<>();
//        for (int i = 0; i < numBottles; i++)
//            for (int j = 0; j < numBottles; j++) {
//                if (i == j)
//                    continue;
//                Node pour1 = pour(state,i, j);
//                if (pour1 != null)
//                    children.add(pour1);
//            }
//        System.out.println("children of depth " + depth + " is:" + children.size());
//        return children;
//
//    }
//
//    private Node pour(char[][] state, int i, int j) {
//        char[][] allBottles = bottles.clone();
//        char[] bottle1 = bottles[i].clone();
//        char[] bottle2 = bottles[j].clone();
//        allBottles[i] = bottle1;
//        allBottles[j] = bottle2;
//        int layer1Pointer = bottle1.length;
//        int layer2Pointer = layer1Pointer;
//        int cost = 0;
//
//        for (int i1 = 0; i1 < bottle1.length; i1++) {
//            if (bottle1[i1] != 'e' && layer1Pointer == bottle1.length)
//                layer1Pointer = i1;
//            if (bottle2[i1] != 'e' && layer2Pointer == bottle2.length)
//                layer2Pointer = i1;
//        }
//        while (layer1Pointer < bottle1.length && layer2Pointer > 0) {
//            if (layer2Pointer < bottle2.length && bottle1[layer1Pointer] != bottle2[layer2Pointer])
//                break;
//            bottle2[--layer2Pointer] = bottle1[layer1Pointer];
//            bottle1[layer1Pointer++] = 'e';
//            cost++;
//        }
//        if (cost == 0)
//            return null;
//        String actions = action.isEmpty() ? "" : action + ",";
//
//        return new Node(allBottles, parent, node.pathCost + cost, actions + "pour_" + i + "_" + j, this.depth + 1);
//    }
//
//    public boolean isGoal(char[][] state) {
//        for (char[] bottle : state) {
//            for (int i = 0; i < bottle.length - 1; i++) {
//                if (bottle[i] != bottle[i + 1]) return false;
//            }
//        }
//        return true;
//    }
//
//    // Additional methods for path cost can be added here if needed
//}
