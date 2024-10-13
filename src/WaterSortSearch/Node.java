package WaterSortSearch;

public class Node implements Comparable<Node> {
    private final String action;
    private final Node parent;
    private final int pathCost;
    private final char[][] bottles;
    private final int depth;

    public char[][] getBottles() {
        return bottles;
    }

    public String getAction() {
        return action;
    }

    public int getDepth() {
        return depth;
    }


    public int getPathCost() {
        return pathCost;
    }

   public Node getParent(){
        return parent;
   }
    public Node(char[][] bottles, Node parent, int pathCost, String action, int depth) {
        this.bottles = bottles;
        this.parent = parent;
        this.pathCost = pathCost;

        this.depth = depth;
        this.action = action;
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
            for (int j = 0; j < this.bottles[0].length; j++) {
                if (this.bottles[i][j] != other.bottles[i][j])
                    return false;
            }
        return true;
    }


    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.pathCost, o.pathCost);
    }

    //compare to
//    public String toString() {
//        StringBuilder node = new StringBuilder();
//        node.append(" depth is =" + depth + '\n');
//
//        node.append(" action is =" + action + '\n');
//        for (int i = 0; i < bottles.length; i++) {
//            node.append(Arrays.toString(bottles[i]) + '\n');
//        }
//        return node.toString();
//
//    }
    @Override
    public String toString() {
        StringBuilder node = new StringBuilder();
        node.append('\n').append("Depth: ").append(depth).append("\n");
        node.append("Action: ").append(action).append("\n\n");
        int bottleCapacity = bottles[0].length;
        for (int layer = 0; layer <bottleCapacity; layer++) {
            for (char[] bottle : bottles) {
                if (bottle[layer] == 'e') {
                    node.append("|   |      "); // Empty space with extra space for alignment
                } else {
                    node.append("| ").append(bottle[layer]).append(" |      "); // Liquid in the bottle
                }
            }
            node.append("\n"); // Move to the next line after printing one layer of all bottles
        }

        // Add a base to the bottles for clarity with correct alignment
        for (int i = 0; i < bottles.length; i++)
            node.append("bottle").append(i + 1).append("    "); // Base of each bottle with extra space

        node.append("\n");

        return node.toString();
    }
//    public int calculateHeuristicCost1() {//no of bottles
//        int heuristicCost1 = 0;
//        boolean filled = true;
//        for (char[] bottle : bottles) {
//            for (int i = 0; i < bottle.length - 1; i++)
//                if (bottle[i] != bottle[i + 1])
//                    filled = false;
//            if (!filled)
//                heuristicCost1++;
//        }
//        return heuristicCost1;
//    }
//    public int calculateHeuristicCost2() {//no of layers
//        int heuristicCost2 = 0;
//        for (char[] bottle : bottles) {
//            for (int i = 0; i < bottle.length - 1; i++)
//                if (bottle[i] != bottle[i + 1])
//                    heuristicCost2++;
//        }
//        return heuristicCost2;
//    }

}