package id.ac.ui.cs.advprog.bidmart.auth.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_sessions")
public class UserSession {
    @Id
    private String id; // The Refresh Token ID or JTI

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String deviceFingerprint; // To identify unique devices 
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    
    private boolean isRevoked = false; // 
}
