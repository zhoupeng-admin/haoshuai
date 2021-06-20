package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Section;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SectionMapper {
    Section sectionInfoByNo(Section section);
    Section sectionInfo(Section section);
    Section checkExistSection(String sName, String sName1);
    int addSection(Section section);
    List getSectionInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllSectionInfo();
    List searchSectionInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Section sk);
    List searchAllSectionInfo(@Param("sk") Section sk);
    int deleteSection(Section section);
    int modifySection(Section section);
    int deleteManysection(String[] sNos);
}
