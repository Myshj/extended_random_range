package my_random;

import javax.validation.constraints.NotNull;
import java.util.concurrent.ThreadLocalRandom;

public abstract class MyRandom {
    private static int nextRandomInt(int origin, int bound){
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    private static double nextRandomDouble(double origin, double bound){
        return ThreadLocalRandom.current().nextDouble(origin, bound);
    }

    public static int randomInt(@NotNull Interval<Integer> interval) {
        if (!interval.isValid()) {
            return 0;
        }
        int negative_inf = Integer.MIN_VALUE;
        IntervalBound<Integer> minBound = interval.getMin();

        int minBoundValue = minBound == null ?
                negative_inf :
                minBound.isInclusive() ?
                        minBound.getValue() :
                        minBound.getValue() + 1;

        int positive_inf = Integer.MAX_VALUE;
        IntervalBound<Integer> maxBound = interval.getMax();
        int maxBoundValue = minBound == null ?
                positive_inf :
                maxBound.isInclusive() ?
                        maxBound.getValue() + 1 :
                        maxBound.getValue();
        return nextRandomInt(minBoundValue, maxBoundValue);
    }

    public static double randomDouble(@NotNull Interval<Double> interval) {
        if (!interval.isValid()) {
            return 0;
        }
        double negative_inf = Double.MIN_VALUE;
        IntervalBound<Double> minBound = interval.getMin();

        double minBoundValue = minBound == null ?
                negative_inf :
                minBound.isInclusive() ?
                        minBound.getValue() :
                        minBound.getValue() + 1;

        double positive_inf = Double.MAX_VALUE;
        IntervalBound<Double> maxBound = interval.getMax();

        double maxBoundValue = minBound == null ?
                positive_inf :
                maxBound.isInclusive() ?
                        maxBound.getValue() + 1 :
                        maxBound.getValue();
        System.out.println(maxBoundValue);
        return nextRandomDouble(minBoundValue, maxBoundValue);
    }
}
