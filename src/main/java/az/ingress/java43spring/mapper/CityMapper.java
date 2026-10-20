package az.ingress.java43spring.mapper;

import az.ingress.java43spring.model.dto.CityDto;
import az.ingress.java43spring.model.entity.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDto toCityDto(City city);

    List<CityDto> toCityDtoList(List<City> cities);
}
