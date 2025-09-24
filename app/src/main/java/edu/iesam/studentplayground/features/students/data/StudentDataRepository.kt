package org.example.edu.iesam.students.data

import org.example.edu.iesam.students.data.local.StudentMemLocalDataSource
import org.example.edu.iesam.students.data.local.StudentXmlLocalDataSource
import org.example.edu.iesam.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.StudentRepository

class StudentDataRepository(
    private val xmlLocalDataSource: StudentXmlLocalDataSource,
    private val memLocalDataSource: StudentMemLocalDataSource,
    private val apiRemoteDataSource: StudentApiRemoteDataSource
) : StudentRepository {
    // Guardar estudiante
    override fun save(student: Student) {
        memLocalDataSource.save(student)
    }
    // Devolver estudiantes
    override fun get(): List<Student> {
        return memLocalDataSource.get()
    }
    //Eliminar estudiante
    override fun delete(exp: String) {
        memLocalDataSource.delete(exp)
    }
    //Actualizar estudiante
    override fun update(student: Student) {
        memLocalDataSource.update(student)
    }
}