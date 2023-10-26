package com.simplon.dvdstore.controllers.auth;

import com.simplon.dvdstore.exceptions.AccountExistsException;
import com.simplon.dvdstore.exceptions.UnauthorizedException;
import com.simplon.dvdstore.services.client.ClientServiceModel;
import com.simplon.dvdstore.services.jwt.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin
public class SecurityController {
    @Autowired
    private JwtUserService userService;

    //Remarque : ajouter un nouvel utilisateur et génère un JWT à la volée
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody AuthRequestDto dto) throws AccountExistsException {
        UserDetails user = userService.save(dto.getUsername(),
                dto.getPassword());
        String token = userService.generateJwtForUser(user);
        return ResponseEntity.ok(new AuthResponseDto(user,token));
    }

    @PostMapping("/authorize")
    public ResponseEntity<AuthResponseDto> authorize(@RequestBody AuthRequestDto requestDto) throws UnauthorizedException {
        Authentication authentication = null;
        try {
            System.out.println(requestDto);
            authentication = userService.authenticate(requestDto.getUsername(),
                      requestDto.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        // Token generation
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(user);
            return ResponseEntity.ok(new AuthResponseDto(user, token));
        } catch(AuthenticationException e) {
            throw new UnauthorizedException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<ClientServiceModel> findByName(@PathVariable String name){
//        try{
//            ClientServiceModel clientServiceModel =  clientService.findById(id);
////            return new ResponseEntity<>(new ClientGetDTO(clientServiceModel.getId().get(), clientServiceModel.getName(),clientServiceModel.getFirstname(),clientServiceModel.getEmail(),clientServiceModel.getAdresse()), HttpStatus.OK) ; // *** mappage à revoir
//            return new ResponseEntity<>(clientServiceModel, HttpStatus.OK) ;
//        }catch(DvdNotFoundException ex){
//
//            System.out.println(ex.getReason());
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, ex.getReason() );
//        }
        return new ResponseEntity<>(new ClientServiceModel(), HttpStatus.OK) ;
    }
    //Remarque: authentifie le principal (le user) à partir du JWT.
}

