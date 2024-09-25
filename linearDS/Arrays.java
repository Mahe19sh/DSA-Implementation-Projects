class Arrays{

    //This class is used to demonstrate the problem solving approaches and techniques used to manipulate array data structure.
    int arr[];
    int size;
    int capacity;

    public Arrays(){
        this.arr = new int[10];
        this.capacity = 10;
        this.size = 0;
    }
    public Arrays(int length){
        this.arr = new int[length];
        this.capacity = length;
        this.size = 0;
    }

    public boolean isArrayFull(){ // The use this method is code reusability, we have to check that array is full or not for several operations.
        return size == capacity;
    }

    public boolean isArrayEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void printArray(){
        if(!isArrayEmpty()){
            System.out.print(arr[0]);
            for(int i=1;i<size;i++){
                System.out.print(","+arr[i]);
            }
        }
        else{
            System.out.println("Array is empty");
        }
        System.out.println();
    }

    public void Insert(int num, int index){ //Insertion method to insert data in array at specific index.
        if(isArrayFull()){
            System.out.println("The Array is full, no more insertions");
        }
        else{
            if(index == size){
                arr[size] = num;
                size++;
            }
            else{
                for(int i=size-1;i>=index;i--){
                    arr[i+1] = arr[i];
                }
                arr[index] = num;
                size++;
            }
        }
    }

    public int Search(int key){
        for(int i = 0;i<size;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    public void delete(int k){
        if(!isArrayEmpty()){
            int idx = Search(k);
            if(idx < 0){
                System.out.println("There is no such number found in array");
            }
            else{
                int numToDelete = arr[idx];
                for(int i=idx+1;i<size;i++){
                    arr[i-1] = arr[i];
                }
                size--;
                System.out.println("The deleted data is "+numToDelete);
            }
        }
        else{
            System.out.println("The array is empty to delete");
        }
    }

    public void printRotated(int k){ // k indicates the number of elements that we want to rotate. (shift all the elements after kth element to left by k positions.)
        int[] rotArr = rotate(arr, k);
        for(int i=0;i<size;i++){
            System.out.print(rotArr[i] + ",");
        }
        System.out.println();
    }

    public int[] rotate(int[] array, int k){
        if(k % size == 0){
            return array;
        }

        for(int i=0;i<k;i++){
            int x = array[0];
            for(int j=1;j<size;j++){
                array[j-1] = array[j];
            }
            array[size-1] = x;
        }
        return array;
    }

    // The Sliding Window Technique can be very useful in converting or transforming a solution that uses nested for loop to a single for loop which reduces the time complexity.

    // Example to demonstrate the usage of sliding window technique, Sum of k consecutive elements in an array.

    public void maxSumOfk(int k){
        System.out.println("Maximum sum of elements in the given array: "+ sumOfK(arr, k));
    }

    private int sumOfK(int array[], int k){
        if(size < k){
            return -1;
        }

        int window_sum = 0;
        for(int i=0;i<k;i++){
            window_sum += array[i];
        }

        int max_sum = window_sum;
        for(int i=k;i<size;i++){
            window_sum += (array[i] - array[i-k]);
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    // The prefixSum array of any array , arr[] is defined as an array of same size, say prefixSum[] such that the value at index i is equal to sum of values from 0 to i in arr[].

    public void prefixsumPrint(){
        int[] array = prefixSum(arr);

        for(int data:array){
            System.out.print(data + ",");
        }

        System.out.println();
    }

    private int[] prefixSum(int[] array){
        int pfxSum[] = new int[size];
        pfxSum[0] = array[0];

        for(int i=1;i<size;i++){
            pfxSum[i] = pfxSum[i-1] + array[i];
        }

        return pfxSum;
    }

    //removing duplicate elements from sorted array without using hashset. optimal algorithm just returning the size of new array.

    public void removeDuplicateSize(){
        System.out.println("The new size of array after deleting duplicate elements: "+removeDuplicate(arr));
    }

    private int removeDuplicate(int[] array){
        if(size == 0){
            return -1;
        }

        int index = 0;

        for(int i=1;i<size;i++){
            if(array[i] != array[index]){
                index++;
                array[index] = array[i];
            }
        }

        return index+1;
    }

}