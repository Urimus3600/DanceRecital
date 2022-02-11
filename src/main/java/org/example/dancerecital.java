package org.example;

import jdk.internal.org.jline.utils.InputStreamReader;

import javax.naming.ldap.HasControls;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class dancerecital
{
    public static void main( String[] args ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer parse = new StringTokenizer(input.readLine());
        int numDance = Integer.parseInt(input.readLine());
        System.out.println(numDance);

        String[] dances = new String[numDance];
        for(int i=0; i<numDance; i++){
            dances[i] = input.readLine();
        }
         int[][] similar = findSimilar(dances, numDance);
    }

    public static int[][] findSimilar(String[] dances, int numDance){
        int[][] hold = new int[numDance][numDance];
        for(int i=0; i<numDance; i++){
            for(int j=i+1; j<numDance; j++){
                hold[i][j] = stringSimilar(dances[i],dances[j]);
                hold[j][i] = hold[i][j];
                }
        }
        return hold;
    }

    private static int stringSimilar(String one, String two){
        int len1 = one.length();
        int len2 = two.length();
        HashSet<Character> oneToTwo = new HashSet<>();
        for(int i=0; i<len1; i++){
            oneToTwo.add(one.charAt(i));
        }
        for(int i=0; i<len2; i++){
            oneToTwo.add(two.charAt(i));
        }
        return (len1+len2-oneToTwo.size());
    }
}
