import java.util.Arrays;

public class PracticeProblem {

    public static void main(String[] args) {
        // Test the methods
        int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] results = compareSearch(numbers, 7);
        System.out.println("Sequential loops: " + results[0] + ", Binary loops: " + results[1]);
        
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        int[] stringResults = compareStringSearch(words, "cherry");
        System.out.println("Sequential loops: " + stringResults[0] + ", Binary loops: " + stringResults[1]);
    }
    
    // Compare sequential vs binary search for integers
    public static int[] compareSearch(int[] array, int number) {
        int[] loops = new int[2]; // [sequential, binary]
        
        // Sequential search
        loops[0] = 0;
        for (int i = 0; i < array.length; i++) {
            loops[0]++;
            if (array[i] == number) {
                break;
            }
        }
        
        // Binary search (array must be sorted)
        loops[1] = 0;
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            loops[1]++;
            int mid = (left + right) / 2;
            
            if (array[mid] == number) {
                break;
            } else if (array[mid] < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return loops;
    }
    
    // Compare sequential vs binary search for strings
    public static int[] compareStringSearch(String[] array, String word) {
        int[] loops = new int[2]; // [sequential, binary]
        
        // Sequential search
        loops[0] = 0;
        for (int i = 0; i < array.length; i++) {
            loops[0]++;
            if (array[i].equals(word)) {
                break;
            }
        }
        
        // Binary search (array must be sorted alphabetically)
        loops[1] = 0;
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            loops[1]++;
            int mid = (left + right) / 2;
            
            if (array[mid].equals(word)) {
                break;
            } else if (array[mid].compareTo(word) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return loops;
    }
}

