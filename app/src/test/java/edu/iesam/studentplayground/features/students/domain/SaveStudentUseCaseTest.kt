package edu.iesam.studentplayground.features.students.domain
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class SaveStudentUseCaseTest {

    /*
     *When ..... Then .....
     */

    @Test
    fun `when invoke then save student` (){
        //Given
        val studentRepositoryMock = mockk<StudentRepository>(relaxed = true)
        val saveStudentUseCase = SaveStudentUseCase(studentRepositoryMock)
        val student = Student("0001", "nombre1")

        //When
        saveStudentUseCase.invoke(student)

        //Then
        verify(exactly = 1) { studentRepositoryMock.save(student = student) }
    }

}