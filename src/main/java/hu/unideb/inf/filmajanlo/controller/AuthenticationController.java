package hu.unideb.inf.filmajanlo.controller;

import hu.unideb.inf.filmajanlo.service.AuthenticationService;
import hu.unideb.inf.filmajanlo.service.dto.BejelentkezesDto;
import hu.unideb.inf.filmajanlo.service.dto.RegisztracioDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
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
