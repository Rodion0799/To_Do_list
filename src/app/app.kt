package app

fun main() {
    val listTasks = mutableListOf<Task>()
    while (true) {
        println(
            "1. Добавить задачу\n" +
                    "2. Показать список\n" +
                    "3. Отметить как выполненную\n" +
                    "4. Удалить задачу\n" +
                    "5. Выход"
        )
        print("Выберите ID: ")
        val userID = readLine()!!.trim().toIntOrNull()
        if (userID == null || userID !in 1..5) {
            println("Ошибка!")
            return
        }

        when (userID) {
            1 -> addTask(listTasks)
            2 -> tasks(listTasks)
            3 -> markAsDone(listTasks)
            4 -> removeTask(listTasks)
            5 -> {
                println("До свидание!")
                break
            }
        }
    }
}
