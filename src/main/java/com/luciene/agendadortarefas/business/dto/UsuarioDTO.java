package com.luciene.agendadortarefas.business.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder //facilita a conversão dos dados
public class UsuarioDTO {

   private String email;
   private String senha;


}
