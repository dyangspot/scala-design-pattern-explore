

case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None ) {
  def add(av: Int) = insert(av).get

  def insert(av: Int): Option[TreeNode] = {
    def insertLeft(av: Int) = left.flatMap(nodeExist => insert(av)) orElse Option(TreeNode(av))

    def insertRight(av: Int) = right.flatMap(nodeExist => insert(av)) orElse Option(TreeNode(av))

    av.compare(value) match {
      case 0 => Option(this)
      case -1 => Option(TreeNode(value, insertLeft(av), right))
      case 1 => Option(TreeNode(value, left, insertRight(av)))
    }
  }

  def traverseItInOrder(): Option[List[TreeNode]] = {
    val leftList:  List[TreeNode] = left.flatMap(x => x.traverseItInOrder).getOrElse(Nil)
    val rightList: List[TreeNode]= right.flatMap(x => x.traverseItInOrder).getOrElse(Nil)
    Option((leftList :+ this) ++ rightList)
  }

  def traverseInOrder() = {
    val result: Option[List[TreeNode]] = traverseItInOrder()
    result.getOrElse(Nil)
  }
}


val tree = TreeNode(4).add(5).add(2).add(99).add(0).add(43)
for {
  q <- tree.traverseInOrder()
} println(q.value)


/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
           佛祖保佑       永无BUG
 */