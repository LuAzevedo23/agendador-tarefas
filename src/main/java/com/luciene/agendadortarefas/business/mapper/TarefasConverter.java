package com.luciene.agendadortarefas.business.mapper;

import com.luciene.agendadortarefas.business.dto.TarefasDTO;
import com.luciene.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
