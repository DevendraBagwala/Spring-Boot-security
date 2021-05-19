package com.divergentsl.security.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.security.entity.Student;
import com.divergentsl.security.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping(path = "/student", produces = "application/json")
@CrossOrigin(origins = "*")

public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	private ResponseEntity<List<Student>> getAll() {
	//	log.debug("get all employees");
		List<Student> student = studentService.findAllStudent();

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int id) {
		studentService.removeStudent(id);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Student> find(@PathVariable int id) {
		Student student = studentService.findStudent(id);

		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Student student) {
		studentService.updateStudent(student);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Student student) {
		studentService.insertStudent(student);
	}
}
