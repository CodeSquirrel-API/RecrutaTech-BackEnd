package br.gov.sp.fatec.recrutatech.service.position;

import java.util.List;

import br.gov.sp.fatec.recrutatech.entity.Position;

public interface IPositionService {

       public Position findByName(String name);

       public Position findById(Long id);

       public List<Position> findAll();

       public Position addPosition(Position position);

       public Position updatePosition(Position position);

       public Position deletePosition(Long id);
}
