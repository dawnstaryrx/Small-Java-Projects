package yrx;
/**
 * ClassName: FamilyAccount
 * Package: yrx
 * Description:
 *
 * @Author yrx
 * @Create 2023/10/1 8:13
 * @Version 1.0
 */
public class AccountMain {
    public static void main(String[] args) {
        Account fa = new Account();     // 创建一个账户
        fa.showFunction();              // 显示功能列表

        while (true){
            System.out.print("请选择你要使用的功能(1-5)：");
            char f = Utility.ReadMenuSelection();
            if (f == '1'){
                // 收支明细
                fa.showDetails();
            }else if (f == '2'){
                // 登记收入
                System.out.print("请输入你的收入金额：");
                int bcIn = Utility.readNumber();
                System.out.print("请输入你的收入来源：");
                String illstrate = Utility.readString();
                fa.balanceIn(bcIn, illstrate);
            }else if (f == '3'){
                // 登记支出
                System.out.print("请输入你的支出金额：");
                int bcOut = Utility.readNumber();
                System.out.print("请输入你的支出去向：");
                String illstrate = Utility.readString();
                fa.balanceOut(bcOut, illstrate);
            }else if (f == '4'){
                // 账户总额
                System.out.println("账户的总额为："+fa.getBalance()+"！！！");

            }else if(f == '5'){
                // 退出
                System.out.print("请确认你的选择(Y/N)：");
                if(Utility.readConfirmSelection() == 'Y')
                    break;
            }
        }
    }
}
