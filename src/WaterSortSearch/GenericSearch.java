package WaterSortSearch;

import java.util.*;

public  class GenericSearch {

    public static String solve(String initialState, String strategy, boolean visualize) {
        return switch (strategy) {
            case "BF" -> BFSSolve(initialState);
            case "DF" -> DFSSolve(initialState);
            case "UC" -> UniCostSolve(initialState);
            default -> "NOSOLUTION";
        };

    }
    public static String BFSSolve(String initialState) {
        Queue<Node> queue=new LinkedList<>();
        Node root=new Node(initialState, null, "", 0, 0);
        Set<Node> visited=new HashSet<>();
        int expandedNodes = 0;

        queue.add(root);
        while(!queue.isEmpty()){
            Node popped=queue.remove();
            if(visited.contains(popped))
                continue;
            expandedNodes++;
            visited.add(popped);
            if(popped.isGoal())
                return popped.getAction() + ";" + popped.getPathCost()+ ";" + expandedNodes;
            ArrayList<Node> children=popped.expand();
            queue.addAll(children);
        }
        return "NOSOLUTION";
    }


    public static String DFSSolve(String initialState) {
        Stack<Node> stack=new Stack<>();
        Set<Node> visited=new HashSet<>();
        Node root=new Node(initialState, null, "", 0, 0);
        int expandedNodes = 0;

        stack.push(root);
        while(!stack.isEmpty()){
            Node popped=stack.pop();
            if(visited.contains(popped))
                continue;
            visited.add(popped);
            expandedNodes++;
            if(popped.isGoal())
                return popped.getAction() + ";" + popped.getPathCost()+ ";" + expandedNodes;
            ArrayList<Node> children=popped.expand();
            for (Node child:children)
                 stack.push(child);
        }
        return null;
    }
    public static String UniCostSolve(String initialState) {
        Set<Node> visited=new HashSet<>();
        Node root= new Node(initialState, null, "", 0, 0);
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(root);
        int expandedNodes = 0;

        while(!priorityQueue.isEmpty()) {
            Node popped=priorityQueue.remove();
            if(visited.contains(popped))
                continue;
            visited.add(popped);
            expandedNodes++;
            if(popped.isGoal())
                return popped.getAction() + ";" + popped.getPathCost()+ ";" + expandedNodes;
            ArrayList<Node> children=popped.expand();
            priorityQueue.addAll(children);
        }
        return null;
    }

//    public Node depthLimitedSearch(String initialState, int depth) {
//        return DFSSolve(initialState, depth);
//    }
//
//    public static Node IDSolve(String initialState) {
//        int depth=0;
//        while(true){
//            Node result=DFSSolve(initialState, depth);
//            if(result!=null)
//                return result;
//            depth++;
//        }
//    }


}
