package app

/**
 * typealias - псевдоним
 */
typealias MutableListTask = MutableList<Task>
const val ERROR = "Ошибка!\n"

fun main() {
    val listTasks = mutableListOf<Task>()
    while (true) {
        println(
            "1. Добавить задачу\n" +
                    "2. Показать список\n" +
                    "3. Поиск по заголовку\n" +
                    "4. Отметить как выполненную\n" +
                    "5. Удалить задачу\n" +
                    "6. Удалить все задачи\n" +
                    "7. Выход"
        )
        print("Выберите ID: ")
        val userID = readLine()!!.trim().toIntOrNull()
        if (userID == null || userID !in 1..7) {
            println(ERROR)
            return
        }

        when (userID) {
            1 -> addTask(listTasks)
            2 -> tasks(listTasks)
            3 -> searchTasks(listTasks)
            4 -> markAsDone(listTasks)
            5 -> removeTask(listTasks)
            6 -> clearTasks(listTasks)
            7 -> {
                println("До свидание!")
                break
            }
        }
    }
}