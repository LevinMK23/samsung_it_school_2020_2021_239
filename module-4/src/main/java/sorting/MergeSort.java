package sorting;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    static int cnt = 0;

    static List<Integer> sort(List<Integer> list) {
        if (list.size() == 1 || list.isEmpty()) {
            return list;
        }
        Pair<List<Integer>, List<Integer>> pair = split(list);
        return merge(
                sort(pair.getKey()),
                sort(pair.getValue())
        );
    }

    static Pair<List<Integer>, List<Integer>> split(List<Integer> list) {
        return new Pair<>(
                list.subList(0, list.size() / 2),
                list.subList(list.size() / 2, list.size())
        );
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0, j = 0;
        int length = left.size() + right.size();
        List<Integer> result = new ArrayList<>();
        for (int k = 0; k < length; k++) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                cnt++;
                i++;
                if (i == left.size()) {
                    for (int l = j; l < right.size(); l++) {
                        result.add(right.get(l));
                        cnt++;
                    }
                    break;
                }
            } else {
                result.add(right.get(j));
                cnt++;
                j++;
                if (j == right.size()) {
                    for (int l = i; l < left.size(); l++) {
                        result.add(left.get(l));
                        cnt++;
                    }
                    break;
                }
            }
        }
        return result;
    }

}
