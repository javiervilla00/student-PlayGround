package edu.iesam.studentplayground.features.students.domain

class GetStudentsUseCase (val studentRepository: StudentRepository){

    operator fun invoke() : List<Student> {
        return studentRepository.get()
    }
}