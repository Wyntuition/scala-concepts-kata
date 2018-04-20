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
