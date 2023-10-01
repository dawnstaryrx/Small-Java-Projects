package yrx;

import java.util.Scanner;

/**
 * ClassName: Utility
 * Package: yrx
 * Description:
 *              工具类
 * @Author yrx
 * @Create 2023/10/1 8:13
 * @Version 1.0
 */
public class Utility {
    public static Scanner sc = new Scanner(System.in);

    // 读取键盘输入，读取 长度限制，返回 字符串
    public static String readKeyBoard(int limit){
        String line = "";

        while(sc.hasNext()){
            line = sc.nextLine();
            if (line.length()<1 || line.length()>limit){
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }


    // 用于界面菜单的选择，返回选项
    public static char ReadMenuSelection(){
        char c;
        while (true){
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if(c!='1' && c!='2' && c!='3' && c!='4' && c!='5'){
                System.out.print("选择错误，请重新输入：");
            }else
                break;
        }
        return c;
    }

    // 收入和支出金额的输入，读取 不超过5位整数， 返回 该数
    public static  int readNumber(){
        int n;
        while (true){
            String str = readKeyBoard(5);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    // 收入和支出说明的输入，读取 不超过8位长度的字符串， 返回 该字符串
    public static String readString(){
        return readKeyBoard(8);
    }

    // 确认选择的输入，读取 Y或N， 将其返回
    public static char readConfirmSelection(){
        char c;
        while (true){
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c != 'Y' && c != 'N'){
                System.out.print("选择错误，请重新输入：");
            }else
                break;
        }
        return c;
    }

}
