package ua.training.soap.repository;

import org.springframework.stereotype.Repository;
import ua.training.soap.server.Project;
import ua.training.soap.server.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final List<User> users = new ArrayList<>();

    @PostConstruct
    private void initData() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alex");
        user1.setSurname("Lytvyn");
        Project project1 = new Project();
        project1.setId(1L);
        project1.setTitle("Project 1");
        user1.setProject(project1);

        users.add(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Vlad");
        user2.setSurname("Rubkin");
        Project project2 = new Project();
        project2.setId(2L);
        project2.setTitle("Project 2");
        user2.setProject(project2);

        users.add(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Yaroslav");
        user3.setSurname("Storozhuk");
        Project project3 = new Project();
        project3.setId(3L);
        project3.setTitle("Project 3");
        user3.setProject(project3);

        users.add(user3);

    }

    @Override
    public User findById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public long deleteById(long id) {
        users.removeIf(user -> user.getId() == id);
        return id;
    }
}
