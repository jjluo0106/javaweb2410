package com.azhe.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

public class CaptchaGenerator {


    public static void main(String[] args) throws Exception {
        generateCaptcha(200,50,new FileOutputStream("testIMG.jpg"),"ABVC");
    }

    public static void generateCaptcha(int width, int height, OutputStream os, String code) throws Exception {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // 背景顏色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 設置字體
        g.setFont(new Font("Arial", Font.BOLD, 40));

        // 隨機字體顏色
        Random random = new Random();
        for (int i = 0; i < code.length(); i++) {
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g.drawString(String.valueOf(code.charAt(i)), 20 * i + 10, 35);
        }

        // 干擾線
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 5; i++) {
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        g.dispose();
        ImageIO.write(image, "JPEG", os);
    }

    public static String generateRandomCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }
        return code.toString();
    }
}
