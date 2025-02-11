package game;

import java.util.Random;
import java.util.Scanner;

public class MemoryNumberGame {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int level = 4; // 初始關卡（數字長度）

        System.out.println("歡迎來到記憶數字遊戲！");
        System.out.println("系統會顯示一串數字，幾秒後消失，請輸入你記住的數字！");
        System.out.println("輸入錯誤則遊戲結束！\n");

        while (true) {
            // 產生隨機數字
            StringBuilder numberSequence = new StringBuilder();
            for (int i = 0; i < level; i++) {
                numberSequence.append(random.nextInt(10)); // 0~9 的隨機數字
            }

            // 顯示數字並讓玩家記住
            System.out.println("請記住這串數字：" + numberSequence);
            Thread.sleep(3000); // 等待 3 秒
            clearScreen(); // 清除畫面

            // 提示玩家輸入
            System.out.print("請輸入剛剛的數字序列：");
            String playerInput = scanner.nextLine();

            // 檢查輸入是否正確
            if (playerInput.equals(numberSequence.toString())) {
                System.out.println("正確！進入下一關！\n");
                level++; // 增加難度
            } else {
                System.out.println("錯誤！遊戲結束！你的最高關卡是：" + (level - 1));
                System.out.println(numberSequence);
                break;
            }
        }

        scanner.close();
    }

    // 清除畫面（適用於 Windows & Mac/Linux）
    public static void clearScreen() {
//        try {
//            if (System.getProperty("os.name").contains("Windows")) {
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            } else {
//                System.out.print("\033[H\033[2J");
//                System.out.flush();
//            }
//        } catch (Exception e) {
//            System.out.println("無法清除畫面！");
//            for (int i = 0; i < 50; i++) {
//                System.out.println();
//            }
//        }

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
