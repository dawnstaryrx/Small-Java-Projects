package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ClassName: GamePanel
 * Package: snake
 * Description:
 *      创建SnakePanel类，继承JPanel类，用于实现游戏面板，
 *      实现KeyListener, ActionListener两个接口，
 *      KeyListener用于接收键盘事件（击键）的侦听器接口，
 *      ActionListener用于接收操作事件的侦听器接口
 * @Author yrx
 * @Create 2023/10/3 10:17
 * @Version 1.0
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {
//     用数组元素的移动来表示贪吃蛇的移动，这里也可以使用链表来实现，
//     因为每个位置需要横坐标和纵坐标来表示，定义两个数组，但是也限制了贪吃蛇的最大长度
    public static int[] snakeX = new int[100]; // 距离左边的距离
    public static int[] snakeY = new int[100]; // 距离上边的距离
    public static int length; // 蛇的长度
    int foodX;// 食物位置
    int foodY;
    Dir directory; // 蛇头方向
    int score;      // 积分
    Timer timer = new Timer(200, this); // 定时器
    boolean isStart; // 游戏是否开始
    boolean isFail;  // 游戏是否失败

    public GamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    // 游戏初始化
    private void init(){
        length = 3;//初始化蛇身长度为3，每个蛇身之间的距离是25
        snakeX[0] = 100;//蛇头的位置是[100,100]
        snakeY[0] = 100;
        snakeX[1] = 75;//第一个蛇身的位置是[75,100]
        snakeY[1] = 100;
        snakeX[2] = 50;//第二个蛇身的位置是[50，100]
        snakeY[2] = 100;
        directory = Dir.R;//初始化蛇头方向向右
        Food.getFood(snakeX,snakeY);
        foodX = Food.X;
        foodY = Food.Y;
        isStart = false;//初始化不开始游戏
        isFail = false;//初始化游戏没有失败
        score = 0;//分数初始化为0

    }

    /*这个方法需要手动去重写。paintComponent()是swing的一个方法，相当于图形版的main()方法，
    是会自执行的。如果一个class中有构造函数，则执行顺序是先执行构造函数，再执行这个方法，
    所以在整个类当中找不到主动调用paintComponent方法的地方。*/
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.setBackground(Color.white); // 背景板白色
        graphics.setColor(Color.GRAY);   // 游戏区域
        /* x:表示距离Jframe边框的横向距离，
          y表示距离Jframe边框的纵向距离开始绘制宽为500，高为475的内部框，
          也就是说游戏面板大小为500*475
        */
        graphics.fillRect(0,25,490,475);
        //画贪吃蛇的头部
        if (directory==Dir.R){
            Data.right.paintIcon(this,graphics, snakeX[0], snakeY[0]);
        }else if (directory==Dir.L){
            Data.left.paintIcon(this,graphics, snakeX[0], snakeY[0]);
        }else if (directory==Dir.U){
            Data.up.paintIcon(this,graphics, snakeX[0], snakeY[0]);
        }else if (directory==Dir.D) {
            Data.down.paintIcon(this, graphics, snakeX[0], snakeY[0]);
        }

        //画身体
        for (int i = 1; i< length; i++){
            Data.body.paintIcon(this,graphics, snakeX[i], snakeY[i]);
        }
        //绘制积分栏
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("幼圆",Font.BOLD,20));
        graphics.drawString("长度：" + length,50,20);
        graphics.drawString("得分：" + score,150,20);
        // 绘制
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("幼圆",Font.BOLD,20));
        graphics.drawString("贪吃蛇",350,20);
        //画食物
        Data.food.paintIcon(this,graphics,foodX,foodY);
        //游戏开始提醒
        if (!isStart){
            graphics.setColor(Color.black);
            graphics.setFont(new Font("幼圆",Font.BOLD,20));
            graphics.drawString("按空格键开始游戏",160,225);
        }
        //失败判断
        if (isStart && isFail){
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("幼圆",Font.BOLD,20));
            graphics.drawString("游戏失败，按空格键重新开始",120,220);
        }
        if (score == 500){
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("幼圆",Font.BOLD,20));
            graphics.drawString("恭喜你，赢了！！！",120,250);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 获取按下的键
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_SPACE:
                if(isFail){
                    isFail = false;// 重新开始
                    init();
                }else{
                    isStart = !isStart;
                }
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                //当按键为左的时候，只要前进方向不是右，即可转向
                if (directory!=Dir.R){
                    directory = Dir.L;
                }else
                    isFail = true;
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                // 当按键为"右"的时候，只要前进方向不是"左",就可以转向
                if (directory!=Dir.L){
                    directory = Dir.R;
                }else
                    isFail = true;
                repaint();
                break;
            case KeyEvent.VK_UP:
                // 当按键为"上"，只要前进方向不是"下"，就可以转向
                if (directory!=Dir.D){
                    directory = Dir.U;
                }else
                    isFail = true;
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                //当按键为"下"的时候，只要前进方向不是"上",就可以转向
                if (directory!=Dir.U){
                    directory = Dir.D;
                }else
                    isFail = true;
                repaint();
                break;
        }
        //判断游戏状态，游戏开始并且没没失败
        if(isStart && !isFail) {
            //吃食物
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                length++;
                score += 10;
                Food.getFood(snakeX,snakeY);
                foodX = Food.X;
                foodY = Food.Y;
            }
            //小蛇移动，只需要将数组中的元素向后移动一位即可
            if (keyCode == KeyEvent.VK_LEFT||keyCode == KeyEvent.VK_RIGHT||keyCode == KeyEvent.VK_UP||keyCode == KeyEvent.VK_DOWN){
                for (int i = length - 1; i > 0; i--) {
                    snakeX[i] = snakeX[i - 1];
                    snakeY[i] = snakeY[i - 1];
                }
                //移动头部
                if (directory == Dir.R) {
                    snakeX[0] += 25;
                    //判断边界
                    if (snakeX[0] > 450) {
                        isFail = true;
                    }
                } else if (directory == Dir.L) {
                    snakeX[0] -= 25;
                    //判断边界
                    if (snakeX[0] < 0) {
                        isFail = true;
                    }
                } else if (directory == Dir.U) {
                    snakeY[0] -= 25;
                    //判断边界
                    if (snakeY[0] < 25) {
                        isFail = true;
                    }
                } else if (directory == Dir.D) {
                    snakeY[0] += 25;
                    //判断边界
                    if (snakeY[0] > 450) {
                        isFail = true;
                    }
                }
            }


            //死亡判定
            for (int i = 1; i < length; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                    break;
                }
            }
            repaint();
        }
        timer.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

