package ru.itmo.wp.domain;

public abstract class AbstractUser implements InterfaceUser {
    public abstract long getId();

    public abstract void setId(long userId);
}
