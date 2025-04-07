package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A119PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> total = new ArrayList<>();

        for(int h=0; h<=rowIndex; h++){
            List<Integer> floor = new ArrayList<>();
            for(int w=0; w<h; w++){
                if(w==0||w==h) floor.add(1);
                else floor.add(total.get(h-1).get(w-1) + total.get(h-1).get(w));
            }
        }

        return total.get(rowIndex);
    }
}
