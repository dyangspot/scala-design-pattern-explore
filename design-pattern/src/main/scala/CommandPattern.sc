def invokeIt(i: Int, c: Command) = c.f(i)

case class Command(f: Int => Unit)

def cmd1 = Command(x => println(s"**$x**"))

def cmd2 = Command(x => println(s"**** $x ****"))


//invokeIt(3, cmd1)
invokeIt(54, cmd2)

( invokeIt(43, cmd2) )

