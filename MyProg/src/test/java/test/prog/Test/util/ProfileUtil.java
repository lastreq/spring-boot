package test.prog.Test.util;

import test.prog.model.Profile;

public class ProfileUtil {



    public static Profile createProfile() {
        Profile profile = new Profile();
        profile.setFirstName("Евгений");
        profile.setLastName("Комаров");
        profile.setAddress("Кирова 15");
        profile.setAge(11);
        profile.setEmail("test@gmail.com");
        profile.setCountry("Россия");

        return profile;
    }

}