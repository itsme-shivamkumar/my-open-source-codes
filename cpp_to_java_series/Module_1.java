import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;

/** Important Things Covered
 * - can't access non-static variables or methods from a static method / context
 * - need to pass <T> in either class-level generics else explicitly in methods
 * - creation & comparison of deep and shallow copy of Arrays
 * - var (java) can be used in replacement to auto (cpp)
 * - Arrays.fill(arr,value) in java can be used in replacement to memset(arr,value, sizeof(arr)) in cpp
 * - Primitive array can be sorted in asc order only. 
 * 		For Desc, we need to convert it to Object Array to pass comparator
 * - Arrays.binarySearch can be used on [sorted array] to get idx of key, else -ve value
 * - Usage of Stream API for primitives and objects
 * - Converting primitive array to boxed stream
 * - Sorting in descending order using custom comparator
 * - Filtering, mapping, reducing
 * - Collecting to List, Set, Map
 * - flatMap vs map
 * - peek for debugging
 * - Optional usage with streams
 * - Difference between stream(), parallelStream()
 *  */

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
		
		MainObj.soutn(Arrays.binarySearch(javaArr, 100)); // 9 (array should be sorted)
		MainObj.soutn(Arrays.binarySearch(javaArr, 98) < 0); // true (any -ve value will be passed)
		
		// Streams
		List<Integer> numbers = Arrays.asList(10, 20, 15, 5, 30);

        List<Integer> result = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 3)
            .sorted((a,b)->Integer.compare(b,a))    // sort desc
            .peek(n -> System.out.println("Peeking: " + n)) // debug
            .collect(Collectors.toList()); // import java.util.stream.Collectors;

        MainObj.soutn("Final List: " + result); // [90, 60, 30]

        int sum = numbers.stream().reduce(0, Integer::sum);  // 80
        
        List<Person> people = List.of(
            new Person("Ram", 25),
            new Person("Sita", 30),
            new Person("Shyam", 18),
            new Person("Geeta", 35)
        );

        List<String> eligibleNames = people.stream()
            .filter(Person::isAdult)
            .map(Person::getUpperName) 
            .sorted((a,b)->{
                return a.compareTo(b); // asc order
            })
            .collect(Collectors.toList());

        MainObj.soutn(eligibleNames);

        Map<String, Integer> nameAgeMap = people.stream()
            .collect(Collectors.toMap(
                Person::getName,
                Person::getAge
            ));
        MainObj.soutn(nameAgeMap); // {Shyam=18, Geeta=35, Sita=30, Ram=25}
        
        List<List<String>> nestedNames = List.of(
            List.of("Ram", "Sita"),
            List.of("Shyam"),
            List.of("Geeta", "Luv", "Kush")
        );

        List<String> flat = nestedNames.stream().flatMap(Collection::stream).collect(Collectors.toList());
        // [Ram, Sita, Shyam, Geeta, Luv, Kush]
        
        Optional<String> firstWithS = flat.stream()
            .filter(name -> name.startsWith("S"))
            .findFirst();

        firstWithS.ifPresent(name -> System.out.println("First with S: " + name)); // First with S: Sita
        
        Module_1 obj = new Module_1();
        
        // --- PRIMITIVE TO BOXED & SORT DESC ---
		int[] nums = {5, 2, 9, 1, 7};
		Integer[] descSorted = Arrays.stream(nums)
			.boxed()
			.sorted((a, b) -> b - a)
			.toArray(Integer[]::new);
		obj.soutn(Arrays.toString(descSorted));

		// --- FILTER, MAP, COLLECT LIST ---
		List<String> names = List.of("ram", "shyam", "geeta", "sita");
		List<String> upperNames = names.stream()
			.filter(name -> name.length() <= 4)
			.map(String::toUpperCase)
			.collect(Collectors.toList()); // [RAM, SITA]

		// --- REDUCE TO SUM ---
		int total = IntStream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum); // 15

		// --- flatMap vs map ---
		List<List<Integer>> matrix = List.of(List.of(1, 2), List.of(3, 4), List.of(5));
		List<Integer> flattened = matrix.stream()
			.flatMap(List::stream)
			.collect(Collectors.toList());  // [1, 2, 3, 4, 5]

		// --- peek (for debugging) ---
		List<String> debug = names.stream()
			.peek(name -> System.out.println("Original: " + name))
			.map(String::toUpperCase)
			.peek(name -> System.out.println("Upper: " + name))
			.collect(Collectors.toList());

		// --- Optional + findFirst ---
		Optional<String> firstLongName = names.stream()
			.filter(name -> name.length() > 4)
			.findFirst();
		firstLongName.ifPresent(obj::soutn);

		// --- Collect to Map ---
		Map<String, Integer> nameLengthMap = names.stream()
			.collect(Collectors.toMap(name -> name, String::length));

		// --- Parallel Stream Example ---
		int parSum = Arrays.asList(1, 2, 3, 4, 5, 6)
			.parallelStream()
			.mapToInt(i -> i * 2)
			.sum();   // 42
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
    
    public static class Person {
        private String name;
        private int age;
    
        public Person(String n, int a) {
            this.name = n;
            this.age = a;
        }
    
        public boolean isAdult() {
            return age >= 21;
        }
    
        public String getUpperName() {
            return name.toUpperCase();
        }
    
        public String getName() { return name; }
    
        public int getAge() { return age; }
    }
    
    // Sample Classes END ----------------------------


	// Overall Terminal Output
	/*
		0000000000
		SampleObj is created!
		3.14
		true
		true
		true
		false
		false
		[-1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
		[-1, -1, -1, -1, -1, -1, -1, -1, -1, 100]
		[100, -1, -1, -1, -1, -1, -1, -1, -1, -1]
		9
		true
		Peeking: 90
		Peeking: 60
		Peeking: 30
		Final List: [90, 60, 30]
		[GEETA, RAM, SITA]
		{Shyam=18, Geeta=35, Sita=30, Ram=25}
		First with S: Sita
		[9, 7, 5, 2, 1]
		Original: ram
		Upper: RAM
		Original: shyam
		Upper: SHYAM
		Original: geeta
		Upper: GEETA
		Original: sita
		Upper: SITA
		shyam
	*/
}