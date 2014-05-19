package com.dsalgo.trees.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KarthikMNagaraja.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode((char) 0);
    }

    public TrieNode getRoot() {
        return root;
    }


    public void setRoot(TrieNode root) {
        this.root = root;
    }

    private static class TrieNode {


        private char value;
        private Map<Character, TrieNode> children;
        private boolean isEnd;


        public TrieNode(char ch) {
            this.value = ch;
            this.children = new HashMap<Character, TrieNode>(0);
            this.isEnd = false;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    public void add(String keyWord) {
        TrieNode node = this.root;
        for (int i = 0; i < keyWord.length(); i++) {
            char key = keyWord.charAt(i);
            Map<Character, TrieNode> children = node.getChildren();
            if (!children.containsKey(key)) {
                TrieNode trieNode = new TrieNode(key);
                children.put(key, trieNode);
            }
            node = children.get(key);
        }
        node.setEnd(true);
    }

    public boolean search(String keyWord) {
        TrieNode node = this.root;
        for (int i = 0; i < keyWord.length(); i++) {
            char key = keyWord.charAt(i);
            Map<Character, TrieNode> children = node.getChildren();
            if (!children.containsKey(key)) {
                return false;
            }
            node = children.get(key);
        }
        if (node.isEnd) {
            return true;
        } else return false;


    }

    /**
     * Recursive depth first search
     *
     * @param node
     * @param value
     */
    public void printAll(TrieNode node, String value) {

        if (node.isEnd) {

            System.out.println(value.toString());

        }
        for (Character ch : node.getChildren().keySet()) {
            printAll(node.getChildren().get(ch), value + ch);
        }


    }

    public static void main(String[] args) {


        Trie trie = new Trie();
        trie.add("baseball");
        trie.add("ball");
        trie.add("actor");
        trie.add("acting");

        System.out.println("trie search ball " + trie.search("ball"));

        trie.printAll(trie.getRoot(), "");
    }
}
