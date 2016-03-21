val s = List(2,5,2,4,1).sortWith((x,y) => x < y)

println(s)

/**
  * Open/Closed principle
  */

def addThen(a: Int, b: Int) = a + b

def substractThem(a: Int, b: Int) = a - b

def multiplyThem(a: Int, b: Int) = a * b


def execute(f: (Int, Int) => Int, x: Int, y: Int) = f(x,y)

println("Add =>" + execute(addThen, 4, 5))
println("Add =>" + execute(multiplyThem, 4, 5))

