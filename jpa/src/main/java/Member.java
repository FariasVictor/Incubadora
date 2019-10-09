    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import javax.persistence.*;
    import java.time.LocalDateTime;
    import java.util.StringJoiner;

    @Entity
    @Table(name = "member")
    public class Member {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "name", length = 255, nullable = false)
        private String name;

        @ManyToOne(fetch = FetchType.LAZY)//, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
        @JoinColumn(name = "team_id", nullable = false)
        private Team team;

        @CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private LocalDateTime createdAt;

        @UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private LocalDateTime updatedAt;


        public Member() {
        }

        public Member(String name, Team team) {
            this.name = name;
            this.team = team;
        }

//        @PrePersist
//        public void prePersist() {
//            this.createdAt = LocalDateTime.now();
//            this.updatedAt = this.createdAt;
//        }
//
//        @PreUpdate
//        public void preUpdate() {
//            this.updatedAt = LocalDateTime.now();
//        }

        @Override
        public String toString() {
            return new StringJoiner(", ", "Member(", ")")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .add("team=" + team)
                    .add("createdAt=" + createdAt)
                    .add("updatedAt=" + updatedAt)
                    .toString();
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
