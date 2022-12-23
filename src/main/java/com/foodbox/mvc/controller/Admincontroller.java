package com.foodbox.mvc.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.mvc.models.Admin;
import com.foodbox.mvc.services.Adminservices;

@RestController
@RequestMapping("/api/admin/")
@CrossOrigin
public class Admincontroller {

	@Autowired
	private Adminservices adminservices;

	@GetMapping("{uname}/{pword}")
	public ResponseEntity<?> login(@PathVariable("uname") Long phoneno, @PathVariable("pword") String password) {
		List<Admin> admin = adminservices.login(phoneno, password);
		if (admin != null) {
			return ResponseEntity.ok(admin);
		}
		return new ResponseEntity<String>("something went wrong[check username and password]", HttpStatus.NOT_FOUND);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") Long id) {
		Admin admin = adminservices.getbyid(id);
		if (admin != null) {
			return ResponseEntity.ok(admin);
		}
		return new ResponseEntity<String>("No admin register with this id", HttpStatus.NOT_FOUND);
	}

	@GetMapping("")
	public ResponseEntity<?> getAlladmins() {
		List<Admin> alladmins = adminservices.getalladmins();
		if (!alladmins.isEmpty()) {
			return ResponseEntity.ok(alladmins);
		}
		return new ResponseEntity<String>("No record found", HttpStatus.NOT_FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> addadmin(@RequestBody Admin admin) {
		Admin addadmin = adminservices.addadmin(admin);
		if (addadmin != null) {
			return ResponseEntity.ok(addadmin);
		}
		return new ResponseEntity<String>("something went wrong[All fields are mandatory and username not to be same]",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> updatebyid(@PathVariable("id") Long id, @RequestBody Admin admin) {
		return ResponseEntity.ok(adminservices.updatebyid(admin, id));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletebyid(@PathVariable("id") Long id) {
		return ResponseEntity.ok(adminservices.deletebyid(id));
	}

}
