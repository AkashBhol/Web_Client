package com.example.ServiceImpl;

import com.example.DTO.ContryDTO;
import com.example.DTO.UserDTO;
import com.example.Repositorry.UserRepository;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebClient webClient;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        ResponseEntity<?> country = getCountry();
//        userDTO.setUserName(country.getBody().getClass().getName());
        Object body = country.getBody();
        List<ContryDTO> contryDTOList;
        if (body instanceof List<?>) {
            contryDTOList = ((List<?>) body).stream()
                    .filter(ContryDTO.class::isInstance)
                    .map(ContryDTO.class::cast)
                    .collect(Collectors.toList());
        } else {
            // Handle the case where the type is not List<ContryDTO>
            contryDTOList = new ArrayList<>();
        }

        List<String> countryNames = contryDTOList.stream()
                .map(ContryDTO::getName)
                .collect(Collectors.toList());
        userDTO.setCountryName(countryNames.get(0));
        UserDTO save = userRepository.save(userDTO);
        return save;
    }

    @Override
    public List<UserDTO> getALlUserDto() {
        return null;
    }

    public ResponseEntity<?> getCountry() {
        ResponseEntity<?> responseEntity = webClient.get()
                .uri("http://localhost:8089/api/v2/get")
                .retrieve()
//                .toEntity(Object.class)
                .toEntity(new ParameterizedTypeReference<List<ContryDTO>>() {})
                .block();
        return responseEntity;
    }
}
