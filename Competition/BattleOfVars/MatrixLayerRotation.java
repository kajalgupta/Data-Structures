package Competition.BattleOfVars;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MatrixLayerRotation {
    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int columns = matrix.get(0).size();
        int rows = matrix.size();
        System.out.println("----------------------------");
        /*int rotations = r % (2 * (rows - 1) + 2 * (columns - 1) - 1);
        if (rotations == 0) {
            // System.out.println();
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(0).size(); j++) {
                    System.out.print(matrix.get(i).get(j) + " ");
                }
                System.out.println();
            }
        } 
        */
       // else {
            int numberOfStringsGenerated = Math.min(rows, columns) / 2;
            //String[][] str = new String[numberOfStringsGenerated][rotations];
            String[][] finalMatrix = new String[rows][columns];
            for (int boundary = 0; boundary < numberOfStringsGenerated; boundary++) {
                String numStr = "";
                int i = boundary;
                // for (int j = 0; j < columns/2; j++) {
                int length = 0;
                int firstBoundaryColumn = boundary;
                for (i = boundary; i < rows - boundary; i++) {
                    numStr = numStr + " " + matrix.get(i).get(boundary);
                    length++;
                }
                int lastBoundaryRow = rows - 1 - boundary;
                for (int j = firstBoundaryColumn + 1; j < columns - boundary; j++) {
                    // numStr = numStr+" " +matrix.get(i-1).get(j);
                    numStr = numStr + " " + matrix.get(lastBoundaryRow).get(j);
                    length++;
                }
                int lastBoundaryColumn = columns - 1 - boundary;
                for (int k = lastBoundaryRow - 1; k >= boundary; k--) {
                    numStr = numStr + " " + matrix.get(k).get(lastBoundaryColumn);
                    length++;
                }
                int firstBoundaryRow = boundary;
                for (int j = lastBoundaryColumn - 1; j > boundary; j--) {
                    numStr = numStr + " " + matrix.get(firstBoundaryRow).get(j);
                    length++;
                }
                // now numstr contains boundary elements
                // System.out.println("num str is"+numStr);
                // int length = 2*(rows-1)+2*(columns-1); //---------------------length
                // System.out.println("length is"+length);
                // numStr.replaceAll("regex", replacement)
                String numStr2 = new String(numStr.trim());
                // System.out.println("numStr2 is"+numStr2);
                String[] strArray = numStr2.split(" ");
               int rotations = r%length;
                for (int j = 0; j < rotations; j++) {
                    String temp = strArray[length - 1];
                    for (int k = length - 1; k > 0; k--) {
                        strArray[k] = strArray[k - 1];
                    }
                    strArray[0] = temp;
                }
                /*
                 * System.out.println("rotated string"); for (int j = 0; j < strArray.length;
                 * j++) { System.out.print(" "+strArray[j]); }
                 */
                int k = 0;
                // FINAL MATRIX BOUNDARY FIRST COLUMN -
                for (i = boundary; i < rows - boundary; i++) {
                    // " " +matrix.get(i).get(boundary);
                    finalMatrix[i][boundary] = strArray[k++];
                }
                // FINAL MATRIX BOUNDARY LAST ROW -
                for (int j = firstBoundaryColumn + 1; j < columns - boundary; j++) {
                    // numStr = numStr+" " +matrix.get(i-1).get(j);
                    finalMatrix[lastBoundaryRow][j] = strArray[k++];
                }
                // FINAL MATRIX BOUNDARY LAST COLUMN -
                for (int z = lastBoundaryRow - 1; z >= boundary; z--) {
                    // numStr = numStr+" " +matrix.get(k).get(lastBoundaryColumn);
                    finalMatrix[z][lastBoundaryColumn] = strArray[k++];
                }
                // FINAL MATRIX BOUNDARY FIRST ROW -
                for (int j = lastBoundaryColumn - 1; j > boundary; j--) {
                    // numStr = numStr+" "+ matrix.get(firstBoundaryRow).get(j);
                    finalMatrix[firstBoundaryRow][j] = strArray[k++];
                }
                // System.out.println("finallll"+finalMatrix[0][2]);
                // str[x][boundary] = strArray.toString();
                // for (int j = 0; j < strArray.length; j++) {
                // str[boundary][j]= strArray[j];
                // System.out.println(" "+str[boundary][j]);
                // }
                // System.out.println(str[0]);
                // strArray = numStr.toCharArray();
                // System.out.println("num str2 is"+numStr2);
                // StringBuilder rotatedString = new StringBuilder(numStr.replaceAll("\\s+$",
                // "").substring(length-1-r, length)+numStr.substring(0,length-1-r));
                // //numStr.substring(length-1, 1);\
                // System.out.println(numStr.charAt(11));
                // System.out.println(numStr.substring(length-1-r, length));
                // System.out.println("num str is"+numStr);
                // System.out.println("rotated string is"+rotatedString);
                // System.out.println(rotatedString.reverse().toString());
            }
            // StringBuilder rotatedString;
            // System.out.println(rotatedString.reverse().toString());
            for (int j = 0; j < finalMatrix.length; j++) {
                for (int j2 = 0; j2 < columns; j2++) {
                    System.out.print(finalMatrix[j][j2] + " ");
                }
                System.out.println();
            }
        

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);
        bufferedReader.close();
    }
}
