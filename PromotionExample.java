// four topic
//1.object cration
//2.instance variable and local variable
//3.method with memory map(JVM area)
//4.method overloading



//1.object creation

// a.we can use "new" operator to create an object
// b.No Explicit Deletion: In Java,no "delete keyWord use" you do not explicitly delete objects. The "garbage collector" takes care of cleaning up unused objects.


// algorith for object creation
// step1: Define a Class:
//  The class serves as a blueprint for the object. It includes fields (variables) and methods (functions).
// step2
// Constructor Definition: Define a constructor to initialize the field
// step3
// Object Instantiation:
// a.Use the new keyword followed by the constructor of the class.
// b.Pass necessary parameters to the constructor if required.

//step4
// Method Invocation: Call methods on the created object to perform actions.

//sortcut four step
// a.Define class with fields and methods
// b.Define constructor to initialize fields
// c.Create object using 'new' keyword and constructor
// d.Call methods on the object

// Step 1: Define the class
// public class Car {
//   // Step 2: Define fields
//   private String model;
//   private int year;

//   // Step 3: Define a constructor
//   public Car(String model, int year) {
//       this.model = model;
//       this.year = year;
//   }

//   // Define methods
//   public void displayInfo() {
//       System.out.println("Model: " + model + ", Year: " + year);
//   }
// }

// // Step 4: Create an object and use it
// public class basic {
//   public static void main(String[] args) {
//       // Create an object of Car
//       Car myCar = new Car("Toyota", 2022);

//       // Call method on the object
//       myCar.displayInfo();
//   }
// }






// topic2 types of variable
// three types
// a.instance variable
//b.static or class variable
//c.local variable


//1. Instance Variables (Non-Static Fields):
//   a.Belong to an instance of a class.
//   b.Each object has its own copy of these variables.
//   c.Defined outside any method, constructor, or block.
//   d.Initialized when the object is created and destroyed when the object is destroyed.

// 2.Class Variables (Static Fields):
//   a.Belong to the class, not to any particular instance.
//   b.Only one copy exists, regardless of how many objects are created.
//  c.Defined with the static keyword.
//   d.Initialized when the class is loaded and destroyed when the class is unloaded.

// 3.Local Variables:
//   a.Declared inside a method, constructor, or block.
// c.b.Only accessible within the method, constructor, or block where it is declared.
// d.Created when the method, constructor, or block is entered and destroyed when it is exited.
// e.Must be initialized before use.



// public class Car {
//   // Instance variable
//   private String model;
//   private int year;
  
//   // Class variable (static field)
//   private static int numberOfCars;

//   // Constructor (using parameters)
//   public Car(String model, int year) {
//       this.model = model;
//       this.year = year;
//       numberOfCars++;
//   }

//   // Method to display car information
//   public void displayInfo() {
//       // Local variable
//       String info = "Model: " + model + ", Year: " + year;
//       System.out.println(info);
//   }

//   // Static method to get the number of cars
//   public static int getNumberOfCars() {
//       return numberOfCars;
//   }
// }




//3.method with memory map(JVM area)

// 1.JVM Memory Areas Overview:
// 1.Heap: This is where all the objects and their instance variables are stored. It’s shared among all threads.

// 2.Stack: Each thread has its own stack, which stores method call frames (activation records). Each frame holds local variables and partial results, along with some other information.

// 3.Method Area: This area stores class structures such as the runtime constant pool, field, and method data, and the code for methods and constructors.

// 4.Program Counter (PC) Register: Each thread has its own PC register, which stores the address of the current instruction being executed.

//5. Native Method Stack: It contains all the native method information used in the application.


// Algorithm for Method Execution and Memory Map:
// 1.Class Loading:
//   The class loader loads the class file into the JVM.
//   The class data is stored in the Method Area.

// 2.Method Invocation:
//     When a method is called, a new frame is created and pushed onto the stack of the current thread.
//     The frame contains the local variables, operand stack, and a reference to the runtime constant pool of the class.

// 3.Memory Allocation:
//    Local Variables: Allocated in the stack frame.
//     Method Code: Executed in the method area.
//     Object Creation: Objects are created in the heap.

// 4.Execution:
//     The JVM’s execution engine executes bytecode instructions from the method area.
//     Local variables are accessed from the stack.
//     Objects and class-level data are accessed from the heap and method area, respectively.

// 5.Method Return:
//     Once the method completes, its frame is popped from the stack, and control is returned to the calling method.
//     If the method returns a value, the value is pushed onto the operand stack of the caller’s frame.


// public class Example {
//   public static void main(String[] args) {
//       Example ex = new Example();
//       ex.methodA();
//   }

//   public void methodA() {
//       int x = 10;
//       methodB(x);
//   }

//   public void methodB(int value) {
//       int y = value + 20;
//       System.out.println(y);
//   }
// }

// 1.Class Loading:
// Example class is loaded by the class loader.
// Class data (including the bytecode for main, methodA, and methodB) is stored in the Method Area.

// 2.main Method Execution:
// JVM starts execution from the main method.
// A new frame for main is created and pushed onto the stack.


// Stack:
// | main() frame |
// |-------------|

// Heap:
// |           |

// Method Area:
// | Example class data |


// 3.Object Creation:

// Example ex = new Example(); creates a new Example object in the heap.

// Stack:
// | main() frame          |
// | ex (reference)        |
// |-----------------------|

// Heap:
// | Example object        |

// Method Area:
// | Example class data    |


// 4.Calling methodA:

// ex.methodA(); is invoked.
// A new frame for methodA is created and pushed onto the stack

// Stack:
// | methodA() frame       |
// | x = 10                |
// |-----------------------|
// | main() frame          |
// | ex (reference)        |
// |-----------------------|

