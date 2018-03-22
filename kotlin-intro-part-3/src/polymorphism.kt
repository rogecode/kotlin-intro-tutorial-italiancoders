abstract class Animal {

    abstract fun greet(): String?
}

class Dog : Animal() {
    override fun greet(): String {
        return "Woof woof"
    }
}

class Cat : Animal() {
    override fun greet(): String {
        return "Meow"
    }
}

class Crocodrile : Animal() {
    override fun greet(): String? {
        return null
    }
}

fun main(args: Array<String>) {

    var animal: Animal = Dog()
    println("ANIMAL (DOG)")
    println(animal.greet())
    animal = Cat()
    println("ANIMAL (CAT)")
    println(animal.greet())
    animal = Crocodrile()
    println("ANIMAL (CROCODRILE)")
    println(animal.greet())

    println("CAT GREET")
    var cat: Cat = Cat()
    println(cat.greet())
    // non si può scrivere cat = Dog()

    println("DOG GREET")
    var dog: Dog = Dog()
    println(dog.greet())
}