package com.weaverprojects.opentinder.Model;

/**
 * Created by keithweaver on 16-01-08.
 */
public class BasicProfile {
    String profileId;
    String firstName;
    String lastName;
    String imageURL;
    int age;

    public BasicProfile(String profileId, String firstName, String lastName, String imageURL, int age) {
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageURL = imageURL;
        this.age = age;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getAge() {
        return age;
    }
}
