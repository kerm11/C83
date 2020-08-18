package bean;

//冒泡法排序
public class BubbleSorter {
	private int[] a;
	public BubbleSorter(int[] a) {
		super();
		this.a=a;
	}

	public void sort() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1; j++) {
				if (a[j]<a[j+1]) { //稳定算法
					swap(j,j+1);
				}
			}
		}
		
	}

	private void swap(int minPos, int i) {
		int temp= a[i];
		a[i]=a[minPos];
		a[minPos]=temp;
	}

}
