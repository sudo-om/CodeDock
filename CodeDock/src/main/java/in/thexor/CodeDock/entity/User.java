package in.thexor.CodeDock.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    UUID id;

    @Column(name = "github_id",unique = true,nullable = false)
    Long githubId;

    @Column(name = "github_username",nullable = false,length = 100)
    String githubUsername;

    @Column(name = "display_name",nullable = false,length = 200)
    String displayName;

    @Column(name = "avatar_url",length = 500)
    String avatarUrl;

    @Column(name = "access_token",nullable = false,columnDefinition = "TEXT")
    String accessToken;

    @Column(name = "token_scopes",length = 500)
    String tokenScopes;

    @Column(name = "created_at",nullable = false,updatable = false)
    Instant createdAt;

    @PrePersist
    void onCreate(){
        if(createdAt == null){
            createdAt = Instant.now();
        }
    }
}
