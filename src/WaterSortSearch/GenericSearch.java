package WaterSortSearch;

import strategies_queues.StrategyQueue;

import java.util.*;

public  abstract class   GenericSearch {

////////////////if iterative should the expanded nodes sum of all iterations or only last one?????
    public static String generalSearch(String initialState, StrategyQueue queue, int stopLevel) {
        Set<Node> visited = new HashSet<>();
        int expandedNodes = 0;
        Node root = new Node(initialState, null, "", 0, 0);
        queue.add(root);
        boolean isStopedLevel = false;
        while (!queue.isEmpty()) {

            Node popped = queue.poll();
            expandedNodes++;

            if (popped.isGoal()) {
                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
            }
            ArrayList<Node> children = popped.expand();
            if (stopLevel==-1||popped.getDepth() < stopLevel){
                for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                boolean isVisited = false;
                for (Node node : visited) {
                    if (node.equals(child)) {
                        isVisited = true;
                        break;
                    }
                }
                if (!isVisited) {
                    queue.add(child);
                    visited.add(child);
                }
            }

        }else
                isStopedLevel = true;
        }
        if (isStopedLevel)
           return "STOPEDLEVEL";
        return "NOSOLUTION";

    }

}























































//    public static String solve(String initialState, String strategy, boolean visualize) {
//
//        return switch (strategy) {
//            case "BF" -> BFSSolve(initialState);
//            case "DF" -> DFSSolve(initialState);
//            case "UC" -> UniCostSolve(initialState);
//            case "ID" -> IDSolve(initialState);
//            case "GR1" -> Greedy1Solve(initialState);
//            case"GR2"-> Greedy2Solve(initialState);
//            case "AS1" -> AStar1(initialState);
//            case"AS2"-> AStar2(initialState);
//            default -> "NOSOLUTION";
//        };
//
//    }
//
//    public static String BFSSolve(String initialState) {
//        Queue<Node> queue = new LinkedList<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        Set<Node> visited = new HashSet<>();
//        int expandedNodes = 0;
//
//        queue.add(root);
//        visited.add(root);
//        while (!queue.isEmpty()) {
//            Node popped = queue.poll();
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            ArrayList<Node> children = popped.expand();
//            for (int i = 0; i < children.size(); i++) {
//                Node child = children.get(i);
//                boolean isVisited = false;
//                for (Node node : visited) {
//                    if (node.equals(child)) {
//                        isVisited = true;
//                        break;
//                    }
//                }
//                if (!isVisited) {
//                    queue.add(child);
//                    visited.add(child);
//                }
//            }
//        }
//        return "NOSULOTION";
//    }
//
//
//    public static String DFSSolve(String initialState) {
//        Stack<Node> stack = new Stack<>();
//        Set<Node> visited = new HashSet<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        int expandedNodes = 0;
//
//        stack.push(root);
//        visited.add(root);
//        while (!stack.isEmpty()) {
//            Node popped = stack.pop();
//
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            ArrayList<Node> children = popped.expand();
//            for (int i = 0; i < children.size(); i++) {
//                Node child = children.get(i);
//                boolean isVisited = false;
//                for (Node node : visited) {
//                    if (node.equals(child)) {
//                        isVisited = true;
//                        break;
//                    }
//                }
//                if (!isVisited) {
//                    stack.add(child);
//                    visited.add(child);
//                }
//            }
//        }
//        return "NOSOLUTION";
//    }

//    public static String UniCostSolve(String initialState) {
//        Set<Node> visited = new HashSet<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(root);
//        visited.add(root);
//        int expandedNodes = 0;
//
//        while (!priorityQueue.isEmpty()) {
//            Node popped = priorityQueue.poll();
//
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            ArrayList<Node> children = popped.expand();
//            for (int i = 0; i < children.size(); i++) {
//                Node child = children.get(i);
//                boolean isVisited = false;
//                for (Node node : visited) {
//                    if (node.equals(child)) {
//                        isVisited = true;
//                        break;
//                    }
//                }
//                if (!isVisited) {
//                    priorityQueue.add(child);
//                    visited.add(child);
//                }
//            }
//        }
//        return "NOSOLUTION";
//    }

