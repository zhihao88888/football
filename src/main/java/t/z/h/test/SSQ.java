package t.z.h.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @author tianzhihao
 * 利用贝叶斯算法对SSQ进行改良
 * 提高命中率
 * */
public class SSQ {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] b = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int[] c = new int[6];
		for (int i = 0; i < 6; i++) {
			Integer k = getRandomNum(a, new int[]{9445,10199,9572,10112,9944,10228,9521,9623,10346,10028,10437,10084,9623,9396,10940,11737,9220,9440,9970,9496,10027,9347,10750,11049,10257,9179,9889,10467,10228,9781,10718,9470,11730});
			c[i]=k;
		}
		List<Integer> c1 = new ArrayList<Integer>();
		for (int i = 0; i < c.length; i++) {
			if (!c1.contains(c[i])) {
				c1.add(c[i]);
			}
		}
		Integer[] c3 = new Integer[c1.size()];
		for (int i = 0; i < c1.size(); i++) {
				c3[i]=c1.get(i);
//			System.out.print(c1.get(i)+" ");
		}
		
		Random rd = new Random(System.currentTimeMillis());
		int idx = rd.nextInt(c3.length);
		if(idx == 0){
			return;
		}
		List<Integer> list = new ArrayList<Integer>();
		int[] array = new int[6];
		for(int i = 0; i < 6; i++){ // 数随机
		    // 随机数组
		    int tmpIdx = rd.nextInt(c3.length); 
		    // 重复
		    while(list.contains(tmpIdx) ) 
		        tmpIdx = rd.nextInt(c3.length);   
		    list.add(tmpIdx);
		    array[i]=c3[tmpIdx];
		  //System.out.print( a[tmpIdx]+" " ); // 数字随机
		}
		int tmpIdx=0;
		for(int i = 0; i < 1; i++){ // 数随机
		    // 随机数组
		    tmpIdx = rd.nextInt(b.length); 
		    // 重复
		    while( list.contains(tmpIdx) ) 
		        tmpIdx = rd.nextInt(b.length);   
		    list.add(tmpIdx);
		   // array[i]=a[tmpIdx];
		  //System.out.print( a[tmpIdx]+" " ); // 数字随机
		}
		
		   for(int i = 0 ; i < array.length ; i ++) {
			    for(int j = i +1 ; j < array.length ; j ++) {
			    	if(array[i] > array[j]) {
			    		int temp = array[i];
			    		array[i] = array[j];
			    		array[j] = temp;
			    	}
			    }
			}
			for(int i = 0 ; i < array.length ; i ++) {
			    System.out.print(" "+array[i]+" ");
			}
			System.out.println("| "+b[tmpIdx]);
//	        System.out.println(    getRandomNum(array, new int[]{21,19,20,10,15,15}));
	}
	
    //probability 与 arr 一一对应的表示 arr 中各个数的概率，且满足 probability 各元素和不能超过 100；
    public static int getRandomNum(int[] arr, int[] probability){
        if(arr.length != probability.length) return Integer.MIN_VALUE;
        Random ran = new Random();
        int ran_num = ran.nextInt(332255);//332255
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += probability[i];
            if(ran_num < temp)
                return arr[i];
        }
        return Integer.MIN_VALUE;
    }
}
