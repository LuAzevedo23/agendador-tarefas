package com.luciene.agendadortarefas.business.mapper;

import com.luciene.agendadortarefas.business.dto.TarefasDTO;
import com.luciene.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
//nullValuePropertyMappingStrategy = usa estrategia de verificação, se for nulo ele pega os dados da outra,
// de forma automatica, ignorando todos os valores nulos
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
