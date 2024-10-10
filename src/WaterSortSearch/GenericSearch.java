package WaterSortSearch;

import java.util.*;

public  class GenericSearch {

    public static String solve(String initialState, String strategy, boolean visualize) {
        char[][] bottles1 = {
                {'b', 'y', 'r', 'b'},
                {'y', 'y', 'r', 'r'},
                {'e', 'b', 'b', 'y'},
                {'e', 'e', 'e', 'r'},
                {'e', 'e', 'e', 'e'}
        };
        char[][] bottles2 = {
                {'b', 'y', 'r', 'b'},
                {'y', 'y', 'r', 'r'},
                {'e', 'b', 'b', 'y'},
                {'e', 'e', 'e', 'r'},
                {'e', 'e', 'e', 'e'}
        };



//                [b, y, r, b]
//[y, y, r, r]
//[e, b, b, y]
//[e, e, e, r]
//[e, e, e, e]

        Node node1=new Node(bottles1,null,12,"",45);
        Node node2=new Node(bottles2,null,0,"",0);
        System.out.println(node1.equals(node2));
        return switch (strategy) {
            case "BF" -> BFSSolve(initialState);
//            case "DF" -> DFSSolve(initialState);
//            case "UC" -> UniCostSolve(initialState);
            default -> "NOSOLUTION";
        };

    }
    public static String BFSSolve(String initialState) {
        Queue<Node> queue=new LinkedList<>();
        Node root=new Node(initialState, null, "", 0, 0);
        Set<Node> visited=new HashSet<>();
        int expandedNodes = 0;

        queue.add(root);
//        System.out.println("root is: ");
//        System.out.println(root);
        int counter=0;
        visited.add(root);
        while(!queue.isEmpty()){
//            if(counter++>100)
//                break;
            System.out.println("queue's size  is: "+queue.size());
            Node popped=queue.poll();
            System.out.println("queue's size  is: "+queue.size());
            System.out.println();
            System.out.println("popped is: ");
            System.out.println("visited is: "+visited);
            System.out.println(popped);
            expandedNodes++;
            if(popped.isGoal())
                return popped.getAction() + ";" + popped.getPathCost()+ ";" + expandedNodes;
            ArrayList<Node> children=popped.expand();
            for (int i = 0; i < children.size(); i++) {
                Node child=children.get(i);
                boolean isVisited=false;
                for (Node node:visited) {
                    if (node.equals(child)) {
                        isVisited = true;
                        break;
                    }
                }
                if(!isVisited) {
                    queue.add(child);
                    visited.add(child);
                }
            }
        }
        return "nosolution";
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
