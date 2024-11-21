package com.luciene.agendadortarefas.business.mapper;

import com.luciene.agendadortarefas.business.dto.TarefasDTO;
import com.luciene.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target ="dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraTarefasEntity(List<TarefasDTO> dtos);

    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> entities);
}
