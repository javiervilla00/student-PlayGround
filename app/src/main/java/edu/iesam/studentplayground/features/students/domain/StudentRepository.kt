package edu.iesam.studentplayground.features.students.domain

interface StudentRepository {
    fun save(student: Student)
    fun findAll(): List<Student>
    fun delete(exp: String)
    fun update(student: Student)
}