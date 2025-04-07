package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A118PascalsTriangle {




    public List<List<Integer>> generate(int numRows) {

        if(numRows==0) return null;

        List<List<Integer>> finalList = new ArrayList<>();

        for(int h=0; h<numRows; h++){
            List<Integer> list = new ArrayList<>();
            for(int w=0; w<=h; w++){
                if(w==h||w==0) list.add(1);
                else list.add( finalList.get(h-1).get(w-1) + finalList.get(h-1).get(w));
            }
        }
        return finalList;
    }
}
