package com.softwareComedians.ClinicalCenterApp.service.impl;

import com.softwareComedians.ClinicalCenterApp.common.TimeProvider;
import com.softwareComedians.ClinicalCenterApp.common.UserHelper;
import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.RequestForPatientRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.exception.ResourceNotFoundException;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.repository.ConfirmationTokenRepository;
import com.softwareComedians.ClinicalCenterApp.repository.RequestForPatientRegistrationRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import com.softwareComedians.ClinicalCenterApp.service.email.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TimeProvider timeProvider;

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private MailSenderService mailSenderService;

    //@Value("${user.default-profile-image}")
    //private String defaultProfileImage;


    @Override
    public User findById(Long id) {
        try {
            User user = userRepository.findById(id).get();
            return user;
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("User with ID " + id + " doesn't exist");
        }
    }

    @Override
    public User findByUsername(String username) throws ApiRequestException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new ApiRequestException("User with username '" + username + "' doesn't exist.");

        return user;
    }

    @Override
    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }

    @Override
    public User addRegularUser(UserRegistrationDTO userInfo) {
        User user = this.createNewUserObject(userInfo, UserRoles.ROLE_USER);
        userRepository.save(user);

        ConfirmationToken token = this.createConfirmationToken(user);
        mailSenderService.sendMailForRegistration(user, token);

        return user;
    }

    @Override
    public User addAdminUser(UserRegistrationDTO userInfo) {
        User user = this.createNewUserObject(userInfo, UserRoles.ROLE_ADMIN);
        userRepository.save(user);

        ConfirmationToken token = this.createConfirmationToken(user);
        mailSenderService.sendMailForRegistration(user, token);

        return user;
    }

    private ConfirmationToken createConfirmationToken(User user) {
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        return confirmationTokenRepository.save(confirmationToken);
    }

    private User createNewUserObject(UserRegistrationDTO userInfo, String roleName) throws ApiRequestException {
        if (userRepository.findByUsername(userInfo.getUsername()) != null)
            throw new ApiRequestException("Username '" + userInfo.getUsername() + "' is taken.");

        User user = new User();
        user.setUsername(userInfo.getUsername());
        user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        user.setName(userInfo.getName());
        user.setSurname(userInfo.getSurname());
        user.setEmail(userInfo.getEmail());
        user.setEnabled(false);
        user.setAddress(userInfo.getAddress());
        user.setCity(userInfo.getCity());
        user.setCountry(userInfo.getCountry());
        user.setPhone(userInfo.getPhone());
        user.setUcidn(userInfo.getUcidn());
        user.setRole(userInfo.getRole());
        //user.setLastPasswordResetDate(timeProvider.nowTimestamp());
        //user.setProfileImagePath(defaultProfileImage);

        Authority regularUserAuthority = authorityRepository.findByName(roleName);
        user.getUsersAuthorities().add(regularUserAuthority);

        return user;
    }

    @Override
    public void verifyUserAccount(String token) {
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByToken(token);

        if (confirmationToken == null) {
            throw new ResourceNotFoundException("Requested token doesn't exist.");
        }

        User user = confirmationToken.getUser();
        Date now = timeProvider.now();
        long timeDifference = now.getTime() - confirmationToken.getCreatedDatetime().getTime();
        long timeDifferenceMinutes = timeDifference / (60 * 1000);

        if (timeDifferenceMinutes < 15) {
            user.setEnabled(true);
            userRepository.save(user);
        } else {
            confirmationTokenRepository.delete(confirmationToken);
            userRepository.delete(user);
            throw new ApiRequestException("Confirmation token timed out.");
        }


    }

    @Override
    public void changeUserEnabledStatus(Long id, boolean status) {
        User user = this.findById(id);
        user.setEnabled(status);
        userRepository.save(user);
    }

    @Override
    public User editUser(UserDTO user) {
        User userInfo = userHelper.getCurrentUser();

        userInfo.setName(user.getName());
        userInfo.setSurname(user.getSurname());
        userInfo.setEmail(user.getEmail());

        return userInfo;
    }
/*
    @Override
    public void setProfileImage(String imagePath) {
        User user = userHelper.getCurrentUser();
        //user.setProfileImagePath(imagePath);
        userRepository.save(user);
    }*/
}
