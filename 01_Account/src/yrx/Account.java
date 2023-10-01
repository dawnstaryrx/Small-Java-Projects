package yrx;

import java.util.ArrayList;

/**
 * ClassName: Account
 * Package: yrx
 * Description:
 *          账户类
 * @Author yrx
 * @Create 2023/10/1 9:53
 * @Version 1.0
 */
public class Account {
    private int balance = 0; // 总额
    // public String[][] details = new String[0][0];
    ArrayList<Detail> details = new ArrayList<>();

    // 显示功能列表
    public void showFunction(){
        System.out.println("---------------------东方既白记账软件----------------------");
        System.out.println("                 1. 收支明细");
        System.out.println("                 2. 登记收入");
        System.out.println("                 3. 登记支出");
        System.out.println("                 4. 账户总额");
        System.out.println("                 5. 退\t出");
        System.out.println("--------------------------------------------------------");
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // 展示收支
    public void showDetails(){
        String detailTop = "收    支-----------------收支金额-----------------说    明\n";
        System.out.println(detailTop);
        for (Detail detail : details)
            System.out.println(detail.getSelection() + "\t\t\t\t\t\t" + detail.getFee() + "\t\t\t\t\t" + detail.getIllustrate());

    }

    // 收入
    public void balanceIn(int bcIn, String illstrate){
        Detail dt = new Detail("收入", bcIn, illstrate);
        setBalance(bcIn + getBalance());
        details.add(dt);
    }

    // 支出
    public void balanceOut(int bcOut, String illstrate){
        Detail dt = new Detail("支出", bcOut, illstrate);
        setBalance(getBalance() - bcOut);
        details.add(dt);
    }
}
