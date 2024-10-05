import java.util.*;

public  class GenericSearch {

    public Node BFSSolve(Problem problem) {
        Queue<Node> queue=new LinkedList<>();
        Node root=problem.getInitialState();
        Set<Node> visited=new HashSet<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node popped=queue.remove();
            if(visited.contains(popped))
                continue;
            visited.add(popped);
            if(popped.isGoal())
                return popped;
            ArrayList<Node> children=popped.expand();
            queue.addAll(children);
        }
        return null;
    }
    public Node DFSSolve(Problem problem) {
        Stack<Node> stack=new Stack<>();
        Set<Node> visited=new HashSet<>();
        Node root=problem.getInitialState();
        stack.push(root);
        while(!stack.isEmpty()){
            Node popped=stack.pop();
            if(visited.contains(popped))
                continue;
            visited.add(popped);
            if(popped.isGoal())
                return popped;
            ArrayList<Node> children=popped.expand();
            for (Node child:children)
                 stack.push(child);
        }
        return null;
    }
    public Node UniCostSolve(Problem problem) {
        Set<Node> visited=new HashSet<>();
        Node root=problem.getInitialState();
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(root);
        while(!priorityQueue.isEmpty()) {
            Node popped=priorityQueue.remove();
            if(visited.contains(popped))
                continue;
            visited.add(popped);
            if(popped.isGoal())
                return popped;
            ArrayList<Node> children=popped.expand();
            priorityQueue.addAll(children);
        }
        return null;
    }


}