// Heap:
// | Example object        |

// Method Area:
// | Example class data    |


// 5.Calling methodB:

// methodB(x); is invoked with x = 10.
// A new frame for methodB is created and pushed onto the stack5.

// Stack:
// | methodB() frame       |
// | value = 10            |
// | y = 30                |
// |-----------------------|
// | methodA() frame       |
// | x = 10                |
// |-----------------------|
// | main() frame          |
// | ex (reference)        |
// |-----------------------|

// Heap:
// | Example object        |

// Method Area:
// | Example class data    |



// 6.Method Completion:

// methodB completes, and its frame is popped off the stack.
// Control returns to methodA.

// Stack:
// | methodA() frame       |
// | x = 10                |
// |-----------------------|
// | main() frame          |
// | ex (reference)        |
// |-----------------------|

// Heap:
// | Example object        |

// Method Area:
// | Example class data    |



// 7.Returning to main:

// methodA completes, and its frame is popped off the stack.
// Control returns to main.


// 8.Program Completion:

// main completes, and its frame is popped off the stack.
// The program terminates


// Stack:
// |                       |

// Heap:
// |                       |

// Method Area:
// | Example class data    |


// Summary:
// Class Loading: Class data is loaded into the method area.
// Method Invocation: Frames are created on the stack for each method call.
// Memory Allocation: Objects are stored in the heap, local variables in the stack.
// Garbage Collection: The heap memory is managed by the garbage collector, which reclaims memory of objects that are no longer reachable








// topic 4 method overloading

// Method overloading in Java allows a class to have more than one method having the same name, if their parameter lists are different. It is a form of polymorphism

// public class Calculator {
    
//     // Method to add two integers
//     public int add(int a, int b) {
//         return a + b;
//     }
    
//     // Overloaded method to add three integers
//     public int add(int a, int b, int c) {
//         return a + b + c;
//     }
    
//     // Overloaded method to add two doubles
//     public double add(double a, double b) {
//         return a + b;
//     }
    
//     // Overloaded method to concatenate two strings
//     public String add(String a, String b) {
//         return a + b;
//     }
    
//     // Main method to demonstrate method overloading
//     public static void main(String[] args) {
//         Calculator calc = new Calculator();
        
//         // Calling different overloaded methods
//         System.out.println(calc.add(2, 3));             // Calls int add(int, int)
//         System.out.println(calc.add(2, 3, 4));          // Calls int add(int, int, int)
//         System.out.println(calc.add(2.5, 3.5));         // Calls double add(double, double)
//         System.out.println(calc.add("Hello", "World")); // Calls String add(String, String)
//     }
// }




// Explanation:
// Four Overloaded Methods: In the Calculator class, there are four methods named add, each with a different parameter list:

// add(int a, int b)
// add(int a, int b, int c)
// add(double a, double b)
// add(String a, String b)
// Method Calls: In the main method:

// calc.add(2, 3) calls add(int a, int b)
// calc.add(2, 3, 4) calls add(int a, int b, int c)
// calc.add(2.5, 3.5) calls add(double a, double b)
// calc.add("Hello", "World") calls add(String a, String b)
// Compile-Time Resolution: The Java compiler determines which method to call based on the number and types of arguments passed during the method call.

// Benefits of Method Overloading:
// Code Readability: Provides a clear and intuitive way to name methods based on their functionality.
// Flexibility: Allows developers to provide multiple methods with the same name but different parameters, catering to different use cases.




// How Automatic Promotion Works in Method Overloading:
// Promotion Rules:
//    a.When you pass arguments to a method, Java automatically promotes them to a compatible type if necessary.
//     b.The promotion follows a specific hierarchy: byte, short, int, long, float, and double.

// Priority of Numeric Types:
//   a. byte, short, and char are promoted to int.
//    b.int is promoted to long.
//   c.long is promoted to float.
//   d.float is promoted to double.


// Rules of Automatic Promotion:
// 1.Smaller to Larger Data Type:
// If two overloaded methods differ only in the type of their parameters, Java automatically promotes smaller data types to larger ones to match the method signature.

// 2.Data Type Hierarchy:
// Java follows a hierarchy of data types for automatic promotion:
// byte ➔ short ➔ int ➔ long ➔ float ➔ double

//3. Example Scenarios:
// If an overloaded method expects an int, but you pass a byte or a short, Java will promote the byte or short to an int.
// If an overloaded method expects a double, but you pass an int or a float, Java will promote the int to a float, or the float to a double, respectively.




// public class PromotionExample {
    
//     // Method to accept an int parameter
//     public void display(int num) {
//         System.out.println("Integer: " + num);
//     }
    
//     // Overloaded method to accept a double parameter
//     public void display(double num) {
//         System.out.println("Double: " + num);
//     }
    
//     // Main method to demonstrate automatic promotion
//     public static void main(String[] args) {
//         PromotionExample example = new PromotionExample();
        
//         // Calling methods with different types of parameters
//         example.display(10);      // Calls display(int num)
//         example.display(10.5);    // Calls display(double num)
        
//         // Automatic promotion from int to double
//         int x = 5;
//         example.display(x);       // Calls display(int num)
        
//         // Automatic promotion from float to double
//         float y = 5.5f;
//         example.display(y);       // Calls display(double num)
//     }
// }


// Explanation:
// Two Overloaded Methods: The PromotionExample class has two overloaded methods named display, each accepting a different type of parameter (int and double).

// Method Calls:
// example.display(10) calls display(int num).
// example.display(10.5) calls display(double num).

// Automatic Promotion:
// When example.display(x) is called, where x is an int, Java automatically promotes int to double, so display(int num) is called.
// When example.display(y) is called, where y is a float, Java automatically promotes float to double, so display(double num) is called