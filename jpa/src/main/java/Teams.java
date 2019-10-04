import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable=false,length=255)
    private String name;

    public Teams(){
    }

    public Teams(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Author(", ")")
                .add("id=" + id)
                .add("name=" + name)
                .toString();
    }

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
}
