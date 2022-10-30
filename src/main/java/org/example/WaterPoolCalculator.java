package org.example;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class WaterPoolCalculator {
    public static final int MAX_NUMBER_OF_ELEMENTS = 32000;
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_HEIGHT = 32000;

    public long calculateWaterAmount(@NotNull int[] landscape) {
        check(landscape);
        long waterCounter = 0L;
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(0, landscape[0]));
        for (int i = 1; i < landscape.length; i++) {
            int currentEl = landscape[i];
            int stackEl = stack.peek().getValue();
            if (currentEl < stackEl) {
                stack.push(new Pair(i, landscape[i]));
            } else {
                waterCounter += deleteElFromStackUntilFindMax(stack, currentEl, i);
                stack.push(new Pair(i, landscape[i]));
            }
        }
        return waterCounter;
    }

    private void check(int[] landscape) {
        if ((landscape == null) || (landscape.length == 0)) {
            throw new IllegalArgumentException("Landscape should be not a null and not empty");
        }
        if (landscape.length > MAX_NUMBER_OF_ELEMENTS) {
            throw new IllegalArgumentException("Length of landscape should be not more then " + MAX_NUMBER_OF_ELEMENTS);
        }
        Arrays.stream(landscape).forEach(el -> {
            if (el < MIN_HEIGHT || el > MAX_HEIGHT) {
                throw new IllegalArgumentException("Height should be not in range between " + MIN_HEIGHT + " and " + MAX_HEIGHT);
            }
        });
    }

    private long deleteElFromStackUntilFindMax(Deque<Pair> stack, int currentEl, int index) {
        long waterCounter = 0L;
        while (!stack.isEmpty()) {
            if (stack.peek().getValue() > currentEl) {
                break;
            }
            Pair stackPair = stack.pop();
            if (stack.peek() != null) {
                int height = Math.min(stack.peek().getValue(), currentEl) - stackPair.getValue();
                int dif = index - stack.peek().getIndex() - 1;
                waterCounter += height * dif;
            }
        }
        return waterCounter;
    }
}

class Pair {
    private final int index;
    private final int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }


    public int getValue() {
        return value;
    }
}
