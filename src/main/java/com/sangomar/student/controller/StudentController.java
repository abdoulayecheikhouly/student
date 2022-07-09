package com.sangomar.student.controller;

import com.sangomar.student.model.Student;
import com.sangomar.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController

@RequestMapping("/api/student")
@RequiredArgsConstructor

public class StudentController {
    private  final StudentService studentService;

    @Operation(summary = "Afficher tous les Etudiants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tous les Etudiants",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Pas de Etudiant trouvé",
                    content = @Content) })
    @GetMapping
    public List<Student> allStudent(){
        return studentService.getAllStudent();
    }


    @Operation(summary = "Afficher un Etudiant par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Etudiant trouvé",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Pas d'Etudiant trouvé",
                    content = @Content) })
    @GetMapping("/{id}")
    public Optional<Student> getProduct(@PathVariable("id") Integer id){
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
    }

    @Operation(summary = "créer un Etudiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Etudiant créé avec succés",
                    content = { @Content(mediaType = "application/json;charset=UTF-8",
                            schema = @Schema(implementation = Student.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Etudiant non créé",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Etudiant non créé, une erreur est survenue",
                    content = @Content) })

    @PostMapping
    public Student addProduct(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("{id}")
     public ResponseEntity<?>updateStudent(@PathVariable Integer id, @RequestBody Student student) {

        try {
            Optional<Student> existStudent = studentService.getStudent(id);
            student.setId(id);
            studentService.addStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}