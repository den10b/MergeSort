import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static long merge(LinkedList<LinkedList<Integer>> ququ) {
        long inversions = 0;
        LinkedList<Integer> left = ququ.pop();
        LinkedList<Integer> right = ququ.pop();
        LinkedList<Integer> newList = new LinkedList<>();
        int tookRight = 0;
        while (left.size() > 0 && right.size() > 0) {
            if (left.peek() <= right.peek()) {
                newList.add(left.pop());
                inversions += tookRight;
            } else {
                newList.add(right.pop());
                tookRight++;
            }
        }
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0) {
                newList.add(left.pop());
                inversions += tookRight;
            } else {
                newList.add(right.pop());
                tookRight++;
            }}
            ququ.add(newList);


        return inversions;
    }

    public static long MergeFindInversions(LinkedList<LinkedList<Integer>> ququ) {
        long inversions = 0;
        int halfSize= ququ.size()/2;
        LinkedList<Integer> last = ququ.getLast();
        while (ququ.size() > 1) {
            if (ququ.peek() != last) {
            if (halfSize>0) {
                inversions += merge(ququ);
                halfSize--;} else {
                last = ququ.getLast();
                halfSize= ququ.size()/2;
            }
            } else {
                ququ.addFirst(ququ.removeLast());
                inversions += merge(ququ);
                last = ququ.getLast();
                halfSize= ququ.size()/2;
            }

        }
        return inversions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<LinkedList<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> lilQueue = new LinkedList<>();
            lilQueue.add(in.nextInt());
            queue.add(lilQueue);
        }
        long t = MergeFindInversions(queue);

        System.out.println(t);
    }
}