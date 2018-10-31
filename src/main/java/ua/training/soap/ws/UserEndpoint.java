package ua.training.soap.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.training.soap.repository.UserRepository;
import ua.training.soap.server.*;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://tutorialspoint/schemas";
    private UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        User user = userRepository.findById(request.getId());
        GetUserResponse response = new GetUserResponse();
        response.setUser(user);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        long deletedUserId = userRepository.deleteById(request.getId());
        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("User with id " + deletedUserId + " was deleted!");
        return response;
    }
}
