package edu.iesam.studentplayground.features.students.domain

/**
 * Importante: por constructor la interfaz (abstracción)
 */
class GetStudentsUseCase (private val studentRepository: StudentRepository){

//    operator fun invoke() : List<Student> {
//        return studentRepository.findAll()
//    }

    /**
     * El igual reemplaza al return
     */
    operator fun invoke() = studentRepository.findAll()

}