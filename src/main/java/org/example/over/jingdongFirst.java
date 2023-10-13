package org.example.over;

public class jingdongFirst {
    public static int index=-1;
    public static jingdongFirst main;
    public static void main(String[] args) {
        int[] num=new int[]{2,3,4,5};
        binarysearch(num,3,0,num.length);
        if(index==-1){
            System.out.println("未找到");
        }else {

            System.out.println(index);
        }
    }

    private jingdongFirst() {

    }
    public static jingdongFirst getMain(){
        if(main==null){
            main=new jingdongFirst();

        }
        return main;
    }

    public static void binarysearch(int[] num,int tar,int left,int right){
        //二分查找
        //mid=(left+right)/2
        //如果num[mid]>tar
        int mid = (left+right)/2;
        if(num[mid]>tar){
            right=mid-1;
            binarysearch(num,tar,left,right);
        }else if(num[mid]<tar){
            left=mid+1;
            binarysearch(num,tar,left,right);
        }else{
            index=mid;
        }

    }

}
