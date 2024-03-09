package com.example.demo.mapper;

import com.example.demo.dto.Member;
import com.example.demo.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "memberID", source = "pkid")
    Member toDto(MemberEntity entity);

    @Mapping(target = "pkid", source = "memberID")
    MemberEntity toEntity(Member dto);
}
