import java.util.*;

public class Traversals {

  /**
   * Returns the sum of the values of all leaf nodes in the given tree of integers.
   * A leaf node is defined as a node with no children.
   * If node is null, this method returns 0.
   *
   * @param node the node of the tree
   * @return the sum of leaf node values, or 0 if the tree is null
   */
  public static int sumLeafNodes(TreeNode<Integer> node) {
    if(node == null) {
      return 0;
    }
    if(node.left == null && node.right == null) {
      return node.value;
    }
    int leftLeafs = sumLeafNodes(node.left);
    int rightLeafs = sumLeafNodes(node.right);
    return leftLeafs + rightLeafs;
  }

  /**
   * Counts the number of internal nodes (non-leaf nodes) in the given tree of integers.
   * An internal node has at least one child.
   * If node is null, this method returns 0.
   *
   * @param node the node of the tree
   * @return the count of internal nodes, or 0 if the tree is null
   */
  public static int countInternalNodes(TreeNode<Integer> node) {
    if(node == null) {
      return 0;
    }
    int total = 0;
    int leftCount = countInternalNodes(node.left);
    int rightCount = countInternalNodes(node.right);
    if(node.left != null || node.right != null) {
      total++;
    }

    return leftCount + rightCount + total;
  }

  /**
   * Creates a string by concatenating the string representation of each node's value
   * in a post-order traversal of the tree. For example, if the post-order visitation
   * encounters values "a", "b", and "c" in that order, the result is "abc".
   * If node is null, returns an empty string.
   *
   * @param node the node of the tree
   * @param <T>  the type of values stored in the tree
   * @return a post-order traversal string, or an empty string if the tree is null
   */
  public static <T> String buildPostOrderString(TreeNode<T> node) {
    if(node == null) {
      return "";
    }
    String leftString = buildPostOrderString(node.left);
    String rightString = buildPostOrderString(node.right);
    return leftString + rightString + node.value.toString();
  }

  /**
   * Collects the values of all nodes in the tree level by level, from top to bottom.
   * If node is null, returns an empty list.
   *
   * @param node the node of the tree
   * @param <T>  the type of values stored in the tree
   * @return a list of node values in a top-to-bottom order, or an empty list if the tree is null
   */
  public static <T> List<T> collectLevelOrderValues(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    queue.add(node);
    List<T> valuesList = new ArrayList<>();

    while(!queue.isEmpty()) {
      TreeNode<T> currentNode = queue.poll();
      if (currentNode == null) continue;
      valuesList.add(currentNode.value);
      queue.add(currentNode.left);
      queue.add(currentNode.right);
    }

    return valuesList;
  }

  /**
   * Counts the distinct values in the given tree.
   * If node is null, returns 0.
   *
   * @param node the node of the tree
   * @return the number of unique values in the tree, or 0 if the tree is null
   */
  public static int countDistinctValues(TreeNode<Integer> node) {
    Stack<TreeNode<Integer>> stack = new Stack<>();
    stack.push(node);
    Set<Integer> setInts = new HashSet<>();

    while(!stack.empty()) {
      TreeNode<Integer> curr = stack.pop();
      if(curr == null) continue;
      setInts.add(curr.value);
      stack.push(curr.right);
      stack.push(curr.left);
    }
    return setInts.size();
  }

  /**
   * Determines whether there is at least one root-to-leaf path in the tree
   * where each successive node's value is strictly greater than the previous node's value.
   * If node is null, returns false.
   *
   * @param node the node of the tree
   * @return true if there exists a strictly increasing root-to-leaf path, false otherwise
   */
  public static boolean hasStrictlyIncreasingPath(TreeNode<Integer> node) {
    if(node == null) {
      return false;
    }
    if(node.left == null && node.right == null) {
      return true;
    }
    boolean rightSide = node.right != null && node.left.value > node.value && hasStrictlyIncreasingPath(node.right);
    boolean leftSide = node.left != null && node. right.value > node.value && hasStrictlyIncreasingPath(node.left);
    return rightSide || leftSide;
  }

  // OPTIONAL CHALLENGE
  /**
   * Checks if two trees have the same shape. Two trees have the same shape
   * if they have exactly the same arrangement of nodes, irrespective of the node values.
   * If both trees are null, returns true. If one is null and the other is not, returns false.
   *
   * @param nodeA the node of the first tree
   * @param nodeB the node of the second tree
   * @param <T>   the type of values stored in the trees
   * @return true if the trees have the same shape, false otherwise
   */
  public static <T> boolean haveSameShape(TreeNode<T> nodeA, TreeNode<T> nodeB) {
    if(nodeA == null && nodeB == null) {
      return true;
    }
    if(nodeA == null || nodeB == null) {
      return false;
    }

    return haveSameShape(nodeA.left, nodeB.left) && haveSameShape(nodeA.right, nodeB.right);
  }


  // OPTIONAL CHALLENGE
  // Very challenging!
  // Hints:
  // List.copyOf may be helpful
  // Consider adding a helper method
  // Consider keeping the current path in a separate variable
  // Consider removing the current node from the current path after the node's subtrees have been traversed.
  /**
   * Finds all paths from the root to every leaf in the given tree.
   * Each path is represented as a list of node values from root to leaf.
   * The paths should be added pre-order.
   * If node is null, returns an empty list.
   * 
   * Example:
   *
   *         1
   *        / \
   *       2   3
   *      / \    \
   *     4   5    6
   * 
   * Expected output:
   *   [[1, 2, 4], [1, 2, 5], [1, 3, 6]]
   * 
   * @param node the root node of the tree
   * @return a list of lists, where each inner list represents a root-to-leaf path in pre-order
   */
  public static <T> List<List<T>> findAllRootToLeafPaths(TreeNode<T> node) {
    return null;
  }
}
