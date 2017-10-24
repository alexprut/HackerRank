import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    private int _x;
    private int _y;
    private double _w;

    public Edge(int x, int y, double w) {
        this._x = x;
        this._y = y;
        this._w = w;
    }

    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    public double getW() {
        return this._w;
    }

    public int compareTo(Edge b) {
        if (this._w < b._w) {
            return -1;
        } else if (this._w > b._w) {
            return 1;
        } else {
            if (this._x + this._y + this._w < b._x + b._y + b._w) {
                return -1;
            } else if (this._x + this._y + this._w > b._x + b._y + b._w) {
                return 1;
            }
        }
        return 0;
    }
}

class Node {
    private int _id;
    private HashSet<Integer> _members = new HashSet<Integer>();

    Node(int id) {
        this._id = id;
        this._members.add(this._id);
    }

    public int getId() {
        return this._id;
    }

    public void setMembers(HashSet<Integer> m) {
        this._members = m;
    }

    public HashSet<Integer> getMembers() {
        return this._members;
    }

    public boolean hasMember(Integer id) {
        return this._members.contains(id);
    }
}

public class Solution {

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Edge> path = new ArrayList<Edge>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();

            Edge tmp = new Edge(x, y, w);
            edges.add(tmp);
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            Edge tmp = edges.get(i);
            int indexX = tmp.getX()-1;
            int indexY = tmp.getY()-1;

            Node x = nodes.get(indexX);
            Node y = nodes.get(indexY);

            if (!x.hasMember(y.getId())) {
                path.add(tmp);

                HashSet<Integer> m = x.getMembers();
                m.addAll(y.getMembers());

                Iterator<Integer> iterator = m.iterator();
                while (iterator.hasNext()) {
                    Integer current = iterator.next();
                    nodes.get(current-1).setMembers(m);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i).getW();
        }
        System.out.println(sum);
    }
}
