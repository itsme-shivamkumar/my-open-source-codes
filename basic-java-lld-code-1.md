## Java Collections & Utility Snippets

### **Basic Generic psvm method utilization
```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Main obj = new Main();
        obj.sout("hello"); // Output: hello
        obj.sout(2); // Output: 2
        Collection<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(20);
        list.sort();
        obj.sout(list);
    }
    <T> void sout(T s){
        System.out.println(s);
    }
}
```

### **Array & String Basics**  
```java
int[] arr = new int[5];  // Declare an integer array of size 5
int[] arr2 = {1, 2, 3};  // Initialize an array with values
String s = "hello";  
char ch = s.charAt(0);  // Get character at index 0
String sub = s.substring(1, 3);  // Substring from index 1 to 2
boolean contains = s.contains("el");  // Check if string contains "el"
String[] parts = s.split("l");  // Split string by "l"
int num = Integer.parseInt("123");  // Convert string to integer
String strNum = String.valueOf(456);  // Convert integer to string
```

### **ArrayList (Dynamic Array)**
```java
List<Integer> list = new ArrayList<>();  // Create an ArrayList
list.add(10);  // Add element
int val = list.get(0);  // Get element at index 0
list.remove(0);  // Remove element at index 0
Collections.sort(list);  // Sort in ascending order
Collections.sort(list, Collections.reverseOrder());  // Sort in descending order
```

### **Vector (Thread-Safe ArrayList)**
```java
Vector<Integer> vec = new Vector<>();
vec.add(1);  // Add element
vec.remove(0);  // Remove element at index 0
```

### **Stack (LIFO)**
```java
Stack<Integer> stack = new Stack<>();
stack.push(5);  // Push element
int top = stack.pop();  // Pop top element
int peek = stack.peek();  // Peek at top element
boolean isEmpty = stack.isEmpty();  // Check if empty
```

### **Queue (FIFO)**
```java
Queue<Integer> queue = new LinkedList<>();
queue.add(1);  // Enqueue
int front = queue.poll();  // Dequeue
int peek = queue.peek();  // Peek at front
```

### **Deque (Double-Ended Queue)**
```java
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);  // Add at front
deque.addLast(2);  // Add at back
int first = deque.pollFirst();  // Remove from front
int last = deque.pollLast();  // Remove from back
```

### **LinkedList**
```java
LinkedList<Integer> ll = new LinkedList<>();
ll.add(1);  // Add element
ll.addFirst(0);  // Add at beginning
ll.addLast(2);  // Add at end
int first = ll.getFirst();  // Get first element
int last = ll.getLast();  // Get last element
```

### **HashMap (Key-Value Pair)**
```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 5);  // Insert key-value pair
int count = map.getOrDefault("apple", 0);  // Get value or default
boolean hasKey = map.containsKey("apple");  // Check if key exists
boolean hasValue = map.containsValue(5);  // Check if value exists
map.remove("apple");  // Remove key
```

### **TreeMap (Sorted Map - Ascending Order)**
```java
Map<Integer, String> tmap = new TreeMap<>();
tmap.put(2, "two");
tmap.put(1, "one");  // Automatically sorted
```

### **HashSet (Unique Elements, Unordered)**
```java
Set<Integer> set = new HashSet<>();
set.add(1);  // Add element
boolean exists = set.contains(1);  // Check if exists
set.remove(1);  // Remove element
```

### **TreeSet (Sorted Set)**
```java
Set<Integer> tset = new TreeSet<>();
tset.add(3);
tset.add(1);  // Sorted automatically
```

### **Comparator & Comparable**
```java
class Person implements Comparable<Person> {
    int age;
    Person(int age) { this.age = age; }
    public int compareTo(Person p) { return Integer.compare(this.age, p.age); }
}

Comparator<Person> byAgeDesc = (p1, p2) -> Integer.compare(p2.age, p1.age);
Collections.sort(list, byAgeDesc);  // Custom sorting logic
```

### **Collections Utility Methods**
```java
List<Integer> repeatedList = Collections.nCopies(5, 100);  // List with 5 copies of 100
Collections.shuffle(list);  // Shuffle elements randomly
Collections.swap(list, 0, 1);  // Swap two elements
Collections.reverse(list);  // Reverse the list
```

### **Iterate Over Collections**
```java
for (int num : list) System.out.print(num + " ");  // Iterating ArrayList
for (Map.Entry<String, Integer> entry : map.entrySet()) 
    System.out.println(entry.getKey() + " -> " + entry.getValue());  // Iterate HashMap
Iterator<Integer> iter = list.iterator();
while (iter.hasNext()) System.out.println(iter.next());  // Using Iterator
```

### **Math Utilities**
```java
int max = Math.max(10, 20);  // Get max of two numbers
int min = Math.min(10, 20);  // Get min of two numbers
int abs = Math.abs(-5);  // Absolute value
double pow = Math.pow(2, 3);  // 2^3 = 8
double sqrt = Math.sqrt(16);  // Square root
int rand = (int) (Math.random() * 100);  // Random number (0 to 99)
```
