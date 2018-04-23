package FunctionalBasics

class ClassBasics() { 

  def runMe() {
    println("-----Classes Exercises-----")

    val p3 = new Person3("Carlos", "Santana")
    println(p3.greet)
    println(p3.fullName) // p3.fname / lname is not accessible    

    val p4 = new Person4("Dave", "Matthews") {  
      override def toString = s"$fname $lname" // override the default string representation   
    }  
    println(p4.fname)  
    println(p4.lname)  
    p4.lname = "Grohl" // lname is defined as var, so it has a setter too   
    println(p4)  

    val jp = new JPerson("Java Style")  
    val sp = new SPerson("Scala Style")  

    println(jp.name)  
    println(sp.name)  

    jp.name += " sucks!"  
    sp.name += " rocks!"  

    println(jp.getName)  
    println(sp.getName)  

    /// Options
    val greeting: Option[String] = Some("Hello option!")
    println(greeting)

    println("-----Case classses-----")
    case class Book(isbn: String)
    val frankenstein = Book("978-0486282114")
    val frankenstein2 = Book("978-0486282114")
    if (frankenstein == frankenstein2)
      println("Case classes compared by value")

    println("-----Traits-----")
    trait Greeter {
      def greet(name: String): Unit =
        println("Hello, " + name + "!") // default value
    }

    class DefaultGreeter extends Greeter

    class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
      override def greet(name: String): Unit = {
        println(prefix + name + postfix)
      }
    }

    val greeter = new DefaultGreeter()
    greeter.greet("Scala developer")

    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer")
    
    /// Class composition with mixins

    abstract class A {
      val message: String
    }
    class B extends A {
      val message = "Class B instance"
    }
    trait C extends A {
      def loudMessage = message.toUpperCase()
    }
    class D extends B with C

    val d = new D
    println(d.message)
    println(d.loudMessage)

    /// Higher order functions

    // Apply function to all items in collection
    var salaries = Seq(30000, 60000, 90000)
    val doubleSalary = (x: Int) => x * 2 // Passing this function into a map is a common use of higher order functions
    val doubledSalaries = salaries.map(doubleSalary)
    println(doubledSalaries)

    // Make it anonymous to shorten it
    val newSalaries = salaries.map(_ * 2)
    println(newSalaries)

    // Pass a function into a function 
    object SalaryRaiser {
      def promotion(salaries: Seq[Double], promotionFunction: Double => Double): Seq[Double] = 
        salaries.map(promotionFunction)
    }

    var salariesToChange = Seq(30000.50, 60000.50)
    println("Triple salary! " + SalaryRaiser.promotion(salariesToChange, salary => salary * 3))

    
  }
}

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

// Which can be generated in 1 line of idiomatic Scala   
import beans._  
class SPerson(@BeanProperty var name:String) // Note: @BeanProperty is optional for Java style getters and setters)

// A class with a public read only variable   
class Person3(fname:String, lname:String){  
  // a public read only field   
  val fullName = s"$fname $lname"   
  def greet = s"Hi $fullName!"  
}

// auto creates a getter for fname, and getter + setter to lname
class Person4(val fname:String, var lname:String)  

case class Point(x: Int, y: Int)
