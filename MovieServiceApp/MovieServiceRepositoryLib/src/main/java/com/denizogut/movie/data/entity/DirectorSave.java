package com.denizogut.movie.data.entity;

import java.time.LocalDate;


public class DirectorSave {
    public long directorId;
    public String firstName;
    public String middleName;
    public String familyName;
    public LocalDate birthDate;

    public DirectorSave(long directorId, String firstName, String middleName, String familyName, LocalDate birthDate)
    {
        this.directorId = directorId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.familyName = familyName;
        this.birthDate = birthDate;
    }

    public long getDirectorId()
    {
        return directorId;
    }

    public void setDirectorId(long directorId)
    {
        this.directorId = directorId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }
}
