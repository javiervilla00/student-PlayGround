package edu.iesam.studentplayground.features.students.domain

interface StudentRepository {
    fun save(student: Student)
    fun get(): List<Student>
}