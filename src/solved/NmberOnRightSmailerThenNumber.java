package solved;

import java.util.LinkedHashMap;

/*A Self Balancing Binary Search Tree (AVL, Red Black,.. etc) can be used to get the solution in O(nLogn) time complexity. We can augment these trees so that every node N contains size the subtree rooted with N. We have used AVL tree in the following implementation.

We traverse the array from right to left and insert all elements one by one in an AVL tree.
 While inserting a new key in an AVL tree, we first compare the key with root.
  If key is greater than root, then it is greater than all the nodes in left subtree of root.
  So we add the size of left subtree to the count of smaller element for the key being inserted.
We recursively follow the same approach for all nodes down the root.*/
public class NmberOnRightSmailerThenNumber {
    public static LinkedHashMap<String, String> codeTheSolution(LinkedHashMap<String, String> inputLinkHashMap) {
        Character[] arr = inputLinkHashMap.keySet().toArray(new Character[4]);
        int countSmaller[] = new int[arr.length];
        int i, j;

        // initialize all the counts in countSmaller array as 0
        for (i = 0; i < arr.length; i++)
            countSmaller[i] = 0;

        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    countSmaller[i]++;
            }
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        for (int k = 0; k < arr.length; k++) {
            map.put(countSmaller[i] + "", "f");
        }
        return map;
    }
}
