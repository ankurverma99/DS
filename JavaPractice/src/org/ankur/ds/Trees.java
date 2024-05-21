package org.ankur.ds;

public class Trees {
    int val;

    Trees left,right;

    public Trees(int ele) {
        this.val = ele;
        left=right=null;
    }
}
class BinaryTree{
    Trees root;
    BinaryTree(int key){
        root = new Trees(key);
    }
    BinaryTree(){
        root = null;
    }
    public static void inOrder(Trees root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }
    public static void preOrder(Trees root){
        if(root!=null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Trees root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    public static boolean compare(Trees root1,Trees root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        return (root1.val == root2.val) && compare(root1.left,root2.left) && compare(root1.right,root2.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root=new Trees(1);
        bt.root.left=new Trees(2);
        bt.root.right=  new Trees(3);
        bt.root.left.left= new Trees(4);
        bt.root.left.right= new Trees(5);
        bt.root.right.left = new Trees(6);
        System.out.println("InOreder : ");
        inOrder(bt.root);
        System.out.println("PreOreder : ");
        preOrder(bt.root);
        System.out.println("PostOreder : ");
        postOrder(bt.root);
        BinaryTree bt1 = new BinaryTree();
        bt1.root=new Trees(1);
        bt1.root.left=new Trees(2);
        bt1.root.right=  new Trees(3);
        bt1.root.left.left= new Trees(4);
        bt1.root.left.right= new Trees(5);
        bt1.root.right.right = new Trees(6);
        System.out.println("Compare");
        System.out.println(compare(bt.root,bt1.root));
        System.out.println("------------------------------------");
        BinaryTree tr = new BinaryTree(9);
        tr.root.left=new Trees(8);
        tr.root.right= new Trees(10);
        inOrder(tr.root);
    }
}
