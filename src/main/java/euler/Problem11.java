package euler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Problem11 {
    public static int findLargestProduct(String rawDataz) {
        List<List<Integer>> dataz = new ArrayList<>();
        for (String line : rawDataz.split("\n")) {
            List<Integer> row = new ArrayList<>();
            for (String num : line.split(" ")) {
                row.add(Integer.parseInt(num));
            }
            dataz.add(row);
        }

        int bestProduct = 0;
        for(int j=0; j<dataz.size()-3; j++) {
            for(int i=0; i<dataz.get(0).size()-3; i++) {
                bestProduct = max(check(i, j, 4, dataz), bestProduct);
            }
        }
        return bestProduct;
    }

    public static int check(int x, int y, int length, List<List<Integer>> dataz) {
        int productRight = 1;
        int productDown = 1;
        int productDownRight = 1;
        int productDownLeft = 1;
        for(int i=0; i<length; i++) {
            productRight *= dataz.get(y).get(x+i);
            productDown *= dataz.get(y+i).get(x);
            productDownRight *= dataz.get(y+i).get(x+i);
            productDownLeft *= dataz.get(y+i).get(x-i+3);
        }
        return max(max(max(productRight, productDown), productDownRight), productDownLeft);
    }
}
