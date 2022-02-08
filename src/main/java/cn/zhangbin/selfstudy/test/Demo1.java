package cn.zhangbin.selfstudy.test;

import java.util.*;

/**
 * 给定一个二叉树的根节点root，返回它的中序遍历结果。
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arrs = {1,2,3,35,6,5,35,35,35,35,35,4,2};
        Tree tree = new Tree();
        for (int i = 0; i < arrs.length; i++) {
            tree.add(arrs[i]);
        }
        System.out.println(Arrays.toString(tree.toArray()));

    }
}
class Tree{
    private ArrayList<Integer> returnData; // 全部数据
    private int foot = 0; // 脚标控制
    private Queue<Node> queue = new LinkedList<>(); // 创建队列保存结点
    private int count;
    private boolean flag = true; // 判断当前结点的左右子树是否均创建完成
    private Node poll; // 队列中取出的结点


    private class Node{
        private int data; // 数据
        private Node parent; // 父节点
        private Node left;  // 左子树
        private Node right; // 右子树

        public Node(int data){
            this.data = data; // 构造方法
        }
        public void addNode(Node newNode){
            if (this.left == null){ // 若当前结点无左子树
                this.left = newNode; //将新节点作为当前结点的左子树
                newNode.parent = this; // 将新节点的父节点设为当前结点
            }else{ // 若当前结点无左子树
                this.right = newNode; //将新节点作为当前结点的左子树
                newNode.parent = this; // 将新节点的父节点设为当前结点

            }
        }



        /**
         * 实现所有数据的获取处理,按照中序遍历来完成
         */
        public void toArrayNode(){
            if (this.left!= null){ // 有左子树
                this.left.toArrayNode();
            }
            if(this.data != 35){ // 若结点值不为35即不等于'#' 则添加至数组
                Tree.this.returnData.add(this.data);
            }
            if (this.right != null){ // 判断是否有右子树
                this.right.toArrayNode();
            }
        }

    }
    private Node root; // 根节点

    public void add(int data){
        Node node = new Node(data);
        this.queue.offer(node);
        if (this.root == null){
            this.root = node;
        }else{
            if (this.flag == true){ // 判断是否已经取出结点
                this.poll = this.queue.poll();
                if (this.poll!=null){ // 若结点不为空则进行添加结点
                    this.poll.addNode(node);
                    this.flag = false;
                }
            }else { //若已经取出结点则判断当前结点是否添加右结点
                if (this.poll!=null){
                    this.poll.addNode(node);
                    this.flag = true;
                }
            }
        }
        this.count++;
    }

    /**
     * 以结点形式返回全部数据,若无数据则返回null
     * @return
     */
    public int[] toArray(){
        if (this.count == 0){
            return null;
        }
        this.foot = 0; // 脚标清零
        this.returnData = new ArrayList<>(); // 初始化returnData数组对象
        this.root.toArrayNode(); // 取出所有值添加至动态数组
//        this.root.toPreNode();
        int[] arrs = new int[Tree.this.returnData.size()]; // 根据动态数组大小创建数组
        for (int i = 0; i < arrs.length; i++) { // 将元素添加至数组
            arrs[i] = Tree.this.returnData.get(i);
        }
        return arrs; // 返回全部数据
    }

}
