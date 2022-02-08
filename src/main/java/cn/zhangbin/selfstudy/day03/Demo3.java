package cn.zhangbin.selfstudy.day03;

import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        BinaryTress<Person> tree = new BinaryTress<Person>();
        tree.add(new Person("张三",80));
        tree.add(new Person("李四",50));
        tree.add(new Person("王五",60));
        tree.add(new Person("赵六",30));
        tree.add(new Person("陈七",10));
        tree.add(new Person("木八",55));
        tree.add(new Person("文九",70));
        tree.add(new Person("安十",85));
        tree.add(new Person("文一",95));
        tree.remove(new Person("李四",50));
        System.out.println(Arrays.toString(tree.toArray()));
    }
}

/**
 * 实现二叉树操作
 * @param <T> 要进行二叉树的是吸纳
 */
class BinaryTress<T extends Comparable<T>>{

    private class Node{
        private Comparable<T> data; // 存放Comparable,可以比较大小
        private Node parent; // 存放父节点
        private Node left; // 存放左子树
        private Node right; // 存放右子树
        public Node(Comparable<T> data){ // 构造方法直接负责进行数据的存储
            this.data = data;
        }
        /**
         * 实现结点数据的适当位置存储
         * @param newNode 新建的结点
         */
        public void addNode(Node newNode){
            if (newNode.data.compareTo((T)this.data) <= 0){ // 比当前结点小
                if (this.left == null){ // 判断是否有左子树
                    this.left = newNode; // 将结点赋值为左子树
                    newNode.parent = this; // 保存父节点
                }else { // 需要向左边继续判断
                    this.left.addNode(newNode); // 继续向下判断
                }
            }else{ // 比根节点的数据更大
                if (this.right == null){ // 判断是否有右子树
                    this.right = newNode; //将结点赋值为右子树
                    newNode.parent = this; // 保存父节点
                }else { // 继续向下判断
                    this.right.addNode(newNode);
                }
            }
        }

        public boolean containsNode(Comparable<T> data){
            if (data.compareTo((T) this.data) == 0){
                return true; //查找到了相应结点
            }else if (data.compareTo((T) this.data)<0){ // 如果左边有值
                if (this.left!=null){
                    return this.left.containsNode(data);
                }else {
                    return false;
                }
            }else { // 如果右边有值
                if (this.right != null){
                    return this.right.containsNode(data);
                }else {
                    return false;
                }
            }
        }

        public Node getRemoveNode(Comparable<T> data){
            if (data.compareTo((T) this.data) == 0){
                return this; //查找到了相应结点
            }else if (data.compareTo((T) this.data)<0){ // 如果左边有值
                if (this.left!=null){
                    return this.left.getRemoveNode(data);
                }else {
                    return null;
                }
            }else { // 如果右边有值
                if (this.right != null){
                    return this.right.getRemoveNode(data);
                }else {
                    return null;
                }
            }
        }

        /**
         * 实现所有数据的获取处理,按照中序遍历来完成
         */
        public void toArrayNode(){
            if (this.left!= null){ // 有左子树
                this.left.toArrayNode();
            }
            BinaryTress.this.returnData[BinaryTress.this.foot++] = this.data;
            if (this.right != null){
                this.right.toArrayNode();
            }
        }

        /**
         * 根据先序遍历
         */
        public void toPreNode(){
            BinaryTress.this.returnData[BinaryTress.this.foot++] = this.data;
            if(this.left!= null)
                this.left.toPreNode();
            if (this.right!=null)
                this.right.toPreNode();
        }
    }

    // 二叉树功能的实现
    private Node root; // 保存根节点
    private int count; // 结点个数
    private Object[] returnData; // 全部数据
    private int foot = 0; // 脚标控制

    /**
     * 进行数据的保存
     * @param data 要保存的数据内容
     * @exception NullPointerException 保存为空数据时需抛出的异常
     */
    public void add(Comparable<T> data){
        if (data == null){
            throw new NullPointerException("结点保存的数据不能为空!");
        }
        // 所有的数据本身不具备有结点关系的匹配.那么一定要将其包装至Node类中
        Node newNode = new Node(data); // 保存为结点
        if (this.root == null){
            this.root = newNode; // 将结点保存为根节点
        }else { // 需要为其保存一个合适的结点位置
            this.root.addNode(newNode); // 交由Node类负责处理
        }
        this.count++; // 统计结点的个数
    }

    /**
     * 以结点形式返回全部数据,若无数据则返回null
     * @return
     */
    public Object[] toArray(){
        if (this.count == 0){
            return null;
        }
        this.foot = 0; // 脚标清零
        this.returnData = new Object[this.count]; // 初始化returnData数组对象
        this.root.toArrayNode();
//        this.root.toPreNode();
        return this.returnData; // 返回全部数据
    }

    public void remove(Comparable<T> data){
        if (this.root == null){ // 根节点不存在
            return; //结束调用
        }else{
            if (this.root.data.compareTo((T) data) == 0){ // 确定要删除的结点为根节点
                Node moveNode = this.root.right; // 移动的结点
                while (moveNode.left != null){ // 现在还有左边的结点
                    moveNode = moveNode.left; // 向左查找
                }// 删除结点右节点的最小值
                moveNode.left = this.root.left;
                moveNode.right = this.root.right;
                moveNode.parent.left = null;
                this.root = moveNode; // 改变根节点
            }else{
                Node removeNode = this.root.getRemoveNode(data); // 找到要删除的结点
                if (removeNode != null){ // 若找到检点则
                    if (removeNode.left == null && removeNode.right == null){ // 没有任何结点
                        removeNode.parent.left = null;
                        removeNode.parent.right = null;
                        removeNode.parent = null; // 父节点直接断开引用
                    } else if(removeNode.left != null && removeNode.right == null) { // 有左节点
                        removeNode.parent.left = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                    }else  if (removeNode.left == null && removeNode.right != null){ //有右子树
                        removeNode.parent.left = removeNode.right;
                        removeNode.right.parent = removeNode.parent;
                    }else { // 左右结点都不存在
                        Node moveNode = removeNode.right; // 移动结点
                        while(moveNode.left != null){ // 现有的左节点
                            moveNode = moveNode.left; // 一直左找
                        }
                        removeNode.parent.left = moveNode;
                        moveNode.parent.left = null; //断开原本链接
                        moveNode.parent = removeNode.parent;
                        moveNode.right = removeNode.right;
                        moveNode.left = removeNode.left;
                    }
                }
                count -- ;
            }
        }

    }
}
