package framework.utilities.serverComponents.requestMethods;

public class Endpoints {
    public String getEndpoint(String endpointName) {
        String endpoint = null;
        switch(endpointName) {
            case "getSingleUser":
                endpoint= "/users/2";
                break;
            case "getUsersList":
                endpoint= "/users?page=2";
                break;
            case "createUser":
                endpoint = "/users";
                break;
            case "updateUser":
                endpoint = "/users/2";
                break;
            case "deleteUser":
                endpoint = "/users/2";
                break;
            default:
                System.out.println("Select a valid endpoint");
                break;
        }
        return endpoint;
    }
}
