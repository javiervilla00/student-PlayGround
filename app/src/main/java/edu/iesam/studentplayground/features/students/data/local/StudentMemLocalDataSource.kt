package org.example.edu.iesam.students.data.local

import edu.iesam.studentplayground.features.students.domain.Student

class StudentMemLocalDataSource {
    private val dataSource: MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student){
        dataSource.put(student.exp, student)
    }

    fun findAll(): List<Student> {
        return dataSource.map{ student ->
            student.value
        }
    }

    fun delete(exp: String){
        dataSource.remove(exp)
    }

    fun update(student: Student){
        if (dataSource.containsKey(student.exp)){
            dataSource[student.exp] = student
        }
    }
}