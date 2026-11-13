import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class RandomizedSet {
    private final List<Integer> list;
    private final Map<Integer, Integer> map;
    private final Random rand;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }     
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}