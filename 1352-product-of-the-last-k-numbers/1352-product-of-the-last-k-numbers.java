import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Sentinel value for easy division
    }

    public void add(int num) {
        if (num == 0) {
            // Any product including this 0 becomes 0, so reset the prefix list
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProducts.size();
        // If k is at least the current size, a 0 occurred within the last k numbers
        if (k >= size) {
            return 0;
        }
        return prefixProducts.get(size - 1) / prefixProducts.get(size - k - 1);
    }
}