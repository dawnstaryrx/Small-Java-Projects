package snake;

import javax.swing.*;

/**
 * ClassName: StartSnake
 * Package: snake
 * Description:
 *          游戏入口
 * @Author yrx
 * @Create 2023/10/3 10:03
 * @Version 1.0
 */
public class StartSnake {
    public static void main(String[] args) {
        // 建立游戏窗口
        JFrame jFrame = new JFrame("DawnStar Snake");   // 标题
        jFrame.setSize(490, 510);               // 窗体大小
        jFrame.setLocationRelativeTo(null);                 // 显示到中央
        jFrame.setResizable(false);                         // 固定窗口大小
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭时间
        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);                        // 添加游戏内容
        jFrame.setVisible(true);                            // 窗体可见
    }

}
