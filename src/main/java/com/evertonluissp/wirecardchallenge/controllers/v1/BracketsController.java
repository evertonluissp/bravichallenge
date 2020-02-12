package com.evertonluissp.wirecardchallenge.controllers.v1;

import com.evertonluissp.wirecardchallenge.services.BracketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("v1/brackets")
public class BracketsController {

    public final BracketsService service;

    public BracketsController(BracketsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> isValid(@RequestParam String input) {
        return service.isBalancedBrackets(input) ? ok().build() : noContent().build();
    }

}
