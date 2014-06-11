package com.dsalgo.trees.binarysearchtree;

import com.dsalgo.trees.common.Node;
import com.dsalgo.trees.common.TreeTraversalUtils;

/**
 * @author KarthikMNagaraja.
 */
public class LowestCommonAncestor<T extends Comparable<T>> {


    public static void main(String[] args) {

        Integer[] a = {5, 3, 2, 7, 4, 6, 8};
        BST<Integer> bst = new BST<Integer>();
        for (Integer n : a)
            bst.insert(n);

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        TreeTraversalUtils utils = new TreeTraversalUtils();
        utils.printLevelOrder(bst.getRoot());
        System.out.println(lowestCommonAncestor.LCA(bst.getRoot(), 2, 7).data);
        System.out.println(lowestCommonAncestor.LCA(bst.getRoot(), 2, 8).data);
        System.out.println(lowestCommonAncestor.LCA(bst.getRoot(), 2, 4).data);

        System.out.println(lowestCommonAncestor.findLevel(2,bst.getRoot(),0));
        System.out.println("distance"+lowestCommonAncestor.findDistance(bst.getRoot(),2,3));


    }

    public int findLevel(T data, Node<T> root,int level) {
        if (root == null) return -1;
        if (root.data.equals(data)) return level;

        int left= findLevel(data,root.left,level+1);

        return left!=-1?left: findLevel(data,root.right,level+1);
    }

    public  int findDistance(Node<T> root,T n1,T n2){

      Node<T>lca=LCA(root,n1,n2);
        return findLevel(n1,root,0)+findLevel(n2,root,0)-2*findLevel(lca.data,root,0);
    }

    public Node LCA(Node<T> root, T n1, T n2) {

        if (root == null)
            return null;
/*
        if(root.data.equals(n1)||root.data.equals(n1)){
            return root;
        }
*/
        if ( root.data.compareTo(n1)>0&&root.data.compareTo(n2)>0) {

            return this.LCA(root.left, n1, n2);
        } else if (root.data.compareTo(n1)<0&&root.data.compareTo(n2)<0) return this.LCA(root.right, n1, n2);
        else return root;
    }
}


