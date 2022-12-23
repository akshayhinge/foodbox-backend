package com.foodbox.mvc.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foodbox.mvc.models.User;
import com.foodbox.mvc.services.Userservices;



@RestController
@RequestMapping("/api/user/")
@CrossOrigin
public class Usercontroller {

	@Autowired
	private Userservices userservices;
	
	@GetMapping("{uname}/{pword}")
	public ResponseEntity<?> login(@PathVariable("uname") Long phoneno,
			@PathVariable("pword") String password){
		List<User> user = userservices.login(phoneno, password);
	if (user!=null) {
		return ResponseEntity.ok(user);
	}
	return new ResponseEntity<String>("something went wrong[check username and password]",HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") Long id){
		User user = userservices.getbyid(id);
		if (user!=null) {
			return ResponseEntity.ok().body(user);
//			return  new ResponseEntity<User>(user,HttpStatus.FOUND);			
		}
		return new ResponseEntity<String>("No user found with this id: "+id,HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public List<User> getallusers(){
		 List<User> allusers = userservices.getallusers();
//		return all
		if (allusers==null) {
		    return null;
		}
		return  allusers;			
//		return null;
	}
	
	@PostMapping("")
	public ResponseEntity<?> adduser( @RequestBody User user) throws IOException {    
		User adduser = userservices.adduser(user);
		if(adduser!=null) {
			return ResponseEntity.ok().body(adduser);			
		}
		return new ResponseEntity<String>("something went wrong[Phone number is already exist]"
										  ,HttpStatus.BAD_GATEWAY);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<String> updatebyid(@PathVariable("id") Long id,
											 @RequestBody User user){
		return ResponseEntity.ok().body(userservices.updatebyid(user, id));
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> updatebyid(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(userservices.deletebyid(id));
	}
	
}
