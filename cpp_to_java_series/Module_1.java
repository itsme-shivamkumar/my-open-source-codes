import java.util.Arrays;

/** Important Things Covered
 * - can't access non-static variables or methods from a static method / context
 * - need to pass <T> in either class-level generics else explicitly in methods
 * - creation & comparison of deep and shallow copy of Arrays
 * - var (java) can be used in replacement to auto (cpp)
 * - Arrays.fill(arr,value) in java can be used in replacement to memset(arr,value, sizeof(arr)) in cpp
 * - Primitive array can be sorted in asc order only. 
 * 		For Desc, we need to convert it to Object Array to pass comparator
 * - 
 */

public class Module_1 { // No Declaration of any generics hence in generic methods need to pass <T>
    
	// main function
	public static void main(String[] args) {
	    Module_1 MainObj = new Module_1(); // static methods can't directly access non-static methods.
		int[] javaArr = new int[10];
		for(var ele: javaArr){
		    MainObj.sout(ele);
		}
		MainObj.soutn();
		
		Module_1.SampleObj templateObj = new Module_1().new SampleObj();
		templateObj.setValue(3.14);
		MainObj.soutn(MainObj.getValue(templateObj));
		
		int[] arrShallowCopy = javaArr;
		int[] arrDeepCopy = Arrays.copyOf(javaArr, javaArr.length); // Alt: copyOfRange(arr, fromIdx, toIdx)
		int[] arrDeepCopy2 = javaArr.clone();
		MainObj.soutn(Arrays.equals(javaArr, arrShallowCopy)); // true ( shallow comparison )
		MainObj.soutn(Arrays.equals(javaArr, arrDeepCopy)); // true ( shallow comparison )
		MainObj.soutn(javaArr == arrShallowCopy); // true ( deep comparison )
		MainObj.soutn(arrDeepCopy2 == javaArr); // false ( deep comparison )
		MainObj.soutn(arrDeepCopy2 == arrDeepCopy); // false ( deep comparison )
		
		Arrays.fill(javaArr,-1); // Atl: fill(arr, fromIdx, toIdx, value)
		MainObj.soutn(Arrays.toString(javaArr));
		
		javaArr[javaArr.length/2] = 100;
		Arrays.sort(javaArr);
		MainObj.soutn(Arrays.toString(javaArr)); // [-1, -1, -1, -1, -1, -1, -1, -1, -1, 100]
		
		Integer[] boxedArr = Arrays.stream(javaArr).boxed().toArray(Integer[]::new); // Need Object Array to pass comparator
		Arrays.sort(boxedArr, (a,b)->Integer.compare(b,a));
		MainObj.soutn(Arrays.toString(boxedArr)); // [100, -1, -1, -1, -1, -1, -1, -1, -1, -1]

	}
	
	// Utils Funcs START ----------------------------
	
	public <T> void sout(T obj) { // don't use <T> if it is declared at class level
	    System.out.print(obj);
	}
	
	public <T> void soutn(T obj) { // don't use <T> if it is declared at class level
	    System.out.println(obj);
	}
	
	public <T> void soutn() { // don't use <T> if it is declared at class level
	    System.out.println("");
	}
	
	public <T> T getValue(SampleObj<T> obj) { // don't use <T> if it is declared at class level
	    return obj.getValue();
	}
	
	// Util Funcs END ----------------------------
	
	// =======================================================
	
	// Sample Classes START ----------------------------
	
	public class SampleObj<T> { // Declared Template T at class-level
        private T value;
        public SampleObj(){
            System.out.println("SampleObj is created!");
        }
        public T getValue() {
            return this.value;
        }
        public void setValue(T v) {
            this.value = v;
        }
    }
    
    // Sample Classes END ----------------------------
}