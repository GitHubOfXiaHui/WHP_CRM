package com.wondersgroup.framework.repository.jpa.sys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wondersgroup.framework.entity.sys.CodeNotes;

/**
 * Code生成辅助实体的CRUD泛型操作类
 * @author zpfox
 *
 */
public interface CodeNotesDao extends JpaRepository<CodeNotes, Long> {

    CodeNotes findByPrefix(String prefix);
}
