package homework1;

import java.util.Arrays;

public class FirstHomework {

    public static void main(String[] args) {
    }

    public static int countSymbols(String str, char symbol) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (symbol == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean equalStrings(String[] myStrings) {
        if (myStrings == null) {
            return false;
        }
        boolean equalElements = false;
        for (int indexFirst = 0; indexFirst < myStrings.length; indexFirst++) {
            for (int indexSecond = indexFirst + 1; indexSecond < myStrings.length; indexSecond++) {
                if (myStrings[indexFirst].equals(myStrings[indexSecond]) == true) {
                    equalElements = true;
                }
            }
        }
        return equalElements;
    }

    public static int[][] multiplyMatrixs(int[][] leftMatrix, int[][] rightMatrix) throws IllegalArgumentException {
        if (leftMatrix == null || rightMatrix == null) {
            IllegalArgumentException ex = new IllegalArgumentException("IllegalArgumentException was expected");
            throw ex;
        }
        int lengthResultRow = rightMatrix[0].length;
        int lengthResultColumn = leftMatrix.length;
        int lengthRow1 = leftMatrix[0].length;
        int[][] resultMatrix = new int[lengthResultColumn][lengthResultRow];
        if (leftMatrix[0].length == rightMatrix.length) {
            for (int indexRow = 0; indexRow < lengthResultColumn; indexRow++) {
                for (int indexColumn = 0; indexColumn < lengthResultRow; indexColumn++) {
                    for (int indexAdjacentElement = 0; indexAdjacentElement < lengthRow1; indexAdjacentElement++) {
                        resultMatrix[indexRow][indexColumn] += leftMatrix[indexRow][indexAdjacentElement] * rightMatrix[indexAdjacentElement][indexColumn];
                    }
                }
            }
        } else {
            IllegalArgumentException ex = new IllegalArgumentException("Matrix's dimension doesn't correct!");
            throw ex;
        }
        return resultMatrix;
    }

    public static double[] intersectArrays(double[] firstArray, double[] secondArray) {
        if ((firstArray == null) || (firstArray.length == 0)) {
            return new double[]{};
        }
        if ((secondArray == null) || (secondArray.length == 0)) {
            return new double[]{};
        }
        double[] sortFirstArray = firstArray;
        Arrays.sort(sortFirstArray);
        double[] sortSecondArray = secondArray;
        Arrays.sort(sortSecondArray);

        double[] intersectionArrays = new double[sortFirstArray.length];
        int indexFirst = 0;
        int indexSecond = 0;
        int indexResult = 0;

        while ((indexFirst < sortFirstArray.length) && (indexSecond < sortSecondArray.length)) {
            if (sortFirstArray[indexFirst] == sortSecondArray[indexSecond]) {
                intersectionArrays[indexResult] = sortFirstArray[indexFirst];
                indexFirst++;
                indexSecond++;
                indexResult++;
            } else {
                if (sortFirstArray[indexFirst] < sortSecondArray[indexSecond]) {
                    indexFirst++;
                } else {
                    indexSecond++;
                }
            }
        }
        double[] resultArrays = new double[indexResult];
        System.arraycopy(intersectionArrays, 0, resultArrays, 0, indexResult);
        return resultArrays;
    }

}
