package com.example.sbtechiteasycontroller.controllers;

import com.example.sbtechiteasycontroller.exceptions.IllegalLengthException;
import com.example.sbtechiteasycontroller.models.TV;
import com.example.sbtechiteasycontroller.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tvs")
public class TelevisionController {
    public List<TV> alTVs = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<List<TV>> getAllTvs() {
        return new ResponseEntity<>(this.alTVs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TV> showTv(@PathVariable int id) throws RecordNotFoundException {
        if(isIllegalId(id)){
            throw new RecordNotFoundException("Index does not exist");
        } else {
            return new ResponseEntity<>(this.alTVs.get(id), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<TV> addTv(@RequestBody TV tv) throws IllegalLengthException {
        if(tv.getName().length() > 20) {
            throw new IllegalLengthException("Name is longer than 20 charachters.");
        } else {
            this.alTVs.add(tv);
            return new ResponseEntity<>(tv, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTv(@PathVariable int id)  throws RecordNotFoundException {
        if(isIllegalId(id)){
            throw new RecordNotFoundException("Index does not exist");
        } else {
            this.alTVs.remove(id);
            return new ResponseEntity<>("Deleted tv on position " + id, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTv(@RequestBody TV tv, @PathVariable int id) throws RecordNotFoundException, IllegalLengthException{
        if(isIllegalId(id)) {
            throw new RecordNotFoundException("Index does not exist");
        } else if(tv.getName().length() > 20) {
            throw new IllegalLengthException("Name is longer than 20 chars");
        } else {
            this.alTVs.set(id, tv);
            return new ResponseEntity<>("Added " + this.alTVs.get(id).getName(), HttpStatus.OK);
        }
    }

    private boolean isIllegalId(int id) {
        if(id < 0 ||  id >= this.alTVs.size()){
            return true;
        }
        return false;
    }


}
