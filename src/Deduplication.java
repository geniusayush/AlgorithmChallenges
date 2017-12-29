/*
   * Complete the functions below. You may declare more variables for this class.
   * Please do NOT rename this class.
*/

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Queue;

public class Deduplication {
    /**
     * function to do deduplicatin of a file
     * the file is stored in custm manner
     * if input is ABABAC
     * the output will be A1,3,5B2,4C
     * the output wil be is reversible i.e the file can be reduplicated
     * assumtion that the files are duplicated more than once
     * why not  external memsorting
     * bst is mpre memory efficient than HM
     */

    static void dedup(String input_file_path, String output_file_path) throws IOException, NoSuchAlgorithmException {

        int bufferSize = 1024;
        int nread = 0;
        byte[] buffer = new byte[bufferSize];
        BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(input_file_path), bufferSize);
        int firstBlock = 0;
        BST bst = new BST();

        while ((nread = input.read(buffer)) > 0) {
            String Hash = getHash(buffer);
            firstBlock++;
            // hash blocNo
            Node newNode = new Node(Hash, firstBlock);
            if (firstBlock == 1) {
                bst.setNode(newNode);

            } else {
                bst.searchMain(Hash, newNode);

            }

        }
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(output_file_path));
        bst.print(output, input);
        input.close();
        output.close();

    }

    /*
    * static clas to represent the data
    * */
    static class Node {
        String hash;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getBlockNo() {
            return blockNo;
        }

        public void setBlockNo(int blockNo) {
            this.blockNo = blockNo;
        }


        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(String hash, int blockNo) {
            this.hash = hash;
            this.blockNo = blockNo;
        }

        int blockNo;
        Queue<Integer> queue;
        Node left;
        Node right;
    }

    static private class BST {
        public Node getNode() {
            return root;
        }

        public void setNode(Node node) {
            this.root = node;
        }

        Node root;

        public boolean searchMain(String hash, Node NewNode) {
            return search(root, hash, NewNode);
        }

        public void print(BufferedOutputStream output, BufferedInputStream input) throws IOException {
            printInorderLoop(root, output, input);
        }

        /*
        lop to iterate the   binary search tree and print the data from the tree into the output file
        * */
        void printInorderLoop(Node node, BufferedOutputStream output, BufferedInputStream input) throws IOException {
            if (node == null)
                return;

        /* first recur on left child */
            printInorderLoop(node.left, output, input);

        /* then print the data of node */
            handle(node, output, input);

        /* now recur on right child */
            printInorderLoop(node.left, output, input);
        }

        /*method to create the output string  for each unique node
        * the sting willbe of size 2 bytes  */
        private void handle(Node node, BufferedOutputStream output, BufferedInputStream input) throws IOException {
            byte[] b = new byte[1024];
            input.read(b, node.blockNo * 1024, 1024);
            output.write(b);
            StringBuilder s = new StringBuilder();
            for (int a : node.queue) {
                if (!s.equals("")) s.append(',');
                s.append(a);
            }
            for (int i = 0; i < 1024 - s.length(); i++) {
                s.append('~');
            }
            output.write(s.toString().getBytes());

        }
        /*
            search the bst for the node .if found add the number to the block
            else else add to the appropriate place
        * */

        public boolean search(Node node, String hash, Node NewNode) {
            // Base Cases: root is null or key is present at root
            if (node.hash.equals(hash)) {
                node.queue.add(NewNode.blockNo);
                return true;
            }
            // val is greater than root's key
            if (root.hash.compareTo(hash) > 0) {
                if (node.left != null) return search(node.left, hash, NewNode);
                else {
                    NewNode.queue.add(NewNode.blockNo);
                    node.left = NewNode;
                    return false;
                }
            } else {
                if (node.left != null) return search(node.right, hash, NewNode);
                else {
                    NewNode.queue.add(NewNode.blockNo);
                    node.right = NewNode;
                    return false;
                }
            }

        }

    }

    /* get SHA-1 hash generated for the code base
    * */
    private static String getHash(byte[] buffer) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(buffer);
        byte[] data = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();

    }

    /* get the file back
    * */
    static boolean redup(String input_file_path, String output_file_path) throws IOException, NoSuchAlgorithmException {
        int bufferSize = 1024;
        int nread = 0;
        byte[] data = new byte[bufferSize];
        byte[] dup = new byte[bufferSize];

        BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(input_file_path), bufferSize);
        int firstBlock = 0;
        REDUPBST bst = new REDUPBST();
        int count = 0;
        while ((nread = input.read(data)) > 0) {

            String Hash = getHash(data);
            input.read(dup);
            String[] indexes = dup.toString().split("~")[0].split(",");
            for (String s : indexes) {
                Node newNode = new Node(Hash, Integer.parseInt(s));
                if (firstBlock == 1) {
                    bst.setNode(newNode);

                } else {
                    bst.searchMain(newNode);

                }
            }

            bst.print(new BufferedOutputStream(new FileOutputStream(output_file_path)), input);
        }

return true;
    }

    static private class REDUPBST {
        public Node getNode() {
            return root;
        }

        public void setNode(Node node) {
            this.root = node;
        }

        Node root;

        public boolean searchMain(Node NewNode) {
            return search(root, NewNode);
        }

        public void print(BufferedOutputStream output, BufferedInputStream input) throws IOException {
            printpreorderLoop(root, output, input);
        }

        /*
        lop to iterate the   binary search tree and print the data from the tree into the output file
        * */
        void printpreorderLoop(Node node, BufferedOutputStream output, BufferedInputStream input) throws IOException {
            if (node == null)
                return;

        /* first recur on left child */
            printpreorderLoop(node.left, output, input);

        /* then print the data of node */
            handle(node, output, input);

        /* now recur on right child */
            printpreorderLoop(node.left, output, input);
        }

        /*\
         * an error here wha we need to do is reload the data from the new file and also feed what its value was initally and take a call on that */
        private void handle(Node node, BufferedOutputStream output, BufferedInputStream input) throws IOException {
            byte[] b = new byte[1024];
            input.read(b, node.blockNo * 1024, 1024);
            output.write(b);

        }
        /*
            search the bst for the node .if found add the number to the block
            else else add to the appropriate place
        * */

        public boolean search(Node node, Node NewNode) {

            if (node.blockNo == NewNode.blockNo) {
                node.queue.add(NewNode.blockNo);
                return true;
            }
            // val is greater than root's key
            if (node.blockNo > NewNode.blockNo) {
                if (node.left != null) return search(node.left, NewNode);
                else {
                    node.left = NewNode;
                    return false;
                }
            } else {
                if (node.left != null) return search(node.right, NewNode);
                else {
                    node.right = NewNode;
                    return false;
                }
            }

        }

    }
}