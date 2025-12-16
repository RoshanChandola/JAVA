
public class BinarySearch {
    static void binarySearch(int arr[],int left ,int right,int key)
    {
        int mid=(right+left)/2;
        if (left>right)
        {
            System.out.println("element not found");
            return;
        }
        else if(arr[mid]==key)
            {
                System.out.println("element found at index: "+mid);
            }
        else if(key<arr[mid])
            {

            binarySearch(arr,left,mid-1, key);
            }
        else if(key>arr[mid])
            {   
            binarySearch(arr,mid+1,right,key);
            }
        
    }
    public static void main(String[] args) {
        int arr[]={-10,20,30,40,50};
        int key=-1;
        int left=0;
        int right=arr.length-1;
        binarySearch(arr,left,right,key);
    }
    
}
