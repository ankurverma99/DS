package org.ankur.ds;


class Node{
    int key;
    Node left,right;

    public Node(int ele){
        key =ele;
        left=right=null;
    }
}
public class BinarySearchTree {
    Node root;

    BinarySearchTree(){
        root=null;
    }

     Node insert(Node node, int ele){
         if(node == null){
             node = new Node(ele);
             return node;
         }

         if(ele <node.key)
             node.left = insert(node.left,ele);
         else if (ele>node.key) {
             node.right = insert(node.right,ele);//null,6
         }
         return node;
    }
    public static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    Node search(Node root,int key){
            if(root == null || root.key == key)
                return root;
            if(key<root.key)
                return search(root.left,key);
            return search(root.right,key);
    }
    Node deleteNode(Node root,int key){//tree,5
        if(root ==  null)
            return root;
        if(key<root.key)
           root.left =  deleteNode(root.left,key);//5,5
        else if (key> root.key) {
            root.right= deleteNode(root.right,key);
        }else {
            if (root.left==null)//3
                return root.right;
            else if (root.right==null)//6
                return root.left;
            root.key = minValue(root.right);//6
            root.right = deleteNode(root.right,root.key);//6,6
        }
    return root;
    }
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(bst.root,9);
        bst.insert(bst.root,5);
        bst.insert(bst.root,11);
        bst.insert(bst.root,3);
        bst.insert(bst.root,15);
        bst.insert(bst.root,6);
        bst.insert(bst.root,10);
        inOrder(bst.root);
        int key =12;
        if(bst.search(bst.root,key)!=null)
            System.out.println(key +" is present in Tree");
        else
            System.out.println(key +" is not present in Tree");
        bst.deleteNode(bst.root,5);
        inOrder(bst.root);
    }
}
