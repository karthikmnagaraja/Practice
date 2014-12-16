package com.dsalgo.leetcode;

/**
 * @author KarthikMNagaraja.
 */
public class CoinChange {

    int count( int S[], int m, int n )
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is consturcted
        // in bottom up manner using the base case (n = 0)
        int[] table= new int[n+1];



        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<m; i++){
            for(int j=S[i]; j<=n; j++){
                table[j] += table[j-S[i]];
                System.out.println("table[j]="+table[j]+" j "+j+" S[i] "+S[i]);
            }
           // System.out.println("i="+table[i]);
        }

        return table[n];
    }

    public static void main(String[] args) {
        int[] arr={5,10,25,50};
        int m= arr.length;
        int n=50;
        CoinChange c= new CoinChange();
        System.out.println(c.count(arr,m,n));

        System.out.println(arr.toString());
    }
}
