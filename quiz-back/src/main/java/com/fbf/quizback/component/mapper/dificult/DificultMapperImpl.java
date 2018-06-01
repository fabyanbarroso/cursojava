package com.fbf.quizback.component.mapper.dificult;

import org.springframework.stereotype.Component;
import com.fbf.quizback.component.mapper.AbstractMapper;
import com.fbf.quizback.dto.DificultDTO;
import com.fbf.quizback.model.Dificult;

@Component
public class DificultMapperImpl extends AbstractMapper<Dificult, DificultDTO> implements DificultMapper{

	@Override
	public Class<? extends DificultDTO> dtoClazz() {
		// TODO Auto-generated method stub
		return DificultDTO.class;
	}

	@Override
	public Class<? extends Dificult> modelClazz() {
		// TODO Auto-generated method stub
		return Dificult.class;
	}

}
