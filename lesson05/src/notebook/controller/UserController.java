package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) throws Exception {
        return repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    public List<User> readAll() {
        return repository.findAll();
    }

    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }

    // Метод для создания нового пользователя
    public User createUser(String firstName, String lastName, String phone) {
        return new User(firstName, lastName, phone);
    }

    public boolean deleteUser(Long id) {
        return repository.delete(id);
    }
}
