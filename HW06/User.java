//I worked on the homework assignment alone, using only course materials.
/**
 * This class represents the secure User backend
 * @author Shaotong Sun
 * @version 6.0.1
 */
public class User {
    private String username;
    private int password;
    private static int numUsers;
    private static User newestUser;
    private static boolean displayNewest = true;
    /**
     * Creates a new User
     * @param  username user name
     * @param  password password
     */
    public User(String username, int password) {
        this.username = username;
        this.password = password;
        numUsers++;
        newestUser = this;
    }
    /**
     * method to reset the Newest user information display command
     * @param displayNewest command to display
     */
    public static void setDisplayNewest(boolean displayNewest) {
        User.displayNewest = displayNewest;
    }
    /**
     * method to get the number of the users
     * @return the number of users
     */
    public static int getNumUsers() {
        return numUsers;
    }
    /**
     * method to get the name of the user
     * @return the name of the user
     */
    public String getUsername() {
        return username;
    }
    /**
     * method to get the Welcome message
     * @return Welcome message
     */
    public static String getWelcomeMessage() {
        String message = null;
        if (numUsers == 0) {
            message = "This site doesn't have any users yet!";
        } else if (displayNewest) {
            message = newestUser.getUsername() + " just joined our site! Please give them a warm welcome!";
        } else {
            message = "Welcome to our site! We have " + numUsers + " user(s) and counting!";
        }
        return message;
    }
    /**
     * method to change the password
     * @param usernameInput username of the current User
     * @param passwordInput password of the current User
     * @param newPassword   the new password
     */
    public void changePassword(String usernameInput, int passwordInput, int newPassword) {
        if (usernameInput == username && passwordInput == password) {
            password = newPassword;
        }
    }
    /**
     * method to know the user is valid
     * @param  usernameInput username of the current User
     * @param  passwordInput password of the current User
     * @return               the vaild information
     */
    public boolean validLogin(String usernameInput, int passwordInput) {
        return usernameInput == username && passwordInput == password;
    }

}
