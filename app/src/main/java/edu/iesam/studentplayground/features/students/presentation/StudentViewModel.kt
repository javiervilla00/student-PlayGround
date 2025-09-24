package edu.iesam.studentplayground.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.studentplayground.features.students.domain.DeleteStudentUseCase
import edu.iesam.studentplayground.features.students.domain.GetStudentsUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.UpdateStudentUseCase

class StudentViewModel (private val saveStudentUseCase: SaveStudentUseCase, private val getStudentsUseCase: GetStudentsUseCase, private val deleteStudentUseCase: DeleteStudentUseCase, private val updateStudentUseCase: UpdateStudentUseCase) : ViewModel(){

    fun saveClicked(exp: String, name:String){
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun loadStudents(): List<Student> {
        return getStudentsUseCase()
    }

    fun deleteStudents(exp: String){
        deleteStudentUseCase(exp)
    }

    fun updateStudent(exp: String, name: String){
        updateStudentUseCase(Student(exp, name))
    }
}