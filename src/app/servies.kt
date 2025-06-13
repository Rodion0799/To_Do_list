package app

/**
 * Добавляет новую задачу в список
 */
fun addTask(listTasks: MutableList<Task>) {
    print("Введите название задачи: ")
    val userTitle = readLine()!!.trim()
    if (userTitle.isBlank()) {
        println("Ошибка!")
        return
    }

    listTasks.add(Task(userTitle, false))
    println("Задача добавлена!\n")
}

/**
 * Выводит список задач с индексами и статусами
 */
fun tasks(listTasks: MutableList<Task>) {
    if (listTasks.isEmpty()) {
        println("У вас нет задач!")
    }

    listTasks.forEachIndexed { index, task ->
        val resultIsCompleted = if (task.isCompleted) "[x]" else "[]"
        println("${index + 1}. ${task.title} $resultIsCompleted")
    }
    println()
}


/**
 * Отмечает выбранную задачу как выполненную
 */
fun markAsDone(listTasks: MutableList<Task>) {

    if (listTasks.isEmpty()) {
        println("У вас нет задач!")
        return
    }

    listTasks.forEachIndexed { index, task ->
        val resultIsCompleted = if (task.isCompleted) "[x]" else "[]"
        println("${index + 1}. ${task.title} $resultIsCompleted")
    }

    print("Введите ID задачи: ")
    val userID = readLine()!!.trim().toIntOrNull()

    if (userID == null || userID < 1 || userID > listTasks.size) {
        println("Ошибка!")
        return
    }


    val index = userID - 1
    val tasks = listTasks[index]

    if (tasks.isCompleted) {
        println("Задача уже выполнена!\n")
        return
    }

    listTasks[index] = Task(tasks.title, true)

    println("Задача: \"${tasks.title}\" отмечена как выполненная!\n")
}


/**
 * Удаляет задачу по ID
 */
fun removeTask(listTasks: MutableList<Task>) {

    if (listTasks.isEmpty()) {
        println("Нету задач!")
        return
    }

    listTasks.forEachIndexed { index, task ->
        val resultIsCompleted = if (task.isCompleted) "[x]" else "[]"
        println("${index + 1}. ${task.title} $resultIsCompleted")
    }

    print("Выберите ID: ")
    val userID = readLine()!!.trim().toIntOrNull()
    if (userID == null || userID < 1 || userID > listTasks.size) {
        println("Ошибка!")
        return
    }

    val index = userID - 1
    listTasks.removeAt(index)
    println("Задача удалена!\n")
}


/**
 * Удаление всех задач
 */
fun clearTasks(listTasks: MutableList<Task>) {
    if (listTasks.isEmpty()) {
        println("У вас нет задач!")
        return
    }

    listTasks.clear()
    println("Задачи удалены!\n")
}