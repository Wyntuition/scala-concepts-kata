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

  /// - allows duplicates

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
  // - You can’t have duplicate values, adding a value that already exists overwrites the value

  val set1 = Set(1, 2, 3) //Immutable set of type Set[Int]  
  val set2 = Set("a", 2, true) //Immutable list of type Set[Any]  
  import collection.mutable  
  val mset = mutable.HashSet("a", "b", "c") //the "mutable version" of Set  

  // Sets remove duplicates   
  println(Set(1,2,3,2,4,3,2,1,2)) //Set(1, 2, 3, 4)

  /// Maps 

  val map1 = Map("one" -> 1, "two" -> 2, "three" -> 3)   
  // Map of type Map[String, Int]  
  val map2 = Map(1 -> "one", "2" -> 2.0, 3.0 -> false)   
  //Map of type Map[Any, Any]  

  import collection.mutable  
  val mmap = mutable.HashMap("a" -> 1, "b" -> 2 , "c" -> 3)   
  // the "mutable version" of Map  

  // Maps remove duplicate keys:  
  println(Map("a" -> 1, "a" -> 2)) // Map(a -> 2)  

  // Get items using map(key)
  val one = map1("one")

  /// Classes

  // A class with a public read only variable   
  class Person3(fname:String, lname:String){  
    // a public read only field   
    val fullName = s"$fname $lname"   
    def greet = s"Hi $fullName!"  
  }  

  val p3 = new Person3("Carlos", "Santana")  
  println(p3.greet)  
  println(p3.fullName)   
  // p3.fname / lname is not accessible  

  // auto creates a getter for fname, and getter + setter to lname  
  class Person4(val fname:String, var lname:String)  

  val p4 = new Person4("Dave", "Matthews") {  
    // override the default string representation   
    override def toString = s"$fname $lname"   
  }  
  println(p4.fname)  
  println(p4.lname)  
  // lname is defined as var, so it has a setter too  
  p4.lname = "Grohl"  
  println(p4)  

  // A full Java boilerplate style class (not idiomatic Scala!)  
  class JPerson() {  
    var _name: String = null  
    def this(_name:String) = {  
      this()  
          this._name = _name  
    }  
    //Scala style getters and setters   
    def name_=(_name:String) = this._name = _name  
    def name = this._name  
      
    //Java style getters and setters    
    def getName() = name  
    def setName(name:String) = this.name = name  
  }  

  //Which can be generated in 1 line of idiomatic Scala   
  import beans._  
  class SPerson(@BeanProperty var name:String)  
  //Note: @BeanProperty is optional   
  //(only if you need Java style getters and setters)  

  val jp = new JPerson("Java Style")  
  val sp = new SPerson("Scala Style")  

  println(jp.name)  
  println(sp.name)  

  jp.name += " sucks!"  
  sp.name += " rocks!"  

  println(jp.getName)  
  println(sp.getName)  

}