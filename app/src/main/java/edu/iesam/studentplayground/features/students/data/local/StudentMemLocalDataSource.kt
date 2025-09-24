package org.example.edu.iesam.students.data.local

import edu.iesam.studentplayground.features.students.domain.Student

class StudentMemLocalDataSource {
    private val dataSource: MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student){
        dataSource.put(student.exp, student)
    }

    fun get(): List<Student> {
        return dataSource.values.toList()
    }

    fun delete(exp: String){
        dataSource.remove(exp)
    }
}