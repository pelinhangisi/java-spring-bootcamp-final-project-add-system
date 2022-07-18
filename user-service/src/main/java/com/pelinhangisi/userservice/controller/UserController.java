package com.pelinhangisi.userservice.controller;


import com.pelinhangisi.userservice.dto.UserRequest;
import com.pelinhangisi.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/create")
    public void save(@RequestBody UserRequest userRequest){
        userService.save(userRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequest> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping("/update")
    public ResponseEntity<UserRequest> update(@PathVariable("id") String id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.update(id, userRequest));
    }

    @DeleteMapping("/delete")
    public void delete(String id) {
        userService.delete(id);
    }


    @GetMapping("/getlist")
    public ResponseEntity<Slice<UserRequest>> getAll(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }



}
