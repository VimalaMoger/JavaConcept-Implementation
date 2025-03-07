package hackerRankChallenges;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}
class SumInLeavesVisitor extends TreeVis {

    static ArrayList listChildren = new ArrayList();
    int sum=0;
    public int getResult() {
        //sum of values in the tree's leaves
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();

    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long prod=1;
    private final int M = 1000000007;
    public int getResult() {
        //product of values stored in all red nodes
        return (int)prod;
    }

    public void visitNode(TreeNode node) {  //visitNonLeafNodes
        if(node.getColor() == Color.RED){
            prod = (prod * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.RED)
            prod  = (prod * leaf.getValue())%M;
    }
}

class FancyVisitor extends TreeVis {
    int diff, sumGreen, sumNonLeafAtEvenDepth, index =0;
    public int getResult() {
        //|sum(non-leaf nodes at even dept)-sum(green-leaf nodes)|
        diff = Math.abs(sumNonLeafAtEvenDepth - sumGreen);
        return diff;
    }

    public void visitNode(TreeNode node) {
        //implement this
        //visit tree's nonleaf nodes
        if(node.getDepth() %2 ==0) {
            sumNonLeafAtEvenDepth += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this //visit tree's leaf nodes

        if(leaf.getColor()== Color.GREEN){
            sumGreen += leaf.getValue();
        }
    }
}

public class VisitorPatternV2 {
    static HashMap<Integer, HashSet<Integer>> map;
    static int[] in1;
    static Color[] in2;

    public static Tree solve(){
        //read the tree from STDIN and return its root as a return value of this function

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        in1 = new int[n];
        in2 = new Color[n];
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            in1[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            in2[i] = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        /* Save undirected edges */
        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            /* Edges given first direction */
            HashSet<Integer> uNeighbors = map.get(u);
            if (uNeighbors == null) {
                uNeighbors = new HashSet<>();
                map.put(u, uNeighbors);
            }
            uNeighbors.add(v);

            /* Edges given second direction */
            HashSet<Integer> vNeighbors = map.get(v);
            if (vNeighbors == null) {
                vNeighbors = new HashSet<>();
                map.put(v, vNeighbors);
            }
            vNeighbors.add(u);
        }
            scan.close();

        /* Return a tree with one node */
            if (n == 1) {
            return new TreeLeaf(in1[0], in2[0], 0);
        }

        /* Tree root  */
        TreeNode root = new TreeNode(in1[0], in2[0], 0);
        addAChild(root, 1);
        return root;
    }

    //Recursion for adding children to a tree
    private static void addAChild(TreeNode root, Integer key) {
        Tree tree;
        for (Integer value : map.get(key)) {   //loop through map values set
            map.get(value).remove(key);
            HashSet<Integer> childSet = map.get(value);

            if (childSet != null && !childSet.isEmpty()) {  //check to see if value contains a set of values
                tree = new TreeNode(in1[value - 1], in2[value - 1], root.getDepth() + 1);
            } else {
                tree = new TreeLeaf(in1[value - 1], in2[value - 1], root.getDepth() + 1);
            }
            root.addChild(tree);

            if (tree instanceof TreeNode) {   //recursive way - visiting node's children
                addAChild((TreeNode) tree, value);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();

        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}




//read the tree from STDIN and return its root as a return value of this function
/*5 - num of nodes in the tree  4-l7-r2  2-l5-r12
get result  sum = 7+5+12  product 4.2.5    |4 -(7+12 green)|


/*5 - num of nodes in the tree  4-l7-r2  2-l5-r12
get result  sum = 7+5+12  product 4.2.5    |4 -(7+12 green)|
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5


Testcase-2
100
863 168 757 485 356 683 94 592 675 579 697 864 690 205 616 393 451 846 526 394 10 446 910 323 18 661 866 588 110 783 859 897 96 819 87 167 351 942 924 234 717 533 252 495 612 105 958 62 174 467 711 557 757 965 605 855 49 139 579 71 971 176 672 368 720 862 588 294 621 752 458 200 862 973 856 607 352 222 761 937 32 109 172 304 819 373 53 911 531 848 187 123 359 591 356 252 669 584 581 531
1 1 0 0 1 1 1 0 1 1 1 0 1 1 1 0 1 1 0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0 0 0 1 1 1 0 1 0 1 0 1 0 1 1 0 0 1 0 1 1 1 0 1 1 0 1 1 0 1 1 0 0 1 0 0 1 0 1 1 1 0 1 0 0 1 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 1 0
1 33
1 66
1 35
1 6
1 41
1 10
1 96
1 46
1 81
1 83
1 20
1 89
1 58
1 92
1 61
1 30
1 32
2 33
2 49
2 4
2 40
2 11
2 44
2 77
2 17
2 28
2 19
2 36
2 21
2 54
2 88
2 26
2 59
2 76
2 75
2 86
3 99
3 70
3 94
3 41
3 43
3 78
3 47
3 16
3 15
3 62
4 68
4 34
4 9
4 45
4 79
4 51
4 52
4 53
4 25
4 27
4 93
5 97
5 33
5 67
5 72
5 8
5 85
5 31
6 55
6 13
6 14
6 48
6 22
6 23
6 57
7 97
7 38
7 73
7 12
7 50
7 24
7 29
8 100
8 80
8 18
8 87
8 56
8 95
9 65
9 71
9 74
9 82
9 64
10 39
11 84
12 69
12 42
12 91
12 37
13 90
13 98
14 60
17 63

 */