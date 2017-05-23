import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EnterPoint {
    private static boolean isLine = true;
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) throws FileNotFoundException {
        double[][] arr = readFromFile("data.txt");
    }

    private static double[][] readFromFile(String fileName) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<String> lines = new ArrayList<>();
        reader.lines().forEach(lines::add);
        double[][] numbers = new double[lines.size()][lines.get(0).split("\\w*\\s+").length];
        for (int i = 0; i < lines.size(); i++) {
            String[] strNumbers = lines.get(i).split("\\w*\\s+");
            for (int j = 0; j < strNumbers.length; j++) {
                numbers[i][j] = Double.parseDouble(strNumbers[j]);
            }
        }
        return numbers;
    }

    private static double[] findActualRow(double[][] arr) {
        if (isLine) {
            double[] row = new double[arr.length];
            for (int i = 0; i < arr.length; i++) {
                row[i] = arr[i][x];
            }
            isLine = false;
            return row;
        } else {
            double[] row = new double[arr[0].length];
            for (int i = 0; i < arr[0].length; i++) {
                row[i] = arr[y][i];
            }
            isLine = true;
            return row;
        }
    }
}
