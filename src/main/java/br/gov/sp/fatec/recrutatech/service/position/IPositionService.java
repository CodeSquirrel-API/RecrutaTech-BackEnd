package br.gov.sp.fatec.recrutatech.service.position;

import br.gov.sp.fatec.recrutatech.entity.Position;

public interface IPositionService {

       public Position findByName(String name);
       
       public Position addPosition(Position position);
       
       public Position updatePosition(Position position);
       
       public Position deletePosition(Long id);
}
