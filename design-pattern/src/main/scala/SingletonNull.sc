val m = List(Some("on"), None, Some("us"), None)

println(m.flatten)

m.foreach(println(_))

m.map(x =>  x.getOrElse("sdf") + "fff")


