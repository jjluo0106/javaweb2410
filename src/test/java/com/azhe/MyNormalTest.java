package com.azhe;


import lombok.Data;
import org.junit.jupiter.api.Test;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyNormalTest {

    @Test
    public void test(){
        System.out.println(sha256("2794353967525889W3-9478070920250413171654481100f0045d4a9a3e62e6a352beaac382bd99A7JVrdK5aHzIWf11awJPHqDr4uxsih3v4671331f1dfd6e2b860ec7e19e63017a19556f76ad3ff881d378b39b8c8adc1517445367705"));
    }

    private static char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    public static String sha256(String srcStr) {
        return hash("SHA-256", srcStr);
    }


    public static String hash(String algorithm, String srcStr) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] bytes = md.digest(srcStr.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toHex(byte[] bytes) {
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }


    @Test
    public void test22(){
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append('a'));
    }


    public void myQuickSort(int[] arr, int start, int end) {

        if(start>=end) return ;

        int startP = start;
        int endP = end;
        int pivotValue = arr[start];

        while(startP<endP){
            while(startP<endP && pivotValue<=arr[endP]) endP--;
            while(startP<endP && pivotValue>=arr[startP]) startP++;
            int temp = arr[endP];
            arr[endP] = arr[startP];
            arr[startP] = temp;
        }
        arr[start] = arr[endP];
        arr[endP] = pivotValue;

        myQuickSort(arr, start, endP-1);
        myQuickSort(arr, endP+1, end);

    }


    @Test
    public void test222(){


        List<String> list = Arrays.asList("小昭-22","趙敏-18","張無忌-21","周芷若-35");

        List<Integer> collect = list.stream().
                map( s -> Integer.parseInt(s.split("-")[1])).
                collect(Collectors.toList());

        Collections.shuffle(collect);


        System.out.println(collect);
    }


    @Test
    public void methodGet() {
        Integer[] arr = {1, 3, 2, 6, 4, 5};

        Arrays.sort(arr, MyNormalTest::mySort);

        System.out.println(Arrays.toString(arr));
    }

    public static int mySort(Integer a, Integer b){
        return a-b;
    }

    @Test
    public void StrToInt(){
        List<Integer> list = Arrays.asList( 5, 6, 3, 4, 1, 2);

        System.out.println(list);

        List<String> collect = list.stream().map(MyNormalTest::valueOf)
                .collect(Collectors.toList());

        System.out.println(collect);


    }



    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString()+"a";
    }



    @Test
    public void StrToObj(){
        List<String> list = Arrays.asList("張無忌-18", "小昭-17", "趙敏-19");

        list.stream().map(Student::new).forEach( s -> System.out.println(s));

    }

    @Data
    class Student{
        String name;
        int age;

        Student(){
        }

        Student(String name, int age){
            this.name = name;
            this.age = age;
        }

        Student(String str){
            String[] split = str.split("-");

            this.name = split[0];
            this.age = Integer.valueOf(split[1]);
        }



        @Override
        public String toString() {
            return "name:" + this.name + ",age: " + this.age;
        }
    }


    /**
     * 獲取姓名放到數組中
     */
    @Test
    public void transfer(){
        List<Student> list = Arrays.asList(new Student("張三", 13), new Student("李四", 14));

        String[] array = list.stream().map(Student::getName).toArray(String[]::new);

        System.out.println(array);

    }


    /**
     * 輸出劉
     */
    @Test
    public void outputString() throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\j0981\\OneDrive\\桌面\\javademo\\測試.txt");

        byte[] bytes = "Hello 你好嗎".getBytes(StandardCharsets.UTF_8);
        fos.write(bytes);
        fos.close();
    }

    /**
     * 拷貝
     */
    @Test
    public void copy() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\j0981\\OneDrive\\桌面\\javademo\\測試.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\j0981\\OneDrive\\桌面\\javademo\\拷貝.txt");

        int i = 0;
        while((i = fis.read()) != -1 ){
            fos.write(i);
        }
        fos.close();
        fis.close();
    }


    @Test
    public void inputStreamTest() throws IOException {

        File file  = new File("C:\\Users\\j0981\\OneDrive\\桌面\\temp.sql");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));

        int i = 0;

        while((i=isr.read())!= -1){
            System.out.println(i);
        }
    }



    static { System.loadLibrary("opencv_java4120"); }
    @Test
    public void testHeadersMultiScale() throws AWTException, IOException, InterruptedException {
        // 1. 擷取螢幕畫面
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenCapture = robot.createScreenCapture(screenRect);
        String screenshotPath = "C:\\Develop\\com\\tes4-pay-total\\myPayWeb\\src\\test\\java\\pic\\screenshot.png";
        String targetPath = "C:\\Develop\\com\\tes4-pay-total\\myPayWeb\\src\\test\\java\\pic\\target.png";
        ImageIO.write(screenCapture, "png", new File(screenshotPath));

        // 2. 載入螢幕與目標圖形
        Mat screen = Imgcodecs.imread(screenshotPath);
        Mat target = Imgcodecs.imread(targetPath);

        if (screen.empty()) {
            System.out.println("❌ 螢幕截圖讀取失敗！");
            return;
        }

        if (target.empty()) {
            System.out.println("❌ 目標圖形讀取失敗！");
            return;
        }

        // 3. 多尺度模板比對
        double bestMatchVal = 0;
        Point bestMatchLoc = null;
        double bestScale = 1.0;

        double minScale = 0.5;     // 縮小至 50%
        double maxScale = 1.5;     // 放大至 150%
        double scaleStep = 0.01;    // 每次縮放的幅度

        for (double scale = minScale; scale <= maxScale; scale += scaleStep) {
            Mat resizedTarget = new Mat();
            Imgproc.resize(target, resizedTarget, new org.opencv.core.Size(), scale, scale);

            if (screen.cols() < resizedTarget.cols() || screen.rows() < resizedTarget.rows()) {
                continue;  // 略過超出螢幕範圍的比對
            }

            int resultCols = screen.cols() - resizedTarget.cols() + 1;
            int resultRows = screen.rows() - resizedTarget.rows() + 1;
            Mat result = new Mat(resultRows, resultCols, CvType.CV_32FC1);
            Imgproc.matchTemplate(screen, resizedTarget, result, Imgproc.TM_CCOEFF_NORMED);

            Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
            if (mmr.maxVal > bestMatchVal) {
                bestMatchVal = mmr.maxVal;
                bestMatchLoc = mmr.maxLoc;
                bestScale = scale;
            }
        }

        if (bestMatchVal < 0.7) {
            System.out.println("⚠️ 匹配度過低（最高: " + bestMatchVal + "），放棄點擊");
            return;
        }

        // 4. 根據最佳縮放比與位置，點擊中心
        int adjustedWidth = (int)(target.cols() * bestScale);
        int adjustedHeight = (int)(target.rows() * bestScale);
        int clickX = (int) (bestMatchLoc.x + adjustedWidth / 2);
        int clickY = (int) (bestMatchLoc.y + adjustedHeight / 2);

        robot.mouseMove(clickX, clickY);
        Thread.sleep(200);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        System.out.println("✅ 匹配成功！縮放: " + bestScale + "，位置: (" + clickX + ", " + clickY + ")，匹配度: " + bestMatchVal);
    }




    @Test
    public void tttt(){
        String libraryPath = System.getProperty("java.library.path");
        System.out.println("Current java.library.path:");
        System.out.println(libraryPath);
    }


    @Test
    public void testNoName(){
        new Animal(){
            @Override
            public void cry(){
                System.out.println("廟喵叫");
            }
        }.cry();
    }


     interface Animal{
        void cry();
    }


//    int gg;

    @Test
    public void testField(){

        BigGG bigGG = new BigGG();

    }


    class BigGG {
        int gg;

        BigGG(){
            System.out.println(gg);
        }
    }
}
