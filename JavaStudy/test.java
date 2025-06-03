package JavaStudy;

import java.util.ArrayList;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();
        String[] parts = input.split(" ");
        ArrayList<String> res = new ArrayList<>();
        // 报文长度
        int length = Integer.parseInt(parts[0], 16);
        res.add("00"); // 占住

        for(int i = 1; i < parts.length; i++){
            String s = parts[i];
            if(s.equals("A")){
                res.add("12");
                res.add("34");
            }else if(s.equals("B")){
                res.add("AB");
                res.add("CD");
            }else {
                res.add(s);
            }
        }
        int length2 = res.size();
        res.set(0,Integer.toString(length + 1));
        System.out.print(String.join(" ",res));
    }

}