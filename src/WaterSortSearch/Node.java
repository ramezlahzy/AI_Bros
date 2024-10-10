package WaterSortSearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Node implements Comparable<Node> {
    private final Node parent;

    public String getAction() {
        return action;
    }

    public int getDepth() {
        return depth;
    }

    private String action;
    private final int depth;

    public int getPathCost() {
        return pathCost;
    }

    private  int pathCost;
    private final char[][] bottles;


    public Node(char[][] bottles,Node parent,int pathCost,String action,int depth) {
        this.bottles=bottles;
        this.parent=parent;
        this.pathCost=pathCost;

        this.depth= depth;
        this.action=action;
    }
    public Node(String state, Node parent, String action, int depth, int pathCost) {
        this.parent = parent;
        this.action = action;
        this.depth = depth;
        this.pathCost = pathCost;
        String[] states = state.split(";");
        int numBottles = Integer.parseInt(states[0]);
        int bottleCapacity = Integer.parseInt(states[1]);
        bottles = new char[numBottles][bottleCapacity];
        for (int i = 0; i < numBottles; i++) {
            String[] bottles = states[2 + i].split(",");
            for (int j = 0; j < bottles.length; j++)
                this.bottles[i][j] = bottles[j].charAt(0);
        }
    }

    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;

        for (int i = 0; i < this.bottles.length; i++)
            for (int j = 0; j < this.bottles[0].length; j++){
                if (this.bottles[i][j] != other.bottles[i][j])
                    return false;
            }
        return true;
    }

    public ArrayList<Node> expand() {
        ArrayList<Node> children = new ArrayList<>();
        for (int i = 0; i < bottles.length; i++)
            for (int j = 0; j < bottles.length; j++) {
                if (i == j)
                    continue;
                Node pour1 = pour(i, j);
                if(pour1!=null)
                  children.add(pour1);
            }
        System.out.println("children of depth "+depth+" is:"+children.size());
        return children;
    }


    private Node pour(int i, int j) {
        char[][] allBottles = bottles.clone();
        char[] bottle1 = bottles[i].clone();
        char[] bottle2 = bottles[j].clone();
        allBottles[i]=bottle1;
        allBottles[j]=bottle2;
        int layer1Pointer = bottle1.length;
        int layer2Pointer = layer1Pointer;
        int cost=0;

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
        if (cost ==0)
            return null;
//        System.out.println("action is "+action);
//        System.out.println("depth is "+depth);
        String actions = action.isEmpty() ?"":action + ",";

        return new Node(allBottles,parent,this.pathCost+ cost,actions+"pour_"+i+"_"+j,this.depth+1);
    }

    public boolean isGoal() {
        for (char[] bottle : bottles)
            for (int i = 0; i < bottle.length - 1; i++)
                if (bottle[i] != bottle[i + 1])
                    return false;
        return true;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.pathCost, o.pathCost);
    }
    //compare to
    public String toString(){
        StringBuilder node= new StringBuilder();
        node.append(" depth is ="+depth + '\n');

        node.append(" action is ="+action + '\n');
        for (int i = 0; i < bottles.length; i++) {
            node.append(Arrays.toString(bottles[i])+'\n');
        }
        return node.toString();

    }


}
