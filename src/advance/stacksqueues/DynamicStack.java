package advance.stacksqueues;

public class DynamicStack extends CustomStack {

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public void push(int item) {
        if (this.isFull()){
            // Double the array size
            int[] temp = new int[data.length * 2];

            // Copy all previous items in new data
            for (int i = 0; i < data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        // Array is not full at this point.
        // insert in the parent method
        super.push(item);
    }
}
