package blog.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This is an entity for the user..
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique =true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Column(length = 60)
    private String password_hash;

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    @Column(length = 100)
    private String fullName;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    public User(){}
    public User(Long id, String name, String fullName) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", posts=" + posts +

                '}';
    }
}
