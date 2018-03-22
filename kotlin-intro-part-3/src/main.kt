
// Utilizziamo come piano la console che consente solo punti interi
data class Point(var x: Int, var y: Int)

open class Rectangle(var origin: Point, open var width: Int, open var height: Int)

class RectangleDrawer {
    private fun leftOffset(size: Int) {
        for (i in 0..size-1) {
            print("  ")
        }
    }

    private fun printTopDownLedge(size: Int, char: Char) {
        for (j in 0..size-1) {
            print(char)
            print(' ')
        }
    }

    fun draw(rectangle: Rectangle, char: Char) {
        // Spazia verticalmente l'origine
        val xStart = rectangle.origin.x
        for (i in 0..rectangle.origin.y-1) {
            println()
        }
        // Stampa la cornice superiore
        leftOffset(xStart)
        printTopDownLedge(size = rectangle.width, char = char)
        println()
        // Stampa il corpo
        for (i in 0..rectangle.height-2 -1) {
            leftOffset(xStart)
            print(char)
            for (j in 0..rectangle.width-2 -1) {
                print(' ')
                print(' ')
            }
            print(' ')
            println(char)
        }
        // Stampa la cornice inferiore
        leftOffset(xStart)
        printTopDownLedge(size = rectangle.width, char = char)
        println()
    }
}

fun main(args: Array<String>) {
    val rect = Rectangle(origin = Point(1,1), width = 5, height = 3)
    val drawer = RectangleDrawer()
    drawer.draw(rect, '#')

    val square = Square(origin = Point(2, 2), side = 4)
    drawer.draw(square, 'S')
}

class Square(origin: Point, side: Int) : Rectangle(origin, side, side) {
    override var width: Int
        get() = super.width
        set(value) {super.width = value; super.height = value}

    override var height: Int
        get() = super.height
        set(value) {super.height = value; super.width = value}

    var side: Int
        get() = super.height
        set(value) {super.height = value; super.width = value}

}
