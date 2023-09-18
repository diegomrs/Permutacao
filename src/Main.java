
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] elements = {1, 2, 3};
        List<List<Integer>> permutations = generatePermutations(elements);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> generatePermutations(int[] elements) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsHelper(elements, new ArrayList<>(), result);
        return result;
    }

    private static void generatePermutationsHelper(int[] elements, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == elements.length) {
            result.add(new ArrayList<>(permutation)); // Permutation is complete
        } else {
            for (int element : elements) {
                if (!permutation.contains(element)) {
                    permutation.add(element);
                    generatePermutationsHelper(elements, permutation, result);
                    permutation.remove(permutation.size() - 1); // Backtrack
                }
            }
        }
    }
}