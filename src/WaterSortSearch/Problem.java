package WaterSortSearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {
Node root;
int expandedNodes;
public Problem(String intialState){
    root= new Node(intialState, null, "", 0, 0);
    expandedNodes=0;
}
public boolean isGoal(Node node) {
        for (char[] bottle :node.getBottles())
            for (int i = 0; i < bottle.length - 1; i++)
                if (bottle[i] != bottle[i + 1]&&bottle[i]!='e')
                    return false;
        return true;
}
    public ArrayList<Node> expand(Node node) {
        ArrayList<Node> children = new ArrayList<>();
        for (int i = 0; i < node.getBottles().length; i++)
            for (int j = 0; j < node.getBottles().length; j++) {
                if (i == j)
                    continue;
                Node pour1 = pour(i, j,node);
                if (pour1 != null)
                    children.add(pour1);
            }
        return children;
    }


    private Node pour(int i, int j,Node node) {
        char[][] allBottles = node.getBottles().clone();
        char[] bottle1 = node.getBottles()[i].clone();
        char[] bottle2 = node.getBottles()[j].clone();
        allBottles[i] = bottle1;
        allBottles[j] = bottle2;
        int layer1Pointer = bottle1.length;
        int layer2Pointer = layer1Pointer;
        int cost = 0;

        for (int i1 = 0; i1 < bottle1.length; i1++) {
            if (bottle1[i1] != 'e' && layer1Pointer == bottle1.length)
                layer1Pointer = i1;
            if (bottle2[i1] != 'e' && layer2Pointer == bottle2.length)
                layer2Pointer = i1;
        }
        while (layer1Pointer < bottle1.length && layer2Pointer > 0) {
            if (layer2Pointer < bottle2.length && bottle1[layer1Pointer] != bottle2[layer2Pointer])
                break;
            bottle2[--layer2Pointer] = bottle1[layer1Pointer];
            bottle1[layer1Pointer++] = 'e';
            cost++;
        }
        if (cost == 0)
            return null;
        String actions = node.getAction().isEmpty() ? "" : node.getAction() + ",";

        return new Node(allBottles, node.getParent(), node.getPathCost() + cost, actions + "pour_" + i + "_" + j, node.getDepth() + 1);
    }


}
