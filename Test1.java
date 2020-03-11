给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。

 class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i:A){
            sum+=i;
        }
        if(sum%3!=0){
            return false;
        }
        sum/=3;
        int sum1=0;
        int sum2=0;
        int i=0;
        int j=A.length-1;
        for(;i<A.length;i++){
            sum1+=A[i];
            if(sum1==sum){
                break;
            }
                
           
        }
        for(;j>=0;j--){
            sum2+=A[j];
            if(sum2==sum){
                break;
            }
                
          
        }
        return i<j-1;
    }
}

输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        createHeap(arr,arr.length);
        int len=arr.length-1;
        int count=arr.length-k;
        for(;count>0;count--){
            swap(arr,0,len);
            shiftdown(arr,len,0);
            len--;
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
    private void createHeap(int[] arr,int size){
        for(int i=(size-1)/2;i>=0;i--){
            shiftdown(arr,size,i);
        }
    }
    private void swap(int[] arr,int left,int right){
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }
    private void shiftdown(int[] arr,int size,int index){
        int left=2*index+1;
        while(left<size){
            int max=left;
            int right=2*index+2;
            if(right<size){
                if(arr[right]>arr[max]){
                   max=right;
                }
            }
            if(arr[index]>=arr[max]){
                break;
            }
            swap(arr,index,max);

            index=max;
            left=2*index+1;
        }
    }
}

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        mergerSort(arr,0,arr.length);
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
    private void mergerSort(int[] arr,int left,int right){
        if(left>=right-1){
            return;
        }
        int mid=(left+right)>>>1;
        mergerSort(arr,left,mid);
        mergerSort(arr,mid,right);
        merge(arr,left,mid,right);
    }
    private void merge(int[] arr,int left,int mid,int right){
        int i=left;
        int j=mid;
        int len=right-left;
        int[] tmp=new int[len];
        int m=0;
        while(i<mid&&j<right){
            if(arr[i]<arr[j]){
                tmp[m++]=arr[i++];
            }else{
                tmp[m++]=arr[j++];
            }
        }
        while(i<mid){
            tmp[m++]=arr[i++];
        }
        while(j<right){
            tmp[m++]=arr[j++];
        }
        System.arraycopy(tmp,0,arr,left,len);
    }
}

0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int lastRemaining(int n, int m) {
        int res=0;
        for(int i=2;i<=n;i++){
            res=(res+m)%i;
        }
        return res;
    }
}


