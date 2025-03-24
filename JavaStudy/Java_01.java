package JavaStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Java_01 {
    public static void main(String[] args) {
        // 字符：必须用单引号，有且只能有一个字符
        System.out.println('你');
        //字符串：必须是双引号
        System.out.println("你好");

        //数组
        //静态数组
        int[] nums = new int[]{1,2,3};
        int[] nums2 = {1,2,3};
        //动态数组
        int[] nums3 = new int[3];
        nums3[0] = 1;
        nums3[1] = 2;
        nums3[2] = 3;
        System.out.println(Arrays.toString(nums3));
//        System.out.println(Arrays.);

        // 字符串操作
        System.out.println("itheima"+ 666); // 输出:itheima666

//        //输入
//        Scanner scanner = new Scanner(System.in);
//        //表示将键盘录入的值作为int数返回
//        int x = scanner.nextInt();

        /*
        int和String类型的相互转换
        */
        //int转String
        int a = 10;
        String s = String.valueOf(a);
        System.out.println(s);
        //String转int
        String s1 = "123";
        int b = Integer.parseInt(s1);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2,3);
        System.out.println(list.get(1));
        System.out.println(list.indexOf(1));

    }
}
