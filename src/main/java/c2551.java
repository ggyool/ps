import java.util.Arrays;
import java.util.PriorityQueue;

public class c2551 {

    // 정렬하면 되는거였음
    public long putMarbles(int[] weights, int k) {
        int len = weights.length;
        int[] arr = new int[len-1];
        for (int i=0; i<len-1; i++) {
            arr[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(arr);

        long maxAns = weights[0] + weights[len-1];
        long minAns = weights[0] + weights[len-1];
        for (int i=0; i<k-1; i++) {
            maxAns += arr[len-2-i];
            minAns += arr[i];
        }
        return maxAns - minAns;
    }

    // pq에 넣는 개수를 고정시켰는데도 느림 k가 커서 그런듯
//    public long putMarbles(int[] weights, int k) {
//        int len = weights.length;
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
//        for (int i=0; i<len-1; i++) {
//            int value = weights[i] + weights[i+1];
//            if (!minHeap.isEmpty() && minHeap.size() >= k-1) {
//                if (value > minHeap.peek()) {
//                    minHeap.poll();
//                    minHeap.add(weights[i] + weights[i+1]);
//                }
//            } else {
//                minHeap.add(weights[i] + weights[i+1]);
//            }
//            if (!maxHeap.isEmpty() && maxHeap.size() >= k-1) {
//                if (value < maxHeap.peek()) {
//                    maxHeap.poll();
//                    maxHeap.add(weights[i] + weights[i+1]);
//                }
//            } else {
//                maxHeap.add(weights[i] + weights[i+1]);
//            }
//        }
//        long maxAns = weights[0] + weights[len-1];
//        long minAns = weights[0] + weights[len-1];
//        for (int i=0; i<k-1; i++) {
//            maxAns += minHeap.poll();
//            minAns += maxHeap.poll();
//        }
//        return maxAns - minAns;
//    }

    // 첫 풀이: 힌트에서 pq 쓰라고 해서 품
//    public long putMarbles(int[] weights, int k) {
//        int len = weights.length;
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
//        for (int i=0; i<len-1; i++) {
//            int weight = weights[i];
//            maxHeap.add(weights[i] + weights[i+1]);
//            minHeap.add(weights[i] + weights[i+1]);
//        }
//        long maxAns = weights[0] + weights[len-1];
//        long minAns = weights[0] + weights[len-1];
//        for (int i=0; i<k-1; i++) {
//            maxAns += maxHeap.poll();
//            minAns += minHeap.poll();
//        }
//        return maxAns - minAns;
//    }
}
