package com.aaron.springcore;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            list.add(prefix == 0);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(3 << 1);
    }
}
