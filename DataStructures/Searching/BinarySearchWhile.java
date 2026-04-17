package Searching;

public class BinarySearchWhile {
    static void binarySearch(int arr[],int left ,int right,int key)
    {
        while(left<=right)
        {
            int mid=(right+left)/2;
            if(arr[mid]==key)
            {
                System.out.println("element found at index: "+mid);
                return;
            }
            else if(key<arr[mid])
            {
                right=mid-1;
            }
            else if(key >arr[mid])
            {   
                left=mid+1;
            }
        }
        System.out.println("element not found");
    }
    public static void main(String[] args) {
        int arr[]={-10,20,30,40,50};
        int key=-1;
        int left=0;
        int right=arr.length-1;
        binarySearch(arr,left,right,key);
    }
}
