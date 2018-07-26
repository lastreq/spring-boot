package test.prog.dao;

import test.prog.model.Profile;
import test.prog.model.ProfileInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProfileDao {
    /* List<ProfileInfo> listProfileInfo();*/
    /*public Profile findById(int id);*/
    Optional<Profile> getProfileById(int id);

    void insertProfile(String firstName, String secondName, String address, int age, String email, String country);

    void deleteProfileById(int id);

}