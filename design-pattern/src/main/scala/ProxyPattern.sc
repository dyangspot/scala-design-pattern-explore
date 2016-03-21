lazy val s = Stream.cons(1, Stream.cons(2, Stream.empty))
println(s)
if (s.nonEmpty) println(s.head)

var k = 0
def getVal = {
  k += 1
  k
}

def g(i: => Int) = {
  println(s"$i")
  println(s"$i")
  println(s"$i")
  println(s"$i")
}

g(getVal)