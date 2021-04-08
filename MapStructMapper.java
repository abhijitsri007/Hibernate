package com.ul.api.mapper;

import com.ul.api.repository.model.ProjectStatus;
import com.ul.model.ProjectStatusRequest;
import com.ul.model.ProjectStatusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "status", target = "status"),
            @Mapping(target = "dateCreated", ignore = true),
            @Mapping(target = "archived", ignore = true),
    })
    ProjectStatus setProjectStatusRequestToProjectStatusMapper(ProjectStatusRequest projectStatusRequest);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "archived", target = "archived")
    })
    ProjectStatusResponse setProjectStatusToProjectStatusResponseMapper(ProjectStatus projectStatus);
}
