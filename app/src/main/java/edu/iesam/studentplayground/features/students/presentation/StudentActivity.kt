package edu.iesam.studentplayground.features.students.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.studentplayground.R
import edu.iesam.studentplayground.features.students.domain.DeleteStudentUseCase
import edu.iesam.studentplayground.features.students.domain.GetStudentsUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import org.example.edu.iesam.students.data.StudentDataRepository
import org.example.edu.iesam.students.data.local.StudentMemLocalDataSource
import org.example.edu.iesam.students.data.local.StudentXmlLocalDataSource
import org.example.edu.iesam.students.data.remote.StudentApiRemoteDataSource

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initStudents()
    }

    fun initStudents(){
        val xml = StudentXmlLocalDataSource()
        val mem = StudentMemLocalDataSource()
        val api = StudentApiRemoteDataSource()
        val dataRepository = StudentDataRepository(xml, mem, api)
        val useCase = SaveStudentUseCase(dataRepository)
        val getUseCase = GetStudentsUseCase(dataRepository)
        val deleteUseCase = DeleteStudentUseCase(dataRepository)

        val viewModel = StudentViewModel(useCase, getUseCase, deleteUseCase)
        /* Otra manera:
        val viewModel = StudentViewModel(
            SaveStudentUseCase(
                StudentDataRepository(
                    StudentXmlLocalDataSource(),
                    StudentMemLocalDataSource(),
                    StudentApiRemoteDataSource()
                ))
        )*/

        viewModel.saveClicked("0001", "nombre1 apellido1 apellido1")
        viewModel.saveClicked("0002", "nombre2 apellido2 apellido2")
        viewModel.loadStudents()
        val allStudents = viewModel.loadStudents()
        Log.d("@dev", "Lista de alumnos: $allStudents")
        viewModel.deleteStudents("0001")
        Log.d("@dev", "Lista tras delete: $allStudents")
    }
}