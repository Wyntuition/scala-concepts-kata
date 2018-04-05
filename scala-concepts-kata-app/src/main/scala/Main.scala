object Main extends App {
  /// Number operations   

  /// Ranges   
  // creates a range between 1 to 10 inclusive  
  val range = 1 to 10   
  // creates a range between 1 to 10 exclusive   
  val range2 = 1 until 10   
  // from 2 to 10 with jumps of 3  
  val range3 = 2 until 10 by 3   

  println(range3.toList) //List(2, 5, 8)  

  /// Number convinience methods   

  val num = -5  
  val numAbs = num.abs //absolute value  
  val max5or7 = numAbs.max(7)  
  val min5or7 = numAbs.min(7)  
  println(numAbs) //5  
  println(max5or7) //7   
  println(min5or7) //5  

  /// String operations   

  val reverse = "Scala".reverse //reverse a string   
  println(reverse) //alacS  

  val cap = "scala".capitalize //make first char caps  
  println(cap) //Scala  

  val multi = "Scala!" * 7 //repeat n times   
  println(multi) //Scala!Scala!Scala!Scala!Scala!Scala!Scala!  

  val int = "123".toInt //parse as Int  
  println(int)  

  /// Useful methods on collections   

  // filter - keep only items larger than 4   
  val moreThan4 = range.filter(_ > 4)  
  println(moreThan4) //Vector(5, 6, 7, 8, 9, 10)  

  // map - transform each item in the collection   
  val doubleIt = range2.map(_ * 2)  
  println(doubleIt) //Vector(2, 4, 6, 8, 10, 12, 14, 16, 18)  

  /// Anonymous functions
  // a method that requires a function as a parameter  
  // the function's type is (Int,Int) => Int  
  // e.g. maps from 2 Ints to an Int  
  def doWithOneAndTwo(f: (Int, Int) => Int) = {  
    f(1, 2)  
  }  

  // Explicit type declaration  
  val call1 = doWithOneAndTwo((x: Int, y: Int) => x + y)  

  // The compiler expects 2 ints so x and y types are inferred  
  val call2 = doWithOneAndTwo((x, y) => x + y)  

  // Even more concise syntax  
  val call3 = doWithOneAndTwo(_ + _)  

  println(call1, call2, call3)  

  /// For loops
  
  var sum = 0  
  for ( i <- 0 until 10) {  
    sum += i  
  }  
  println(sum)  
  
  // Scala way
  println((0 until 10).sum)

  /// Pattern matching

  val selection = "One"  
  selection match {  
    case "One" => println("You selected option one!")  
    case "Two" => println("You selected option two!")  
    case _ => println("You selected something else: ")  
  }  

  /// Arrays

  def printArray[K](array:Array[K]) = array.mkString("Array(" , ", " , ")") 

  // Mutable array of type Array[Int]  
  val array1 = Array(1, 2, 3)   // array1 = [I@6ae01647  
  printArray(array1) // Array(1, 2, 3)  
  // Mutable array of type Array[Any]  
  val array2 = Array("a", 2, true) // array2 = [Ljava.lang.Object;@1dd6c622  
  printArray(array2) // Array(a, 2, true)  

  // Additional functions such as diff, find, etc.

  /// Lists

  // Immutable list of type List[Int]  
  val list1 = List(1, 2, 3) //> list1 = List(1, 2, 3)  
  // Immutable list of type List[Any]  
  val list2 = List("a", 2, true) //> list2 = List(a, 2, true)  
  import collection.mutable   
  // the "mutable version" of List  
  val mlist = mutable.ArrayBuffer("a", "b", "c") //> mlist = ArrayBuffer(d, b, e, f, g)  

  // Access items using (index) not [index]   
  println(list1(0)) //> firstItem = 1  

  /// Sets 
  // You can’t have duplicate values, adding a value that already exists overwrites the value

  val set1 = Set(1, 2, 3) //Immutable set of type Set[Int]  
  val set2 = Set("a", 2, true) //Immutable list of type Set[Any]  
  import collection.mutable  
  val mset = mutable.HashSet("a", "b", "c") //the "mutable version" of Set  

  // Sets remove duplicates   
  println(Set(1,2,3,2,4,3,2,1,2)) //Set(1, 2, 3, 4)  

}