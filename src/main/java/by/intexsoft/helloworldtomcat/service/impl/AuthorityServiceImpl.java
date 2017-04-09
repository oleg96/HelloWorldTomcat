package by.intexsoft.helloworldtomcat.service.impl;

import by.intexsoft.helloworldtomcat.model.Authority;
import by.intexsoft.helloworldtomcat.repository.AuthorityRepository;
import by.intexsoft.helloworldtomcat.repository.UserRepository;
import by.intexsoft.helloworldtomcat.service.AuthorityService;
import by.intexsoft.helloworldtomcat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link UserService} interface
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository roleRepository;

    @Override
    public Authority add(Authority authority) {
        return roleRepository.save(authority);
    }

    @Override
    public Authority findById(int id) {
        return roleRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        roleRepository.delete(id);
    }

    @Override
    public Authority findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Authority edit(Authority authority) {
        return roleRepository.saveAndFlush(authority);
    }

    @Override
    public List<Authority> findAll() {
        return roleRepository.findAll();
    }
}
