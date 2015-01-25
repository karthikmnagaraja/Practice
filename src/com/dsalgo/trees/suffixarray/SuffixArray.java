package com.dsalgo.trees.suffixarray;

import java.util.Arrays;

/**
 * @author KarthikMNagaraja.
 */
public class SuffixArray {
    private Suffix[] suffixes;

    public Suffix[] getSuffixes() {
        return suffixes;
    }

    public SuffixArray(String str) {
        int N = str.length();
        suffixes = new Suffix[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = new Suffix(str, i);
        }
        Arrays.sort(suffixes);
    }

    private static class Suffix implements Comparable<Suffix> {
        private final String text;
        private final int index;

        public int getIndex() {
            return index;
        }


        @Override
        public String toString() {
            return text.substring(index);
        }

        public Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }

        public int length() {
            return this.text.length() - this.index;
        }

        public char charAt(int i) {
            return this.text.charAt(this.index + i);
        }

        @Override
        public int compareTo(Suffix s2) {
            int N = this.length() < s2.length() ? this.length() : s2.length();
            for (int i = 0; i < N; i++) {
                if (this.charAt(i) < s2.charAt(i)) return -1;
                if (this.charAt(i) > s2.charAt(i)) return +1;
            }
            return this.length() - s2.length();
        }
    }


    public int compare(Suffix text, String pattern) {
        int N = text.length() < pattern.length() ? text.length() : pattern.length();
        for (int i = 0; i < N; i++) {
            if (text.charAt(i) < pattern.charAt(i)) return -1;
            if (text.charAt(i) > pattern.charAt(i)) return +1;
        }
        return text.length() < pattern.length() ? -1 : 0;
    }

    public int length() {
        return suffixes.length;
    }

    public String select(int i) {
        if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException("something went wrong");
        return suffixes[i].toString();
    }



    public int search(String pattern) {
        return binarySearch(0, this.length() - 1, pattern);
    }
    public int lcp(int i){
        if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException("something went wrong");
        return lcp(suffixes[i],suffixes[i-1]);
    }
    public static int lcp(Suffix s,Suffix p){
        int N=s.length()<p.length()?s.length():p.length();
        for (int i = 0; i <N ; i++) {
            if(s.charAt(i)!=p.charAt(i)) return i;
        }
        return N;

    }
    private int binarySearch(int low, int high, String pattern) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        int comp = compare(suffixes[mid], pattern);
        if (comp == 0) return suffixes[mid].getIndex();
        if (comp < 0) return binarySearch(mid + 1, high, pattern);
        else return binarySearch(low, mid - 1, pattern);
    }

    public static void main(String[] args) {
        SuffixArray s = new SuffixArray("banana");
        //System.out.println(s.getSuffixes());
        /*System.out.println(s.search("na"));
        System.out.println(s.search("ban"));
        System.out.println(s.search("nan"));
        System.out.println(s.search("xwz"));
*/
        for (int i = 1; i < s.length(); i++) {
            System.out.println(s.select(i) + "   " + s.getSuffixes()[i].index+" lcp "+s.lcp(i));
        }
    }
}
