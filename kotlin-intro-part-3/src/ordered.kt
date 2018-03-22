import kotlin.collections.ArrayList

class OrderedVector(presize: Int = 10) {
    private var list: MutableList<Int>

    init {
        if (presize < 0) {
            throw RuntimeException("Illegal size")
        }
        list = ArrayList(presize)
    }

    private fun binarySearchOrInsert(list: MutableList<Int>, item: Int): Int {
        var inf = 0
        var sup = list.size - 1
        while (inf <= sup) {
            val med = (inf + sup) / 2
            if (list[med] == item)
                return med
            if (list[med] < item)
                inf = med + 1
            else
                sup = med - 1
        }
        return inf
    }

    fun add(item: Int) {
        // Cerca la posizione tra l'elemento minore di item e l'elemento maggiore di item
        val position = binarySearchOrInsert(list, item)
        list.add(position, item)
    }

    fun get(position: Int): Int = list[position]

    // Restituisce la posizione di un elemento o null se l'elemento non è presente
    fun find(item: Int): Int? {
        val pos = binarySearchOrInsert(list, item)
        if (item == list.get(pos) ) {
            return pos
        } else {
            return null
        }
    }

    fun size(): Int = list.size

    override fun toString(): String { return list.toString() }
}

fun main(args: Array<String>) {
    val vector = OrderedVector(presize = 10)
    vector.add(10)
    vector.add(5)
    vector.add(1)
    vector.add(3)
    vector.add(15)
    println(vector) // [1, 3, 5, 10, 15]

    println(vector.find(4)) // null
    println(vector.find(3)) // 1

    // vector.list.add(0, 30) // Errore di compiazione
}