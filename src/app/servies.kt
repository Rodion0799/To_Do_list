package app

/**
 * Добавляет новую задачу в список
 */
fun addTask(listTasks: MutableListTask) {
    print("Введите заголовок задачи: ")
    val userHeading = readLine()!!.trim()
    if (userHeading.isBlank()) {
        println(ERROR)
        return
    }

    print("Введите название задачи: ")
    val userTitle = readLine()!!.trim()
    if (userTitle.isBlank()) {
        println(ERROR)
        return
    }

    listTasks.add(Task(userHeading,userTitle, false))
    println("Задача добавлена!\n")
}

/**
 * Выводит список задач с индексами и статусами
 */
fun tasks(listTasks: MutableListTask) {
    if (listTasks.isEmpty()) {
        println("У вас нет задач!")
    }

    listTasks.forEachIndexed { index, task ->
        val resultIsCompleted = if (task.isCompleted) "[x]" else "[]"
        println("${index + 1}. ${task.heading}\n${task.title} $resultIsCompleted\n")
    }
    println()
}

/**
 * Поиск по заголовку
 */
fun searchTasks(listTasks: MutableListTask) {
    if (listTasks.isEmpty()) {
        println(ERROR)
        return
    }

    print("Введите заголовок задачи: ")
    val userHeading = readLine()!!.trim()
    if (userHeading.isBlank()) {
        println(ERROR)
        return
    }

    val searchTasks = listTasks.filter { userHeading == it.heading }

    if (searchTasks.isEmpty()) {
        println("Не найдено!")
        return
    }

    searchTasks.forEachIndexed { index, task ->
        val resultIsCompleted = if (task.isCompleted) "[x]" else "[]"
        println("${index + 1}. ${task.heading}\n${task.title} $resultIsCompleted\n")
    }
    println()
}


/**
 * Отмечает выбранную задачу как выполненную
 */
fun markAsDone(listTasks: MutableListTask) {

    if (listTasks.isEmpty()) {
        println("У вас нет задач!")
        return
    }

    listTasks.forEachIndexed { index, task ->
        val resultIsCompleted = if (task.isCompleted) "[x]" else "[]"
        println("${index + 1}. ${task.heading}\n${task.title} $resultIsCompleted\n")
    }

    print("Введите ID задачи: ")
    val userID = readLine()!!.trim().toIntOrNull()

    if (userID == null || userID < 1 || userID > listTasks.size) {
        println(ERROR)
        return
    }


    val index = userID - 1
    val tasks = listTasks[index]

    if (tasks.isCompleted) {
        println("Задача уже выполнена!\n")
        return
    }

    listTasks[index] = Task(tasks.heading, tasks.title, true)

    println("Задача: \"${tasks.title}\" отмечена как выполненная!\n")
}


/**
 * Удаляет задачу по ID
 */
fun removeTask(listTasks: MutableListTask) {

    if (listTasks.isEmpty()) {
        println("Нету задач!")
        return
    }

    listTasks.forEachIndexed { index, task ->
        val resultIsCompleted = if (task.isCompleted) "[x]" else "[]"
        println("${index + 1}. ${task.heading}\n${task.title} $resultIsCompleted\n")
    }

    print("Выберите ID: ")
    val userID = readLine()!!.trim().toIntOrNull()
    if (userID == null || userID < 1 || userID > listTasks.size) {
        println(ERROR)
        return
    }

    val index = userID - 1
    listTasks.removeAt(index)
    println("Задача удалена!\n")
}


/**
 * Удаление всех задач
 */
fun clearTasks(listTasks: MutableListTask) {
    if (listTasks.isEmpty()) {
        println("У вас нет задач!")
        return
    }

    listTasks.clear()
    println("Задачи удалены!\n")
}