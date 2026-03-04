package id.ac.ui.cs.advprog.bidmart.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.ac.ui.cs.advprog.bidmart.auth.entity.UserSession;

import java.util.List;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, String> {

    // Get all active sessions to check against the concurrent limit 
    List<UserSession> findByUserIdAndIsRevokedFalseOrderByCreatedAtAsc(Long userId);

    // Count active sessions for a specific user 
    long countByUserIdAndIsRevokedFalse(Long userId);

    // Invalidate all sessions when an admin deactivates an account 
    @Modifying
    @Transactional
    @Query("UPDATE UserSession s SET s.isRevoked = true WHERE s.user.id = :userId")
    void revokeAllSessionsByUserId(Long userId);
}