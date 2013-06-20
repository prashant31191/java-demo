import java.util.Comparator;
import java.util.Arrays;

public class TestIntCompare{
	public static void main(String[] args){
		Integer[] intArr = {new Integer(3), new Integer(2), new Integer(1)};
		Arrays.sort(intArr, new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		});
		output(intArr);
	}

	public static void output(Integer[] arr){
		for(Integer i: arr){
			System.out.println(i);
		}
	}
}
