package hu.unideb.inf.filmajanlo.service.mapper;

import hu.unideb.inf.filmajanlo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.filmajanlo.service.dto.RegisztracioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    FelhasznaloEntity regisztracioToEntity(RegisztracioDto dto);
}
