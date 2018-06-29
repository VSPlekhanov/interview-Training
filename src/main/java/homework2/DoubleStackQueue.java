package homework2;

public class DoubleStackQueue<T> implements Queue<T> {
    private Stack<T> offerStack;
    private Stack<T> pollStack;

    public DoubleStackQueue(Stack<T> offerStack, Stack<T> pollStack) {
        this.offerStack = offerStack;
        this.pollStack = pollStack;
    }

    public void offer(T value){
        offerStack.push(value);
    }

    public T poll(){
        if (pollStack.isEmpty()){
            if (offerStack.isEmpty()){
                return null;
            }
            while (!offerStack.isEmpty()){
                pollStack.push(offerStack.pop());
            }
        }
        return pollStack.pop();
    }

    public int size(){
        return offerStack.size() + pollStack.size();
    }

    public boolean isEmpty(){
        return offerStack.isEmpty() && pollStack.isEmpty();
    }

}
