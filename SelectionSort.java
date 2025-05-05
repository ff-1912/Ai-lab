class Main{
static void selectionSort(int arr[],int n)
{
  for(int i=0;i<n-1;i++)
  {
    int index=i;
    for(int j=i+1;j<n;j++)
    {
     if(arr[index]>arr[j])
     {
       index=j;
     }
   }
   int temp=arr[index];
   arr[index]=arr[i];
   arr[i]=temp;
 }
}
public static void main(String args[])
{
  int arr[]={9,14,3,4,43,11,58,23};
  int n=arr.length;
  selectionSort(arr,n);
  System.out.println("after sorting");
  for(int i=0;i<arr.length;i++)
  {
     System.out.println(arr[i]);
  }
}
}