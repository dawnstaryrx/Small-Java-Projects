package snake;

import java.util.Random;

/**
 * ClassName: Food
 * Package: snake
 * Description:
 *          食物位置
 * @Author yrx
 * @Create 2023/10/3 10:16
 * @Version 1.0
 */
public class Food {
    private static Random random = new Random();
    // 所在的位置
    public static int X;
    public static int Y;

    public static void getFood(int[] snakeX,int[] snakeY){
        X = 25+25*random.nextInt(17);
        Y = 25+25*random.nextInt(16);
        for (int i = 0; i<GamePanel.length; i++){
            if (snakeX[i]==X && snakeY[i]==Y){
                X = 25+25*random.nextInt(17);
                Y = 25+25*random.nextInt(16);
                //为了避免再次随机生成的位置和蛇身重合，将i重设为0，重新判断
                i = 0;
            }
        }
    }
}
