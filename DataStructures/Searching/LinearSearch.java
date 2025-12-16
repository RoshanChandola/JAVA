public class LinearSearch {
    static int linearsearch(int arr[],int key)
    {
        for (int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
            {
                System.out.println("element found at index: "+i);
                return 0;
            }
        }
        System.out.println("element not found");
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50};
        int key=30;
        linearsearch(arr,key);
    }
    
}
