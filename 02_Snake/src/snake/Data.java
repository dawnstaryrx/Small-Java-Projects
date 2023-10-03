package snake;

import javax.swing.*;
import java.net.URL;

/**
 * ClassName: Data
 * Package: snake
 * Description:
 *          加载静态资源
 * @Author yrx
 * @Create 2023/10/3 10:11
 * @Version 1.0
 */
public class Data {
    // 蛇朝向
    public static URL upUrl = Data.class.getResource("/statics/up.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static URL downUrl = Data.class.getResource("/statics/down.png");
    public static ImageIcon down = new ImageIcon(downUrl);
    public static URL rightUrl = Data.class.getResource("/statics/right.png");
    public static ImageIcon right = new ImageIcon(rightUrl);
    public static URL leftUrl = Data.class.getResource("/statics/left.png");
    public static ImageIcon left = new ImageIcon(leftUrl);
    // 身体
    public static URL bodyUrl = Data.class.getResource("/statics/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);
    // 食物
    public static URL foodUrl = Data.class.getResource("/statics/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);
}
