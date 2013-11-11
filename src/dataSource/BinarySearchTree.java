package dataSource;

public class BinarySearchTree
{

   protected BinaryTreeNode root;

   //== Constructors ====================================
   public BinarySearchTree() {
      root = null;
   }

   public BinarySearchTree (Comparable element) {
      root = new BinaryTreeNode (element);
   }

   //== General methods ==================================
   public void removeAllElements() {
      root = null;
   }

   public boolean isEmpty()
   {
      return (root == null);
   }

   public Comparable getRootElement()
   {
      return (Comparable)root.element;
   }

   // Traverse
   //=================================================================
   public String preorderTraversal() {
      String s = new String();
      s = preorderTraverse(root, s);
      return s;
   }

   private String preorderTraverse(BinaryTreeNode n, String s) {
      if (n!=null) {
         s+= n.element + " ";
         s = preorderTraverse(n.left, s);
         s = preorderTraverse(n.right, s);
      }
      return s;
   }
   
   public String inorderTraversal() {
      String s = new String();
      s = inorderTraverse(root, s);
      return s;
   }
   
   private String inorderTraverse(BinaryTreeNode n, String s) {
      if (n!=null) {
         s = inorderTraverse(n.left, s);
         s+= n.element + " ";
         s = inorderTraverse(n.right, s);
      }
      return s;
   }
   
   public String postOrderTraversal() {
      String s = new String();
      s = postOrderTraverse(root, s);
      return s;
   }
   
   private String postOrderTraverse(BinaryTreeNode n, String s) {
      if (n!=null) {
         s = postOrderTraverse(n.left, s);
         s = postOrderTraverse(n.right, s);
         s+= n.element + " ";
      }
      return s;
   }

   //================================================================
   //  AddElement - recursive solution
   //================================================================

   public void addElement (Comparable element) {
	   root = addElementRec(root, element);
   }

   private BinaryTreeNode addElementRec (BinaryTreeNode n, Comparable element) {
      if (n==null) {
           return new BinaryTreeNode(element);
       }
      else
         if (element.compareTo(n.element)<0) {
           n.left = addElementRec(n.left, element);
       }
         else {
           n.right= addElementRec(n.right, element);
       }
      return n;
   }
   //================================================================
   //  AddElement - iterative solution
   //================================================================

   public void addElementIt (BinaryTreeNode n,Comparable element)
   {
        while(element.compareTo(n) == 0) {
           if (n==null) 
           {
              n.element = element;
           }else {
               if(element.compareTo(n)<0)
           {
               n = n.left;
           }else 
               if(element.compareTo(n)>0)
               {
                   n = n.right;
               }
           }
       }
   }

   //================================================================
   //  FindElement - recursive solution
   //================================================================

   public Comparable findNode(Comparable keyNode)
 	{
 		return findNodeRec(root, keyNode);
 	}

   
   private Comparable findNodeRec(BinaryTreeNode n, Comparable keyNode)
   { 
        if (n==null) {
           return null;
       }
      else
         if (keyNode.compareTo(n.element)<0) {
           findNodeRec(n.left, keyNode);
       }
         else
             if (keyNode.compareTo(n.element)>0) {
           findNodeRec(n.right, keyNode);
       }
             else
                 if (keyNode.compareTo(n.element) == 0) {
           return n.element;
       }
        
        return null;
   }
   //================================================================
   //  FindElement - iterative solution
   //================================================================

   public Comparable findNodeIt(BinaryTreeNode n,Comparable keyNode)
   {
       if(n == null)
       {
           return null;
       }else {
           while(n.left != null || n.right != null || keyNode.compareTo(n) == 0) {
           
               if(keyNode.compareTo(n)<0)
           {
               n = n.left;
           }else 
               if(keyNode.compareTo(n)>0)
               {
                   n = n.right;
               }
           }
       }
       return n.element;
   }


    //==  Node class ================================================
    private class BinaryTreeNode {

       protected Comparable element;
       protected BinaryTreeNode left, right;


       BinaryTreeNode (Comparable obj) {
          element = obj;
          left = null;
          right = null;
       }
    }
}


