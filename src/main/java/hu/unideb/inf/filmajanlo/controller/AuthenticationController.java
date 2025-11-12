package hu.unideb.inf.filmajanlo.controller;

import hu.unideb.inf.filmajanlo.service.AuthenticationService;
import hu.unideb.inf.filmajanlo.service.dto.BejelentkezesDto;
import hu.unideb.inf.filmajanlo.service.dto.RegisztracioDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/regisztracio")
    public void regisztracio(@RequestBody RegisztracioDto dto){
        authService.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto dto){
        return authService.bejelentkezes(dto);
    }
}
