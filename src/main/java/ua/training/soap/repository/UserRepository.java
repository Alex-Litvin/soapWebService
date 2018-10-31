package ua.training.soap.repository;

import ua.training.soap.server.User;

public interface UserRepository {
    User findById(long id);
    long deleteById(long id);
}