//    public static String DepthLimitedSearch(String initialState, int level) {
//        Stack<Node> stack = new Stack<>();
//        Set<Node> visited = new HashSet<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        int expandedNodes = 0;
//
//        stack.push(root);
//        visited.add(root);
//        boolean isStopedLevel = false;
//        while (!stack.isEmpty()) {
//            Node popped = stack.pop();
//
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            if (popped.getDepth() < level) {
//
//                ArrayList<Node> children = popped.expand();
//                for (int i = 0; i < children.size(); i++) {
//                    Node child = children.get(i);
//                    boolean isVisited = false;
//                    for (Node node : visited) {
//                        if (node.equals(child)) {
//                            isVisited = true;
//                            break;
//                        }
//                    }
//                    if (!isVisited) {
//                        stack.add(child);
//                        visited.add(child);
//                    }
//                }
//            } else
//                isStopedLevel = true;
//        }
//        if (isStopedLevel)
//            return "STOPEDLEVEL";
//
//        return "NOSOLUTION";
//    }
//
//    public static String IDSolve(String initialState) {
//        String sol;
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            sol = DepthLimitedSearch(initialState, i);
//            if (!sol.equals("STOPEDLEVEL"))
//                return sol;
//        }
//        return "NOSOLUTION";
//    }
//
//    public static String Greedy1Solve(String initialState) {
//        Set<Node> visited = new HashSet<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.calculateHeuristicCost1()-o2.calculateHeuristicCost1();
//            }
//        });
//        priorityQueue.add(root);
//        visited.add(root);
//        int expandedNodes = 0;
//
//        while (!priorityQueue.isEmpty()) {
//            Node popped = priorityQueue.poll();
//
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            ArrayList<Node> children = popped.expand();
//            for (int i = 0; i < children.size(); i++) {
//                Node child = children.get(i);
//                boolean isVisited = false;
//                for (Node node : visited) {
//                    if (node.equals(child)) {
//                        isVisited = true;
//                        break;
//                    }
//                }
//                if (!isVisited) {
//                    priorityQueue.add(child);
//                    visited.add(child);
//                }
//            }
//        }
//        return "NOSOLUTION";
//    }
//    public static String Greedy2Solve(String initialState) {
//        Set<Node> visited = new HashSet<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.calculateHeuristicCost2()-o2.calculateHeuristicCost2();
//            }
//        });
//        priorityQueue.add(root);
//        visited.add(root);
//        int expandedNodes = 0;
//
//        while (!priorityQueue.isEmpty()) {
//            Node popped = priorityQueue.poll();
//
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            ArrayList<Node> children = popped.expand();
//            for (int i = 0; i < children.size(); i++) {
//                Node child = children.get(i);
//                boolean isVisited = false;
//                for (Node node : visited) {
//                    if (node.equals(child)) {
//                        isVisited = true;
//                        break;
//                    }
//                }
//                if (!isVisited) {
//                    priorityQueue.add(child);
//                    visited.add(child);
//                }
//            }
//        }
//        return "NOSOLUTION";
//    }public static String AStar1(String initialState) {
//        Set<Node> visited = new HashSet<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return (o1.calculateHeuristicCost1()+o1.getPathCost())-(o2.calculateHeuristicCost1()+o2.getPathCost());
//            }
//        });
//        priorityQueue.add(root);
//        visited.add(root);
//        int expandedNodes = 0;
//
//        while (!priorityQueue.isEmpty()) {
//            Node popped = priorityQueue.poll();
//
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            ArrayList<Node> children = popped.expand();
//            for (int i = 0; i < children.size(); i++) {
//                Node child = children.get(i);
//                boolean isVisited = false;
//                for (Node node : visited) {
//                    if (node.equals(child)) {
//                        isVisited = true;
//                        break;
//                    }
//                }
//                if (!isVisited) {
//                    priorityQueue.add(child);
//                    visited.add(child);
//                }
//            }
//        }
//        return "NOSOLUTION";
//    }
//
//    public static String AStar2(String initialState) {
//        Set<Node> visited = new HashSet<>();
//        Node root = new Node(initialState, null, "", 0, 0);
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return (o1.calculateHeuristicCost2()+o1.getPathCost())-(o2.calculateHeuristicCost2()+o2.getPathCost());
//            }
//        });
//        priorityQueue.add(root);
//        visited.add(root);
//        int expandedNodes = 0;
//
//        while (!priorityQueue.isEmpty()) {
//            Node popped = priorityQueue.poll();
//
//            expandedNodes++;
//            if (popped.isGoal())
//                return popped.getAction() + ";" + popped.getPathCost() + ";" + expandedNodes;
//            ArrayList<Node> children = popped.expand();
//            for (int i = 0; i < children.size(); i++) {
//                Node child = children.get(i);
//                boolean isVisited = false;
//                for (Node node : visited) {
//                    if (node.equals(child)) {
//                        isVisited = true;
//                        break;
//                    }
//                }
//                if (!isVisited) {
//                    priorityQueue.add(child);
//                    visited.add(child);
//                }
//            }
//        }
//        return "NOSOLUTION";
//    }

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


//}
