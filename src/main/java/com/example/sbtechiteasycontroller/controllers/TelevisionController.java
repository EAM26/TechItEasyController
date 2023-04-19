package com.example.sbtechiteasycontroller.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/all-tvs")
    public ResponseEntity<String> getAllTvs() {
        return ResponseEntity.ok("all televisions");
    }

    @GetMapping("/tv/{id}")
    public ResponseEntity<String> showTv() {
        return ResponseEntity.ok("single tv");
    }

    @PostMapping("/addTv")
    public ResponseEntity<String> addTv(@RequestParam String tv) {
        return ResponseEntity.created(null).body(tv + " television added");
    }

    @PutMapping("/replace")
    public ResponseEntity<String> replaceTv(@RequestParam String tv) {
        return ResponseEntity.created(null).body(tv + " television replaced or updated");
    }

}
