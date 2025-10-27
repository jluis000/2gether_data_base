/*package com.twogether.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.twogether.app.model.UserSkill;
import com.twogether.app.model.UserSkillId;


public interface UserSkillRepository  extends JpaRepository<UserSkill, UserSkillId>  {
    
    // 🔹 Todas las habilidades de un usuario
    List<UserSkill> findByUser_UserId(Long userId);

    // 🔹 Todos los usuarios que tengan una habilidad específica
    List<UserSkill> findBySkill_SkillsId(Long skillId);
}
*/