package sortings;

class selectionSort {
    
    public void sort(int a[])
    {
        int n = a.length;
        for(int i = 0; i<n-1; i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int min=i;
                if(a[j]<a[min])
                {
                    min = j;
                //swap
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
                }
            }
        }
    }
    
    void printArray(int a[])
    {
        int n = a.length;
        for(int k=0; k<n; k++)
    {
        System.out.println( a[k]);
    }
    }
    
    public static void main(String[] args) {
            selectionSort ss = new selectionSort();
            int a[] = {12,434,321431,11,222,110};
            ss.sort(a);
            ss.printArray(a);
            
    }
}