package jdk8;

import java.util.ArrayList;
import java.util.List;
/**
 * 在这种情况下，for循环更好。因此，在没有正确的分析之前，不要用流代替for循环。
 * 在这里，我们可以看到，并行流的性能比普通流更好。
 *  注意：结果可能会因为硬件的不同而不同。
 * 820084320
	Loop total Time = 74
	820084320
	Stream total Time = 405
	820084320
	Parallel Stream total Time = 169
 *
 */
public class StreamTest {

	static List<Integer> myList = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < 5000000; i++)
			myList.add(i);
		int result = 0;
		long loopStartTime = System.currentTimeMillis();
		for (int i : myList) {
			if (i % 2 == 0)
				result += i;
		}
		long loopEndTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("Loop total Time = " + (loopEndTime - loopStartTime));
		long streamStartTime = System.currentTimeMillis();
		System.out.println(myList.stream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());
		long streamEndTime = System.currentTimeMillis();
		System.out.println("Stream total Time = " + (streamEndTime - streamStartTime));
		long parallelStreamStartTime = System.currentTimeMillis();
		System.out.println(myList.parallelStream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());
		long parallelStreamEndTime = System.currentTimeMillis();
		System.out.println("Parallel Stream total Time = " + (parallelStreamEndTime - parallelStreamStartTime));
	}
}
