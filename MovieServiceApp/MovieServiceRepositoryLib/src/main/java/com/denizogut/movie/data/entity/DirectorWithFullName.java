package com.denizogut.movie.data.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class DirectorWithFullName {

    public long directorId;
    public String fullName;
    public LocalDate birthDate;

    public DirectorWithFullName(long directorId, String fullName, LocalDate birthDate)
    {
        this.directorId = directorId;
        this.fullName = fullName;
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

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorWithFullName that = (DirectorWithFullName) o;
        return directorId == that.directorId && Objects.equals(fullName, that.fullName) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(directorId, fullName, birthDate);
    }
}
