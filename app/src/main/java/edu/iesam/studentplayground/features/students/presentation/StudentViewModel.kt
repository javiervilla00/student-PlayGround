package edu.iesam.studentplayground.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.studentplayground.features.students.domain.GetStudentsUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student

class StudentViewModel (private val saveStudentUseCase: SaveStudentUseCase, private val getStudentsUseCase: GetStudentsUseCase) : ViewModel(){

    fun saveClicked(exp: String, name:String){
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun loadStudents(): List<Student> {
        return getStudentsUseCase()
    }

}