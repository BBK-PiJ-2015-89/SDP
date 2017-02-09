import java.io.PrintWriter

object ScalaTut {
  def main(args: Array[String]) {

    var i = 0

    while (i <= 10) {
      println(i)
      i += 1
    }

    do {
      println(i)
      i += 1
    } while (i <= 20)

    for (i <- 1 to 10) {
      println(i)
    }

    // until is often used to loop through strings or arrays
    val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    for (i <- 0 until randLetters.length) {

      // Get the letter in the index of the String
      println(randLetters(i))
    }

    // Used to iterate through a list
    val aList = List(1, 2, 3, 4, 5)
    for (i <- aList) {
      println("List Item " + i)
    }

    // Store even numbers in a list
    val evenList = for {i <- 1 to 20
                        // You can put as many conditons here separated with semicolons
                        // as you need
                        if (i % 2) == 0
    } yield i

    println("Even List")
    for (i <- evenList)
      println(i)

    // This loop assigns a value to the 1st variable and it retains
    // that value until the 2nd finishes its cycle and then it iterates
    for (i <- 1 to 5; j <- 6 to 10) {
      println("i: " + i)
      println("j: " + j)
    }

    // There is no break or continue in Scala
    def printPrimes() {

      val primeList = List(1, 2, 3, 5, 7, 11)
      for (i <- primeList) {

        // Works like break if you return from a function
        if (i == 11) {
          return
        }

        // Works like continue
        if (i != 1) {
          println(i)
        }

      }

    }

    printPrimes

    import scala.io.StdIn.readInt

    // ---------- INPUT / OUTPUT ----------

    var numberGuess = 0

    do {
      print("Guess a number (15 to end): ")

      // You can also use readInt, readDouble, readByte, readShort, readLong,
      //
      numberGuess = readInt
      println(s"Read in $numberGuess")

    } while (numberGuess != 15)

    printf("You guessed the secret number %d\n", 15)

    // You can use string interpolation
    val name = "Derek"
    val age = 39
    val weight = 175.5
    println(s"Hello $name")

    println(f"I am ${age + 1} and weigh $weight%.2f")

    // printf Style Format Specifiers
    // %c : Characters
    // %d : Integers
    // %f : Floating Point Numbers
    // %s : Strings
    printf("'%5d'\n", 5) // Right justify

    printf("'%-5d Hi'\n", 5) // Left justify

    printf("'%05d'\n", 5) // Zero Fill

    printf("'%.5f'\n", 3.14) // 5 decimal minimum & maximum

    printf("'%-5s'\n", "Hi") // Left Justify String

    // Special Characters : \n, \b, \\, \a

    // ---------- STRINGS ----------
    var randSent = "I saw a dragon fly by"

    // Get the 3rd index value
    println("3rd Index : " + randSent(3))

    // Get String length
    println("String length " + randSent.length())

    // Concatenate strings
    println(randSent.concat(" and explode"))

    // Compare strings for equality
    println("Are strings equal " + "I saw a dragon".equals(randSent))

    // Get index of a match
    println("dragon starts at index ", randSent.indexOf("dragon"))

    // Convert a string into an array
    val randSentArray = randSent.toArray

    for (v <- randSentArray)
      println(v)

    // ---------- FUNCTIONS ----------
    // def funcName (param1:dataType, param2:dataType) : returnType = {
    //    function body
    //    return valueToReturn
    // }

    // You can give parameters default values
    def getSum(num1: Int = 1, num2: Int = 1): Int = {
      return num1 + num2
    }

    println("5 + 4 = " + getSum(5, 4))

    // you can use named arguments
    println("5 + 4 = " + getSum(num2 = 5, num1 = 4))

    // A function that returns nothing (Procedure)
    def sayHi(): Unit = {
      println("Hi how are you doing")
    }

    sayHi

    // Receive variable number of arguments
    def getSum2(args: Int*): Int = {
      var sum: Int = 0
      for (num <- args) {
        sum += num
      }
      sum
    }

    println("getSum2: " + getSum2(1, 2, 3, 4, 5))

    // Recursion example calculating factorials
    def factorial(num: BigInt): BigInt = {
      if (num <= 1)
        1
      else
        num * factorial(num - 1)
    }

    // 1st: num = 4 * factorial(3) = 4 * 6 = 24
    // 2nd: num = 3 * factorial(2) = 3 * 2 = 6
    // 3rd: num = 2 * factorial(1) = 2 * 1 = 2

    println("Factorial of 4 = " + factorial(4))

    // ---------- ARRAYS ----------
    // You'll use arrays when the size is fixed, or an ArrayBuffer for a
    // variable size

    // Create an array of Ints with a max size of 20
    val favNums = new Array[Int](20)

    // Create and initialize array in 1 line
    val friends = Array("Bob", "Tom")

    // Change the value in an array
    friends(0) = "Sue"

    println("Best Friend " + friends(0))

    import scala.collection.mutable.ArrayBuffer

    // Create an ArrayBuffer
    val friends2 = ArrayBuffer[String]()

    // Add an item to the 1st index
    friends2.insert(0, "Phil")

    // Add item to the next available slot
    friends2 += "Mark"

    // Add multiple values to the next available slot
    friends2 ++= Array("Susy", "Paul")

    // Add items starting at 2nd slot
    friends2.insert(1, "Mike", "Sally", "Sam", "Mary", "Sue")

    // Remove the 2nd element
    friends2.remove(1)

    // Remove 2 elements starting at the 2nd index
    friends2.remove(1, 2)

    // Cycle through and print ArrayList or Array
    var friend: String = " "
    for (friend <- friends2)
      println(friend)

    // Add values to an array with a loop
    for (j <- 0 to (favNums.length - 1)) {
      favNums(j) = j
      println(favNums(j))
    }

    // Use yield to multiply all values times 2 and store in a new array
    val favNumsTimes2 = for (num <- favNums) yield 2 * num

    // Another way to print out values in array
    favNumsTimes2.foreach(println)

    // You can also store values that match a condition
    var favNumsDiv4 = for (num <- favNums if num % 4 == 0) yield num

    favNumsDiv4.foreach(println)

    // Create a multidimensional array with Array.ofDim
    var multTable = Array.ofDim[Int](10, 10)

    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        multTable(i)(j) = i * j
      }
    }

    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        printf("%d : %d = %d\n", i, j, multTable(i)(j))
      }
    }

    println("Sum : " + favNums.sum)

    println("Min : " + favNums.min)

    println("Max : " + favNums.max)

    // Sort in desending order (Use < for assending)
    val sortedNums = favNums.sortWith(_ > _)

    // Return an indexed sequence and convert it into a string with commas
    println(sortedNums.deep.mkString(", "))

    // ---------- MAPS ----------
    // Maps are collections of key value pairs

    // Create a Map that can't be changed (Immutable)
    val employees = Map("Manager" -> "Bob Smith", "Secretary" -> "Sue Brown")

    // Get value using the key after checking that it exists
    if (employees.contains("Manager"))
      printf("Manager : %s\n", employees("Manager"))

    // Create a Mutable map
    val customers = collection.mutable.Map(100 -> "Paul Smith",
      101 -> "Sally Smith")

    printf("Cust 1 : %s\n", customers(100))

    // Change a value using the key
    customers(100) = "Tom Marks"

    // Add an item
    customers(102) = "Megan Swift"

    // Output a Map
    for ((k, v) <- customers)
      printf("%d : %s\n", k, v)

    // ---------- TUPLES ----------
    // Tuples can hold values of many types, but they are immutable

    val tupleMarge = (103, "Marge Simpson", 10.25)

    printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)

    // Iterate through a tuple
    tupleMarge.productIterator.foreach { i => println(i) }

    // Convert Tuple to String
    println(tupleMarge.toString())

    // ---------- CLASSES ----------
    val rover = new Animal
    rover.setName("Rover")
    rover.setSound("Woof")
    printf("%s says %s\n", rover.getName, rover.getSound)

    val whiskers = new Animal("Whiskers", "Meow")
    println(s"${whiskers.getName} with id ${whiskers.id} says ${whiskers.getSound}")

    println(whiskers.toString)

    val spike = new Dog("Spike", "Woof", "Grrrr")

    spike.setName("Spike")
    println(spike.toString)

    val fang = new Wolf("Fang")
    fang.moveSpeed = 36.0
    println(fang.move)

    // ---------- TRAITS ----------
    val superman = new Superhero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(2500))

    import scala.math._

    // ---------- HIGHER ORDER FUNCTIONS ----------
    // Functions can be passed like any other variable
    // You need the _ after the function to state you meant the function
    val log10Func = log10 _

    println(log10Func(1000))

    // You can apply a function to all items of a list with map
    List(1000.0, 10000.0).map(log10Func).foreach(println)

    // You can use an anonymous function with map as well
    // Receives an Int x and multiplies every x by 50
    List(1, 2, 3, 4, 5).map((x: Int) => x * 50).foreach(println)

    // Filter will pass only those values that meet a condition
    List(1, 2, 3, 4, 5, 6).filter(_ % 2 == 0).foreach(println)

    // Pass different functions to a function
    def times3(num: Int) = num * 3

    def times4(num: Int) = num * 4

    // Define the function parameter type and return type
    def multIt(func: (Int) => Double, num: Int) = {
      func(num)
    }

    printf("3 * 100 = %.1f)\n", multIt(times3, 100))

    // A closure is a function that depends on a variable declared outside
    // of the function
    val divisorVal = 5
    val divisor5 = (num: Double) => num / divisorVal
    println("5 / 5 = " + divisor5(5.0))

    // ---------- FILE I/O ----------
    // Use import java.io.PrintWriter to write to a file
    val writer = new PrintWriter("test.txt")
    writer.write("Just some random text\nSome more random text")
    writer.close()

    import scala.io.Source

    // Use import scala.io.Source to read from files
    val textFromFile = Source.fromFile("test.txt", "UTF-8")

    // Iterate through each line in the file and print
    val lineIterator = textFromFile.getLines
    for (line <- lineIterator) {
      println(line)
    }
    textFromFile.close()

    // ---------- EXCEPTION HANDLING ----------

    def divideNums(num1: Int, num2: Int) = try {
      (num1 / num2)
    } catch {
      case ex: java.lang.ArithmeticException => "Can't divide by zero"
    } finally {
      // Clean up after exception here
    }

    println("3 / 0 = " + divideNums(3, 0))

  }
}
