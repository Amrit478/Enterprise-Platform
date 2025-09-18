import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * This class represents a user's login credentials and maps to a database table.
 */
@Entity
@Table(name = "logins") // Using a plural, lowercase name is a common convention
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Username cannot be null")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 12, message = "Password must be at least 12 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{12,}$", message = "Password must contain a mix of letters and numbers")
    @Column(name = "password_hash", nullable = false) // Storing the hash, not the password
    private String password;

    // A no-argument constructor is required by JPA
    public Login() {
    }

    // Constructor for creating new users (ID is generated automatically)
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }
    // No setter for ID, as it's the database's responsibility

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

/*This is what will use in service layer when i am securing the password in the hash
 * 
 * // This is a simplified example
// In a real app, passwordEncoder would be a managed bean (@Bean)
PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

String rawPassword = "Password12345";
String hashedPassword = passwordEncoder.encode(rawPassword);

// Now, save the user with the HASHED password
Login newUser = new Login("someuser", hashedPassword);
loginRepository.save(newUser);
 */