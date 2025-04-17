package com.kriNad.backend.service;

import com.kriNad.backend.DTO.LoginRequest;
import com.kriNad.backend.DTO.RegisterRequest;
import com.kriNad.backend.model.personne.Customer;
import com.kriNad.backend.model.personne.Personne;
import com.kriNad.backend.repositories.AdminRepository;
import com.kriNad.backend.repositories.AgentRepository;
import com.kriNad.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired private AgentRepository agentRepo;
    @Autowired private AdminRepository adminRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerCustomer(RegisterRequest request) {
        if (emailExists(request.getEmail())) {
            return "Email already exists";
        }

        Customer customer = new Customer();
        customer.setFname(request.getFname());
        customer.setLname(request.getLname());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setAgentAcces(false);
        customer.setAdminAcces(false);

        customerRepo.save(customer);
        return "success";
    }

    public String login(LoginRequest request) {
        Optional<? extends Personne> user =
                adminRepo.findByEmail(request.getEmail())
                        .map(u -> (Personne) u)
                        .or(() -> agentRepo.findByEmail(request.getEmail()))
                        .or(() -> customerRepo.findByEmail(request.getEmail()));

        if (user.isEmpty()) {
            return "Email does not exist";
        }

        Personne p = user.get();
        if (!passwordEncoder.matches(request.getPassword(), p.getPassword())) {
            return "Invalid credentials";
        }

        if (Boolean.TRUE.equals(p.getAdminAcces())) return "admin";
        if (Boolean.TRUE.equals(p.getAgentAcces())) return "agent";
        return "customer";
    }

    private boolean emailExists(String email) {
        return adminRepo.findByEmail(email).isPresent()
                || agentRepo.findByEmail(email).isPresent()
                || customerRepo.findByEmail(email).isPresent();
    }
}

