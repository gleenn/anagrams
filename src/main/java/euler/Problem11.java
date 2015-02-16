package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

import static java.lang.Math.max;
import static java.util.stream.IntStream.of;
import static java.util.stream.IntStream.range;

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

//        return dataz.stream();

        int bestProduct = 0;
        for (int j = 0; j < dataz.size() - 3; j++) {
            for (int i = 0; i < dataz.get(0).size() - 3; i++) {
                bestProduct = max(check(i, j, 4, dataz), bestProduct);
            }
        }
        return bestProduct;
    }

    public static int check(int x, int y, int length, List<List<Integer>> dataz) {
        IntBinaryOperator product = (left, right) -> left * right;

        return of(
                range(0, length).map(i -> dataz.get(y).get(x + i)).reduce(1, product),
                range(0, length).map(i -> dataz.get(y + i).get(x)).reduce(1, product),
                range(0, length).map(i -> dataz.get(y + i).get(x+i)).reduce(1, product),
                range(0, length).map(i -> dataz.get(y + i).get(x-i+length-1)).reduce(1, product)
        ).max().getAsInt();
    }
}
