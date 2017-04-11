package by.intexsoft.picturegallery.service.impl;

import by.intexsoft.picturegallery.model.Authority;
import by.intexsoft.picturegallery.repository.AuthorityRepository;
import by.intexsoft.picturegallery.service.AuthorityService;
import by.intexsoft.picturegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
