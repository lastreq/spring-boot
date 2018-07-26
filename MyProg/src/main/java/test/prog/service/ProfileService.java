package test.prog.service;

import test.prog.model.Profile;

public interface ProfileService {

    /*Profile findById(int id);*/
    Profile getProfile(int id);

    void createProfile(String firstName, String lastName, String address, int age, String email, String country);
    void createProfile(Profile profile);


    void deleteProfile(int id);
}