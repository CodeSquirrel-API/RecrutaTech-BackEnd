package br.gov.sp.fatec.recrutatech.service.attitude;

import java.util.List;

import br.gov.sp.fatec.recrutatech.entity.Attitude;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;

public interface IAttitudeService {

    public Attitude findById(Long id);

    public List<Attitude> getAllAttitudes();

    public List<Attitude> addAttitudes(List<Attitude> attitudes);

    public List<Attitude> updateAttitudes(List<Attitude> attitudes);

    public Attitude deleteAttitude(Long id);

    public List<Attitude> getAttitudeByExperienceType(ExperienceType experience);

}
