package leetcode.practicing;

import org.junit.jupiter.api.Test;

import java.io.Closeable;
import java.io.IOException;
import java.util.Stack;

public class A231 {




    public boolean isPowerOfTwo(int n) {

        return false;
    }



    @Test
    public void test(){

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);



        
        try(
                Myclose myclose = new Myclose();
                ){
            int i = 2 / 0;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    class Myclose implements Closeable{

        @Override
        public void close() throws IOException {
            System.out.println("關關關");
        }
    }

}
