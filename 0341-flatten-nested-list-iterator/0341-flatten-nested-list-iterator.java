public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    public Integer next() {
        return stack.pop().getInteger();
    }
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            
            if (curr.isInteger()) {
                return true;
            }        
            stack.pop();
            List<NestedInteger> list = curr.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }
}