package UrlsAndUris;

import javax.swing.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class AuthDemo {

    public static void main(String[] args) {
        // Set the custom authenticator
        Authenticator.setDefault(new MyAuthenticator());

        // Attempt to access the protected resource
        // This would usually involve some network operation requiring authentication
        boolean accessGranted = simulateResourceAccess();

        if (accessGranted) {
            System.out.println("Access granted to the protected resource.");
        } else {
            System.out.println("Access denied. Invalid credentials.");
        }
    }

    // Custom Authenticator that prompts the user for username and password
    private static class MyAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            // Prompt user for credentials
            JTextField usernameField = new JTextField();
            JPasswordField passwordField = new JPasswordField();
            Object[] message = {
                    "Username:", usernameField,
                    "Password:", passwordField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Enter your credentials", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                return new PasswordAuthentication(username, password);
            } else {
                return null; // User canceled the dialog
            }
        }
    }

    // Simulate resource access (for demonstration purposes)
    private static boolean simulateResourceAccess() {
        // Dummy credentials for demonstration purposes
        final String requiredUsername = "admin";
        final String requiredPassword = "secret";

        PasswordAuthentication credentials = Authenticator.requestPasswordAuthentication(
                null, null, 0, null, null, null);

        if (credentials != null) {
            String providedUsername = credentials.getUserName();
            String providedPassword = new String(credentials.getPassword());

            return requiredUsername.equals(providedUsername) && requiredPassword.equals(providedPassword);
        }
        return false;
    }
}